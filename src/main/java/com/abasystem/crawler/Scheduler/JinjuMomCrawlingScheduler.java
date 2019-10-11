package com.abasystem.crawler.Scheduler;

import com.abasystem.crawler.Factory.RepositoryFactory;
import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Repository.SchedulerRepository;
import com.abasystem.crawler.Service.CrawlerService;
import com.abasystem.crawler.Service.NaverLoginService;
import com.abasystem.crawler.Storage.Naver;
import com.abasystem.crawler.Strategy.BasicQueryStrategy;
import com.gargoylesoftware.htmlunit.WebClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class JinjuMomCrawlingScheduler {
    private static final Logger logger = LoggerFactory.getLogger(JinjuMomCrawlingScheduler.class);

    @Autowired
    private CrawlerService service;

    @Autowired
    private NaverLoginService loginService;

    @Autowired
    private RepositoryFactory factory;

    @Autowired
    private WebClient webClient;

    @Autowired
    private SchedulerRepository repository;

    private Map<String, String> cookies;
    private List<ModelMapper> properties;
    private BasicQueryStrategy queryStrategy;

    protected void crawling() throws Exception {
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);

        // 1) 로그인
        boolean pass = loginService.doLogin(webClient, Naver.ID, Naver.PASSWORD);
        logger.info("로그인 결과 : " + pass);

        cookies = loginService.getLoginCookie(webClient);
        Document document = Jsoup.connect(Naver.MOM_DIRECT_URL).cookies(cookies).get();

        // 2) 원하는 PAGE 입력 받아 게시글 initializing
        Elements elements = service.initPosts(document, 4);
        logger.info("Elements 획득!");
    }
}
