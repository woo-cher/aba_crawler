package com.abasystem.crawler.module;

import com.abasystem.crawler.Factory.RepositoryFactory;
import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Service.NaverLoginService;
import com.abasystem.crawler.Service.CrawlerService;
import com.abasystem.crawler.Storage.Naver;
import com.abasystem.crawler.Strategy.BasicQueryStrategy;
import com.abasystem.crawler.Util.CommonsUtils;
import com.gargoylesoftware.htmlunit.WebClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NaverCrawlerModuleTest {
    private static final Logger logger = LoggerFactory.getLogger(NaverCrawlerModuleTest.class);

    @Autowired
    private CrawlerService service;

    @Autowired
    private NaverLoginService loginService;

    @Autowired
    private RepositoryFactory factory;

    @Autowired
    private Map<String, String> cookies;

    @Autowired
    private WebClient webClient;
    private Document document;
    private Elements elements;
    private List<ModelMapper> properties;
    private BasicQueryStrategy queryStrategy;

    @Test
    @Transactional
    public void doCrawling() throws Exception {
        // 1) 네이버 로그인 및 쿠키값 저장
        loginService.doLogin(webClient, Naver.ID, Naver.PASSWORD);
        assertTrue(loginService.isLogin());

        cookies = loginService.getLoginCookie(webClient);
        assertTrue(cookies.containsKey("NID_AUT"));
        assertTrue(cookies.containsKey("NID_SES"));
        assertTrue(cookies.containsKey("NID_JKL"));

        // 2) 피터팬 카페에 KEYWORD 검색된 URL GET
        String searchUrl = CommonsUtils.getPostsUrlWithKeyword("진주");
        assertNotNull(searchUrl);

        document = Jsoup.connect(searchUrl).cookies(cookies).get();
        assertNotNull(document);

        // 3) 원하는 PAGE 입력 받아 게시글 initializing
        elements = service.initPosts(document, 3);
        assertNotNull(elements);
        assertThat(elements.size(), is(45));

        // 4) Service 클래스의 parseAll() 메소드 call
        properties = service.parseAll(elements, cookies);
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
        assertTrue(service.writeAll(properties));
    }
}
