package com.abasystem.crawler.Scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PropertyCrawler {
    private static final Logger logger = LoggerFactory.getLogger(PropertyCrawler.class);

    public void test() {
        logger.info("Scheduled initialize ... ");
        logger.info("Current Thread : {}", Thread.currentThread().getName());
    }

    public void crawling() {

    }
}
