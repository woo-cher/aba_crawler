package com.abasystem.crawler.module;

import com.abasystem.crawler.Factory.RepositoryFactory;
import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Service.CrawlerService;
import com.abasystem.crawler.Service.NaverLoginService;
import com.abasystem.crawler.Service.Operator.ParseTemplate;
import com.abasystem.crawler.Service.PostInitializer;
import com.abasystem.crawler.Storage.Naver;
import com.abasystem.crawler.Strategy.BasicQueryStrategy;
import com.abasystem.crawler.Util.CommonsUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HappyHouseModuleTest {
    private static final Logger logger = LoggerFactory.getLogger(HappyHouseModuleTest.class);

    @Autowired
    private CrawlerService service;

    @Autowired
    private NaverLoginService loginService;

    @Autowired
    private RepositoryFactory factory;

    @Autowired
    private PostInitializer initializer;

    @Autowired
    @Qualifier("happyOperator")
    private ParseTemplate parseTemplate;

    @Autowired
    private Map<String, String> cookies;

    private Document document;
    private Elements elements;
    private List<? extends ModelMapper> properties;
    private BasicQueryStrategy queryStrategy;

    @Test
    @Transactional
    public void doCrawling() throws Exception {
        logger.warn("설마 쿠키 .. 너 : {}", cookies);

        // 1) 로그인
        boolean pass = loginService.doLogin(Naver.MOM_ID, Naver.MOM_PW);
        logger.info("로그인 결과 : " + pass);

        cookies = loginService.getLoginCookie();
        assertTrue(cookies.containsKey("NID_AUT"));
        assertTrue(cookies.containsKey("NID_SES"));
        assertTrue(cookies.containsKey("NID_JKL"));

        // 2) 행가집 카페에 KEYWORD 검색된 URL GET
        String searchUrl = CommonsUtils.getPostUrlWithSearch("직거래", Naver.HAPPY_CAFE_URL, Naver.HAPPY_SEARCH_BUTTON_XPATH);
        assertNotNull(searchUrl);

        document = Jsoup.connect(searchUrl).cookies(cookies).get();
        assertNotNull(document);

        // 3) 원하는 PAGE 입력 받아 게시글 initializing
        elements = initializer.initPosts(document, 1);
        assertNotNull(elements);
        assertThat(elements.size(), is(15));

        // 4) Service 클래스의 parseAll() 메소드 call
        properties = parseTemplate.parseAll(elements, cookies);
        logger.debug("Parsing Result: {}", properties);
        assertFalse(properties.isEmpty());

        // 5) Parsing 한 모든 게시글만큼 Loop -> DB 저장
        int row = 0;
        for (ModelMapper property : properties) {
            queryStrategy = factory.getTypeRepositoryCreator(property.getClass());
            row += queryStrategy.createProp(property);
        }
        logger.debug("INSERT ROW COUNT : {}", row);
        assertThat(row, is(not(0)));
        assertThat(row, is(properties.size()));

        // 6) 해당 객체를 csv 파일화
        assertTrue(service.writeAll(properties, "행가집(TEST)"));
    }
}