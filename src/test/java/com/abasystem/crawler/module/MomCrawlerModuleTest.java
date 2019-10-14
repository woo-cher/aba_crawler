package com.abasystem.crawler.module;

import com.abasystem.crawler.Factory.RepositoryFactory;
import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Service.CrawlerService;
import com.abasystem.crawler.Service.NaverLoginService;
import com.abasystem.crawler.Service.Operator.ParseTemplate;
import com.abasystem.crawler.Service.PostInitializer;
import com.abasystem.crawler.Storage.Naver;
import com.abasystem.crawler.Strategy.BasicQueryStrategy;
import com.gargoylesoftware.htmlunit.WebClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.AfterClass;
import org.junit.BeforeClass;
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

import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MomCrawlerModuleTest {
    private static final Logger logger = LoggerFactory.getLogger(MomCrawlerModuleTest.class);

    @Autowired
    private CrawlerService service;

    @Autowired
    private NaverLoginService loginService;

    @Autowired
    private RepositoryFactory factory;

    @Autowired
    private Map<String, String> cookies;

    @Autowired
    private PostInitializer initializer;

    @Autowired
    @Qualifier("momOperator")
    private ParseTemplate parseTemplate;

    private static WebClient webClient;

    private List<? extends ModelMapper> properties;
    private BasicQueryStrategy queryStrategy;

    @BeforeClass
    public static void before() {
        webClient = new WebClient();
    }

    @AfterClass
    public static void after() {
        webClient.close();
    }

    @Test
    @Transactional
    public void doCrawling() throws Exception {
        logger.warn("설마 쿠키 .. 너 : {}", cookies);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);

        // 1) 로그인
        boolean pass = loginService.doLogin(webClient, Naver.MOM_ID, Naver.MOM_PW);
        logger.info("로그인 결과 : " + pass);

        cookies = loginService.getLoginCookie(webClient);
        Document document = Jsoup.connect(Naver.MOM_DIRECT_URL).cookies(cookies).get();

        // 3) 원하는 PAGE 입력 받아 게시글 initializing
        Elements elements = initializer.initPosts(document, 3);
        logger.info("Elements 획득! {}", elements);

        // 4) Service 클래스의 parseAll() 메소드 call
        properties = parseTemplate.parseAll(elements, cookies);
        logger.info("Parsing Success ... {}", properties);

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
        assertTrue(service.writeAll(properties, "진주아지매"));
    }
}
