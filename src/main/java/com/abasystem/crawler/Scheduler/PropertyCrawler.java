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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
public class PropertyCrawler {
    private static final Logger logger = LoggerFactory.getLogger(PropertyCrawler.class);

    @Autowired
    private PeterPanService service;

    @Autowired
    private NaverLoginService loginService;

    @Autowired
    private RepositoryFactory factory;

    @Autowired
    private WebClient webClient;

    private Map<String, String> cookies;
    private List<ModelMapper> properties;
    private BasicQueryStrategy queryStrategy;

    @Transactional
    @Scheduled(fixedDelay = 15000)
    public void crawling() throws Exception {
        // 1) 로그인
        boolean pass = loginService.doLogin(webClient, Naver.ID, Naver.PASSWORD);
        logger.error("로그인? : " + pass);

        cookies = loginService.getLoginCookie(webClient);

        // 2) 피터팬 카페에 KEYWORD 검색된 URL GET
        String searchUrl = CommonsUtils.getPostsUrlWithKeyword("진주", webClient);

        Document document = Jsoup.connect(searchUrl).cookies(cookies).get();

        // 3) 원하는 PAGE 입력 받아 게시글 initializing
        Elements elements = service.initPosts(document, 1);

        // 4) Service 클래스의 parseAll() 메소드 call
        properties = service.parseAll(elements, cookies);
        logger.info("Parsing Result: {}", properties);

        // 5) Parsing 한 모든 게시글만큼 Loop -> DB 저장
        int row = 0;
        for (ModelMapper property : properties) {
            queryStrategy = factory.getTypeRepositoryCreator(property.getClass());
            row += queryStrategy.createProp(property);
        }
        logger.info("INSERT ROW COUNT : {}", row);

        // 6) 해당 객체를 csv 파일화
        service.writeAll(properties);
        logger.info("피터팬 크롤링 실행 완료");

        properties.clear();
    }
}
