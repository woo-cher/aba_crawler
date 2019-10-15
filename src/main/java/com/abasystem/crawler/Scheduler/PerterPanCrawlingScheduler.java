package com.abasystem.crawler.Scheduler;

import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Service.Operator.ParseTemplate;
import com.abasystem.crawler.Storage.Naver;
import com.abasystem.crawler.Util.CommonsUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PerterPanCrawlingScheduler extends CustomScheduler {
    private static final Logger logger = LoggerFactory.getLogger(PerterPanCrawlingScheduler.class);

    @Autowired
    @Qualifier("peterOperator")
    private ParseTemplate parseTemplate;

    @Transactional
    @Scheduled(cron = "0 0 21 ? * 3")
//    @Scheduled(fixedRate = 15000)
    public void crawler() throws Exception {
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);

        // 1) 로그인
        boolean pass = loginService.doLogin(webClient, Naver.ID, Naver.PASSWORD);
        logger.info("로그인 결과 : " + pass);

        cookies = loginService.getLoginCookie(webClient);

        // 2) 피터팬 카페에 KEYWORD 검색된 URL GET
        String searchUrl = CommonsUtils.getPostsUrlWithKeyword("진주");
        logger.info("키워드로 검색한 URL 획득 성공");
        Document document = Jsoup.connect(searchUrl).cookies(cookies).get();
        logger.info("Document 획득!");

        // 3) 원하는 PAGE 입력 받아 게시글 initializing
        Elements elements = initializer.initPosts(document, 2);
        logger.info("Elements 획득!");

        // 4) Service 클래스의 parseAll() 메소드 call
        properties = parseTemplate.parseAll(elements, cookies);
        logger.info("Parsing Success ...");

        // 5) Parsing 한 모든 게시글만큼 Loop -> DB 저장
        int row = 0;
        for (ModelMapper property : properties) {
            queryStrategy = factory.getTypeRepositoryCreator(property.getClass());
            row += queryStrategy.createProp(property);
        }
        logger.info("INSERT ROW COUNT : {}", row);

        // 6) 해당 객체를 csv 파일화
        service.writeAll(properties, "피터팬");
        logger.info("Crawling Success!");

        // 7) 스케줄링 로그 저장
        repository.insertLog(row);
        logger.info("Save log");

        properties.clear();
        cookies.clear();
        webClient.close();
    }
}
