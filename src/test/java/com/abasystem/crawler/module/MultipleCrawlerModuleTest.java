package com.abasystem.crawler.module;

import com.abasystem.crawler.Scheduler.ChuncheonCrawlingScheduler;
import com.abasystem.crawler.Scheduler.GoodShopCrawlingScheduler;
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
public class MultipleCrawlerModuleTest {
    private static final Logger logger = LoggerFactory.getLogger(MultipleCrawlerModuleTest.class);

    @Autowired
    private PerterPanCrawlingScheduler peterPanScheduler;

    @Autowired
    private ChuncheonCrawlingScheduler chuncheonScheduler;

    @Autowired
    private GoodShopCrawlingScheduler goodShopScheduler;

    @Test
    @Transactional
    public void peterPanMultipleCrawler() throws Exception {
        peterPanScheduler.categoriesCrawler();
    }

    @Test
    @Transactional
    public void chuncheonMultipleCrawler() throws Exception {
        chuncheonScheduler.categoriesCrawler();
    }

    @Test
    @Transactional
    public void goodShopMultipleCrawler() throws Exception {
        goodShopScheduler.categoriesCrawler();
    }
}