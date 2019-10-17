package com.abasystem.crawler.module;

import com.abasystem.crawler.Scheduler.HappyHouseCrawlingScheduler;
import com.abasystem.crawler.Scheduler.JinjuMomCrawlingScheduler;
import com.abasystem.crawler.Scheduler.PerterPanCrawlingScheduler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrawlerModuleTest {
    private static final Logger logger = LoggerFactory.getLogger(CrawlerModuleTest.class);

    @Autowired
    private JinjuMomCrawlingScheduler momScheduler;

    @Autowired
    private HappyHouseCrawlingScheduler happyScheduler;

    @Autowired
    private PerterPanCrawlingScheduler peterPanScheduler;

    @Test
    @Transactional
    public void peterPanCrawler() {
        peterPanScheduler.peterPanCrawler();
    }

    @Test
    @Transactional
    public void momCrawler() {
        momScheduler.momCrawler();
    }

    @Test
    @Transactional
    public void happyCrawler() {
        happyScheduler.happyHouseCrawler();
    }
}
