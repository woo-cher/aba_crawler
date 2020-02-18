package com.abasystem.crawler.module;

import com.abasystem.crawler.Scheduler.WithoutSearchMultipleScheduler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleCrawlerModuleTest {
    private static final Logger logger = LoggerFactory.getLogger(MultipleCrawlerModuleTest.class);

    @Autowired
    private WithoutSearchMultipleScheduler scheduler;

    @Test
    public void peterPan() throws Exception {
        scheduler.peterPanCrawler();
    }

    @Test
    public void chunCheon() throws Exception {
        scheduler.chuncheonCrawler();
    }

    @Test
    public void goodShop() throws Exception {
        scheduler.goodShopCrawler();
    }

    @Test
    public void boodongDirect() throws Exception {
        scheduler.boodongDirectCrawler();
    }

    @Test
    public void changWon() throws Exception {
        scheduler.changWonCrawler();
    }

    @Test
    public void busanRoom() throws Exception {
        scheduler.busanRoomCrawler();
    }

    @Test
    public void CheonanDirect() throws Exception {
        scheduler.cheonanDirectCrawler();
    }

    @Test
    public void YangSanMom() throws Exception {
        scheduler.yangSanMomCrawler();
    }
}
