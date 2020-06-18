package com.abasystem.crawler.unit;

import com.abasystem.crawler.builder.RegularPostBuilder;
import com.abasystem.crawler.factory.PostInitializerFactory;
import com.abasystem.crawler.model.property.IrregularProperty;
import com.abasystem.crawler.model.property.RegularProperty;
import com.abasystem.crawler.api.service.Initializer.DivTagPostInitializer;
import com.abasystem.crawler.api.service.NaverLoginService;
import com.abasystem.crawler.api.service.operator.ParseTemplate;
import com.abasystem.crawler.model.type.NaverCafeType;
import com.abasystem.crawler.storage.Naver;
import com.abasystem.crawler.strategy.ValidationStrategy;
import com.gargoylesoftware.htmlunit.WebClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeterPanParseTest {
    private static final Logger logger = LoggerFactory.getLogger(PeterPanParseTest.class);

    private static final String REGULAR_POST = "https://cafe.naver.com/ArticleRead.nhn?clubid=10322296&page=1&inCafeSearch=true&searchBy=1&query=%C1%F8%C1%D6&includeAll=&exclude=&include=&exact=&searchdate=all&media=0&sortBy=date&articleid=12953032&referrerAllArticles=true";
    private static final String IRREGULAR_POST = "https://cafe.naver.com/ArticleRead.nhn?clubid=10322296&page=2&inCafeSearch=true&searchBy=1&query=%C1%F8%C1%D6&includeAll=&exclude=&include=&exact=&searchdate=all&media=0&sortBy=date&articleid=12885000&referrerAllArticles=true";

    private static NaverLoginService service;

    @Autowired
    private Map<String, String> cookies;

    @Autowired
    private ValidationStrategy validationStrategy;

    @Autowired
    @Qualifier("CategoryWithSearchOperator")
    private ParseTemplate parseTemplate;

    @Autowired
    private PostInitializerFactory factory;

    private Elements elements;

    @Before
    public void setup() {
        cookies = service.getLoginCookie();
    }

    @BeforeClass
    public static void initialize() throws Exception{
        service = new NaverLoginService();
        service.webClient = new WebClient();
        service.doLogin(Naver.account.getUserId(), Naver.account.getPasswd());
    }

    @Test
    public void postValidator() throws IOException {
        Document doc = Jsoup.connect(REGULAR_POST)
                .cookies(cookies)
                .get();

        elements = doc.select("#main-area");

        logger.debug(elements.text());

        assertTrue(validationStrategy.isPropertyPost(elements));
        assertFalse(validationStrategy.isInvalidPost(elements));
    }

    @Test
    public void isInContactPostValidation() throws IOException {
        elements = Jsoup.connect("https://cafe.naver.com/ArticleRead.nhn?clubid=10322296&page=1&inCafeSearch=true&searchBy=1&query=%C1%F8%C1%D6&includeAll=&exclude=&include=&exact=&searchdate=all&media=0&sortBy=date&articleid=13049652&referrerAllArticles=true")
                .cookies(cookies)
                .get()
                .select("#tbody");

        assertTrue(validationStrategy.isExistPhoneNumber(elements));

        elements = Jsoup.connect(IRREGULAR_POST)
                .cookies(cookies)
                .get()
                .select("#tbody");

        assertFalse(validationStrategy.isExistPhoneNumber(elements));
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
                .select(Naver.POST_TABLE_TBODY);

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
                .options(elements.select("#pp_options").text())
                .heatingType(elements.select("#pp_heating").text())
                .description(elements.select("#pp_description").text())
                .build();

        logger.debug("Parsed post : {}", post);
        assertNotNull(post);
    }

    @Test
    public void initPosts() throws IOException {
        String MOCK_URL = "https://cafe.naver.com/ArticleSearchList.nhn?search.clubid=10322296&search.searchBy=0&search.query=%C1%F8%C1%D6";
        Document doc = Jsoup.connect(MOCK_URL).get();
        elements = factory.getPostCreator(DivTagPostInitializer.class).initPosts(doc, 3);

        for (Element el : elements) {
            logger.debug(el.toString());
        }

        assertThat(elements.size(), is(45));
    }

    @Test
    public void parsePosts() throws IOException {
        String MOCK_URL = "https://cafe.naver.com/ArticleSearchList.nhn?search.clubid=10322296&search.searchBy=0&search.query=%C1%F8%C1%D6";
        Document doc = Jsoup.connect(MOCK_URL).get();
        elements = factory.getPostCreator(DivTagPostInitializer.class).initPosts(doc, 1);

        logger.debug("el ? {}", elements.text());
        logger.debug("크롤링 결과 : {}", parseTemplate.parseAll(elements, cookies, DivTagPostInitializer.class, NaverCafeType.PETERPAN));
    }

    @Test
    public void parseIrregularPost() throws IOException {
        IrregularProperty post;

        elements = Jsoup.connect(IRREGULAR_POST)
                .cookies(cookies)
                .get()
                .select("#tbody");

        post = new IrregularProperty("TITLE", elements.select("#tbody").text(), "DATE", "URL", "PHONE");
        logger.debug("Post? {}", post);
    }
}
