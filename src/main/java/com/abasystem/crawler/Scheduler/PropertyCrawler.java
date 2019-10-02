package com.abasystem.crawler.Scheduler;

import com.abasystem.crawler.Service.NaverLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PropertyCrawler {
    private static final Logger logger = LoggerFactory.getLogger(PropertyCrawler.class);

    @Autowired
    private NaverLoginService service;

    @Scheduled
    public void test() {
        logger.info("Scheduled initialize ... ");
        logger.info("Current Thread : {}", Thread.currentThread().getName());
    }

    public void crawling() {
        // 로직 Go !!
    }
}
