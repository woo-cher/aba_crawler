package com.abasystem.crawler.Scheduler;

import com.abasystem.crawler.Builder.CrawlerDtoBuilder;
import com.abasystem.crawler.Service.Initializer.DivTagPostInitializer;
import com.abasystem.crawler.Service.Initializer.SpanTagPostInitializer;
import com.abasystem.crawler.Service.Operator.ParseTemplate;
import com.abasystem.crawler.Storage.Naver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WithoutSearchMultipleScheduler extends CrawlerTemplate {
    private static final Logger logger = LoggerFactory.getLogger(WithoutSearchMultipleScheduler.class);

    @Autowired
    @Qualifier("CategoryOfPropertyOperator")
    private ParseTemplate parseTemplate;

    public void chuncheonCrawler() throws Exception {
        Map<String, Integer> chuncheonMap = categoryMapFactory.getChuncheonCategoryMap();
        logger.info("──── Chuncheon Multiple Crawler initialize\n");

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.ID, Naver.PASSWORD, this.parseTemplate, "춘천부동산")
                        .build(), chuncheonMap, DivTagPostInitializer.class
        );

        logger.info("──── End Chuncheon Multiple Crawling\n");
    }

    public void goodShopCrawler() throws Exception {
        Map<String, Integer> goodShopMap = categoryMapFactory.getGoodShopCategoryMap();
        logger.info("──── GoodShop Multiple Crawler initialize\n");

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.ID, Naver.PASSWORD, this.parseTemplate, "좋은점포구하기")
                        .build(), goodShopMap, DivTagPostInitializer.class
        );

        logger.info("──── End GoodShop Multiple Crawling\n");
    }

    public void peterPanCrawler() throws Exception {
        Map<String, Integer> peterPanMap = categoryMapFactory.getPeterPanCategoryMap();
        logger.info("──── PeterPan Multiple Crawler initialize\n");

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.ID, Naver.PASSWORD, this.parseTemplate, "피터팬")
                        .build(), peterPanMap, DivTagPostInitializer.class
        );

        logger.info("──── End PeterPan Multiple Crawling\n");
    }

    public void boodongDirectCrawler() throws Exception {
        Map<String, Integer> boodongDirectMap = categoryMapFactory.getBoodongDirectCategoryMap();
        logger.info("──── BoodongDirect Multiple Crawler initialize\n");

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.ID, Naver.PASSWORD, this.parseTemplate, "부동산직거래")
                        .build(), boodongDirectMap, SpanTagPostInitializer.class
        );

        logger.info("──── End BoodongDirect Multiple Crawling\n");
    }

    public void changWonCrawler() throws Exception {
        Map<String, Integer> changWonMap = categoryMapFactory.getChangWonCategoryMap();
        logger.info("──── ChangWon Multiple Crawler initialize\n");

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.ID, Naver.PASSWORD, this.parseTemplate, "창원부동산직거래")
                        .build(), changWonMap, SpanTagPostInitializer.class
        );

        logger.info("──── End ChangWon Multiple Crawling\n");
    }

    public void busanRoomCrawler() throws Exception {
        Map<String, Integer> busanRoomMap = categoryMapFactory.getBusanRoomCategoryMap();
        logger.info("──── BusanRoom Multiple Crawler initialize\n");

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.ID, Naver.PASSWORD, this.parseTemplate, "부산부동산직거래")
                        .build(), busanRoomMap, SpanTagPostInitializer.class
        );

        logger.info("──── End BusanRoom Multiple Crawling\n");
    }

    public void cheonanDirectCrawler() throws Exception {
        Map<String, Integer> cheonanDirectMap = categoryMapFactory.getCheonanDirectCategoryMap();
        logger.info("──── CheonanDirect Multiple Crawler initialize\n");

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.ID, Naver.PASSWORD, this.parseTemplate, "천안부동산직거래")
                       .build(), cheonanDirectMap, SpanTagPostInitializer.class
        );

        logger.info("──── End CheonanDirect Multiple Crawling\n");
    }

    public void yangSanMomCrawler() throws Exception {
        Map<String, Integer> yangSanMap = categoryMapFactory.getYangSanMomCategoryMap();
        logger.info("──── YangSanMom Multiple Crawler initialize\n");

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.ID, Naver.PASSWORD, this.parseTemplate, "러브양산맘")
                        .build(), yangSanMap, DivTagPostInitializer.class
        );

        logger.info("──── End YangSanMom Multiple Crawling\n");
    }
}