package com.abasystem.crawler.scheduler;

import com.abasystem.crawler.builder.CrawlerDtoBuilder;
import com.abasystem.crawler.api.service.Initializer.DivTagPostInitializer;
import com.abasystem.crawler.api.service.Initializer.SpanTagPostInitializer;
import com.abasystem.crawler.api.service.operator.ParseTemplate;
import com.abasystem.crawler.model.type.NaverCafeType;
import com.abasystem.crawler.storage.Naver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WithoutSearchMultipleScheduler extends CrawlerTemplate {
    private static final Logger logger = LoggerFactory.getLogger(WithoutSearchMultipleScheduler.class);

    @Autowired
    @Qualifier("CategoryOfPropertyOperator")
    private ParseTemplate parseTemplate;

    @Scheduled(cron = "0 0 11 ? * 7")
    public void chuncheonCrawler() throws Exception {
        Map<String, Integer> chuncheonMap = categoryMapFactory.getChuncheonCategoryMap();

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.account, this.parseTemplate, "춘천부동산")
                        .build(), chuncheonMap, DivTagPostInitializer.class, NaverCafeType.UNKNOWN
        );
    }

    @Scheduled(cron = "0 0 12 ? * 7")
    public void goodShopCrawler() throws Exception {
        Map<String, Integer> goodShopMap = categoryMapFactory.getGoodShopCategoryMap();

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.account, this.parseTemplate, "좋은점포구하기")
                        .build(), goodShopMap, DivTagPostInitializer.class, NaverCafeType.UNKNOWN
        );
    }

    @Scheduled(cron = "0 0 13 ? * 7")
    public void peterPanCrawler() throws Exception {
        Map<String, Integer> peterPanMap = categoryMapFactory.getPeterPanCategoryMap();

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.account, this.parseTemplate, "피터팬의좋은방구하기")
                        .build(), peterPanMap, DivTagPostInitializer.class, NaverCafeType.PETERPAN
        );
    }

    @Scheduled(cron = "0 0 15 ? * 7")
    public void boodongDirectCrawler() throws Exception {
        Map<String, Integer> boodongDirectMap = categoryMapFactory.getBoodongDirectCategoryMap();

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.account, this.parseTemplate, "부동산직거래")
                        .build(), boodongDirectMap, SpanTagPostInitializer.class, NaverCafeType.UNKNOWN
        );
    }

    @Scheduled(cron = "0 0 16 ? * 7")
    public void changWonCrawler() throws Exception {
        Map<String, Integer> changWonMap = categoryMapFactory.getChangWonCategoryMap();

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.account, this.parseTemplate, "창원부동산직거래")
                        .build(), changWonMap, SpanTagPostInitializer.class, NaverCafeType.UNKNOWN
        );
    }

    @Scheduled(cron = "0 0 17 ? * 7")
    public void busanRoomCrawler() throws Exception {
        Map<String, Integer> busanRoomMap = categoryMapFactory.getBusanRoomCategoryMap();

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.account, this.parseTemplate, "부산부동산직거래")
                        .build(), busanRoomMap, SpanTagPostInitializer.class, NaverCafeType.UNKNOWN
        );
    }

    @Scheduled(cron = "0 0 18 ? * 7")
    public void cheonanDirectCrawler() throws Exception {
        Map<String, Integer> cheonanDirectMap = categoryMapFactory.getCheonanDirectCategoryMap();

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.account, this.parseTemplate, "천안부동산직거래")
                       .build(), cheonanDirectMap, SpanTagPostInitializer.class, NaverCafeType.UNKNOWN
        );
    }

    public void yangSanMomCrawler() throws Exception {
        Map<String, Integer> yangSanMap = categoryMapFactory.getYangSanMomCategoryMap();

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.account, this.parseTemplate, "러브양산맘")
                        .build(), yangSanMap, DivTagPostInitializer.class, NaverCafeType.UNKNOWN
        );
    }

    public void happyHouseCrawler() throws Exception {
        Map<String, Integer> happyHouseMap = categoryMapFactory.getHappyHouseCategoryMap();

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.account, this.parseTemplate, "행가집")
                    .build(), happyHouseMap, DivTagPostInitializer.class, NaverCafeType.HAPPY_HOUSE
        );
    }
}
