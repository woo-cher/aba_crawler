package com.abasystem.crawler.module;

import com.abasystem.crawler.Scheduler.WithoutSearchMultipleScheduler;
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
    private WithoutSearchMultipleScheduler scheduler;

//    @Test
//    @Transactional
//    public void peterPan() throws Exception {
//        scheduler.peterPanCrawler();
//    }

    @Test
    @Transactional
    public void chunCheon() throws Exception {
        scheduler.chuncheonCrawler();
    }

    @Test
    @Transactional
    public void goodShop() throws Exception {
        scheduler.goodShopCrawler();
    }

    @Test
    @Transactional
    public void boodongDirect() throws Exception {
        scheduler.boodongDirectCrawler();
    }
}