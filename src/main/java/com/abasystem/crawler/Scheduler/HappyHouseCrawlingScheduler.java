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
public class HappyHouseCrawlingScheduler extends CustomScheduler {
    private static final Logger logger = LoggerFactory.getLogger(HappyHouseCrawlingScheduler.class);

    @Autowired
    @Qualifier("momOperator")
    private ParseTemplate parseTemplate;

    @Transactional
    @Scheduled(cron = "0 51 13 ? * *")
    protected void crawler() throws Exception {
        try {
        logger.info("=================== 행가집 크롤러 실행 ========================");
        // 1) 네이버 로그인 및 쿠키값 저장
        loginService.doLogin(Naver.ID, Naver.PASSWORD);

        cookies = loginService.getLoginCookie();

        // 2) 피터팬 카페에 KEYWORD 검색된 URL GET
        String searchUrl = CommonsUtils.getPostUrlWithSearch("진주", Naver.HAPPY_CAFE_URL, Naver.HAPPY_SEARCH_BUTTON_XPATH);
        logger.info("키워드로 검색한 URL 획득 성공");
        Document document = Jsoup.connect(searchUrl).cookies(cookies).get();
        logger.info("Document 획득!");

        // 3) 원하는 PAGE 입력 받아 게시글 initializing
        Elements elements = initializer.initPosts(document, 3);
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
        service.writeAll(properties, "행가집");
        logger.info("Crawling Success!");

        // 7) 스케줄링 로그 저장
        repository.insertLog(row);
        logger.info("Save log");
    } catch (Exception e) {
        logger.error("에러 발생ㅠㅠ {}", e);
    } finally {
            properties.clear();
        }
    }
}
