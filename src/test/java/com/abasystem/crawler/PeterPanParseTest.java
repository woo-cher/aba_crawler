package com.abasystem.crawler;

import com.abasystem.crawler.Builder.RegularPostBuilder;
import com.abasystem.crawler.Model.PeterPan.IrregularProperty;
import com.abasystem.crawler.Model.PeterPan.RegularProperty;
import com.abasystem.crawler.Service.Converter.ModelConverter;
import com.abasystem.crawler.Service.NaverLoginService;
import com.abasystem.crawler.Service.PeterPanService;
import com.abasystem.crawler.Strategy.ValidationStrategy;
import com.gargoylesoftware.htmlunit.WebClient;
import com.google.gson.JsonObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeterPanParseTest {
    private static final Logger logger = LoggerFactory.getLogger(PeterPanParseTest.class);

    private static final String REGULAR_POST = "https://cafe.naver.com/ArticleRead.nhn?clubid=10322296&page=1&inCafeSearch=true&searchBy=1&query=%C1%F8%C1%D6&includeAll=&exclude=&include=&exact=&searchdate=all&media=0&sortBy=date&articleid=12953032&referrerAllArticles=true";
    private static final String IRREGULAR_POST = "https://cafe.naver.com/ArticleRead.nhn?clubid=10322296&page=2&inCafeSearch=true&searchBy=1&query=%C1%F8%C1%D6&includeAll=&exclude=&include=&exact=&searchdate=all&media=0&sortBy=date&articleid=12885000&referrerAllArticles=true";

    private static NaverLoginService service;
    private static WebClient webClient;

    @Autowired
    private static Map<String, String> cookies;

    @Autowired
    private ValidationStrategy validationStrategy;

    @Autowired
    private PeterPanService pService;

    private Elements elements;

    @BeforeClass
    public static void initialize() throws Exception {
        webClient = new WebClient();
        service = new NaverLoginService();
        service.doLogin(webClient, LoginTest.id, LoginTest.pw);
        cookies = service.makeLoginCookie(webClient);
    }

    @AfterClass
    public static void after() {
        cookies.clear();
    }

    @Test
    public void postValidator() throws IOException {
        Document doc = Jsoup.connect(REGULAR_POST)
                .cookies(cookies)
                .get();

        elements = doc.select(".inbox");

        logger.debug(elements.text());

        assertFalse(validationStrategy.postValidate(elements));
    }

    @Test
    public void checkPostType() throws IOException {
        logger.debug("쿠키는 ?{}", cookies);
        elements = Jsoup.connect(REGULAR_POST)
                .cookies(cookies)
                .get()
                .select("#tbody");

        logger.debug("elements : {}", elements);
        assertTrue(validationStrategy.isRegularPost(elements));
    }

    @Test
    public void parsePost() throws IOException {
        logger.debug("쿠키는 ?{}", cookies);
        RegularProperty post;

        elements = Jsoup.connect(REGULAR_POST)
                .cookies(cookies)
                .get()
                .select("#tbody table tbody");

        post = new RegularPostBuilder("TITLE", REGULAR_POST, "DATE")
                .address(elements.select("#pp_location").text())
                .price(elements.select("#pp_fee").text())
                .managementPrice(elements.select("#pp_maintenance").text())
                .phone(elements.select("#pp_contact").text())
                .propertyType(elements.select("#pp_building_type").text())
                .roomCount(elements.select("#pp_room_count").text())
                .floor(elements.select("#pp_floor").text())
                .managementCategory(elements.select("#pp_maintenance_include").text())
                .movePossibleDate(elements.select("#pp_moving_date").text())
                .option(elements.select("#pp_options").text())
                .heatingType(elements.select("#pp_heating").text())
                .description(elements.select("#pp_description").text())
                .build();

        logger.debug("Parsed post : {}", post);

        JsonObject object = ModelConverter.convertModelToJsonObject(post);
        logger.debug("Result : " + object.get("제목"));
    }

    @Test
    public void initPosts() throws IOException {
        String MOCK_URL = "https://cafe.naver.com/ArticleSearchList.nhn?search.clubid=10322296&search.searchBy=0&search.query=%C1%F8%C1%D6";
        Document doc = Jsoup.connect(MOCK_URL).get();
        elements = pService.initPosts(doc, 3);

        for (Element el : elements) {
            logger.debug(el.toString());
        }

        assertThat(elements.size(), is(45));
    }

    @Test
    public void parsePosts() throws IOException {
        String MOCK_URL = "https://cafe.naver.com/ArticleSearchList.nhn?search.clubid=10322296&search.searchBy=0&search.query=%C1%F8%C1%D6";
        Document doc = Jsoup.connect(MOCK_URL).get();
        elements = pService.initPosts(doc, 3);

        logger.debug("el ? {}", elements.text());
        logger.debug("크롤링 결과 : {}", pService.parseAll(elements, cookies));
    }

    @Test
    public void parseIrregularPost() throws IOException {
        IrregularProperty post;

        elements = Jsoup.connect(IRREGULAR_POST)
                .cookies(cookies)
                .get()
                .select("#tbody");

        post = new IrregularProperty("TITLE", elements.select("#tbody").text(), "DATE", "URL");
        logger.debug("Post? {}", post);
    }
}