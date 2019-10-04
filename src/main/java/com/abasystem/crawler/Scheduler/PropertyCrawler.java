package com.abasystem.crawler.Scheduler;

import com.abasystem.crawler.Factory.RepositoryFactory;
import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Service.NaverLoginService;
import com.abasystem.crawler.Service.PeterPanService;
import com.abasystem.crawler.Storage.Naver;
import com.abasystem.crawler.Strategy.BasicQueryStrategy;
import com.abasystem.crawler.Util.CommonsUtils;
import com.gargoylesoftware.htmlunit.WebClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Component
public class PropertyCrawler {
    private static final Logger logger = LoggerFactory.getLogger(PropertyCrawler.class);

    private Document document;
    private Elements elements;
    private List<ModelMapper> properties;
    private BasicQueryStrategy queryStrategy;

    @Autowired
    private PeterPanService service;

    @Autowired
    private NaverLoginService loginService;

    @Autowired
    private RepositoryFactory factory;

    @Autowired
    private Map<String, String> cookies;

    @Autowired
    private WebClient webClient;

    @Transactional
    @PostConstruct
    public void crawling() throws Exception {
        // 1) 네이버 로그인 및 쿠키값 저장
        loginService.doLogin(webClient, Naver.ID, Naver.PASSWORD);

        cookies = loginService.getLoginCookie(webClient);

        // 2) 피터팬 카페에 KEYWORD 검색된 URL GET
        String searchUrl = CommonsUtils.getPostsUrlWithKeyword("진주", webClient);

        document = Jsoup.connect(searchUrl).cookies(cookies).get();

        // 3) 원하는 PAGE 입력 받아 게시글 initializing
        elements = service.initPosts(document, 3);

        // 4) Service 클래스의 parseAll() 메소드 call
        properties = service.parseAll(elements, cookies);
        logger.debug("Parsing Result: {}", properties);

        // 5) Parsing 한 모든 게시글만큼 Loop -> DB 저장
        int row = 0;
        for (ModelMapper property : properties) {
            queryStrategy = factory.getTypeRepositoryCreator(property.getClass());
            row += queryStrategy.createProp(property);
        }
        logger.debug("INSERT ROW COUNT : {}", row);

        // 6) 해당 객체를 csv 파일화
        service.writeAll(properties);
    }
}
