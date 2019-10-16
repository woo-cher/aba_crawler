package com.abasystem.crawler.Scheduler;

import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Service.Operator.ParseTemplate;
import com.abasystem.crawler.Storage.Naver;
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
public class JinjuMomCrawlingScheduler extends CustomScheduler {
    private static final Logger logger = LoggerFactory.getLogger(JinjuMomCrawlingScheduler.class);

    @Autowired
    @Qualifier("momOperator")
    private ParseTemplate parseTemplate;

    @Transactional
    @Scheduled(cron = "0 0 21 ? * 3")
    protected void crawler() throws Exception {
        logger.warn("설마 쿠키 .. 너 : {}", cookies);

        // 1) 로그인
        boolean pass = loginService.doLogin(Naver.MOM_ID, Naver.MOM_PW);
        logger.info("로그인 결과 : " + pass);

        cookies = loginService.getLoginCookie();
        Document document = Jsoup.connect(Naver.MOM_DIRECT_URL).cookies(cookies).get();

        // 3) 원하는 PAGE 입력 받아 게시글 initializing
        Elements elements = initializer.initPosts(document, 4);
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

        // 6) 해당 객체를 csv 파일화
        service.writeAll(properties, "진주아지매");

        // 7) 스케줄링 로그 저장
        repository.insertLog(row);
        logger.info("Save log");

        properties.clear();
        cookies.clear();
    }
}
