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
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JinjuMomCrawlingScheduler extends CustomScheduler {
    private static final Logger logger = LoggerFactory.getLogger(JinjuMomCrawlingScheduler.class);

    @Autowired
    @Qualifier("momOperator")
    private ParseTemplate parseTemplate;

    @Transactional
    protected void crawler() throws Exception {
        logger.warn("설마 쿠키 .. 너 : {}", cookies);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);

        // 1) 로그인
        boolean pass = loginService.doLogin(webClient, Naver.MOM_ID, Naver.MOM_PW);
        logger.info("로그인 결과 : " + pass);

        cookies = loginService.getLoginCookie(webClient);
        Document document = Jsoup.connect(Naver.MOM_DIRECT_URL).cookies(cookies).get();

        // 3) 원하는 PAGE 입력 받아 게시글 initializing
        Elements elements = initializer.initPosts(document, 1);
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
    }
}
