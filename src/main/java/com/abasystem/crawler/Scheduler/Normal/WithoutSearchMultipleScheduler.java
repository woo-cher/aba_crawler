package com.abasystem.crawler.Scheduler.Normal;

import com.abasystem.crawler.Builder.CrawlerDtoBuilder;
import com.abasystem.crawler.Scheduler.CrawlerTemplate;
import com.abasystem.crawler.Service.Operator.ParseTemplate;
import com.abasystem.crawler.Storage.Naver;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class WithoutSearchMultipleScheduler extends CrawlerTemplate {
    private static final Logger logger = LoggerFactory.getLogger(WithoutSearchMultipleScheduler.class);

    @Autowired
    @Qualifier("CategoryOfPropertyOperator")
    private ParseTemplate parseTemplate;

    @Override
    protected String getUrlAfterSearch() throws IOException {
        // Nothing to do
        return StringUtils.EMPTY;
    }

    public void chuncheonCrawler() throws Exception{
        Map<String, Integer> chuncheonMap = categoryMapFactory.getChuncheonCategoryMap();
        logger.info("──── Chuncheon Multiple Crawler initialize\n");

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.ID, Naver.PASSWORD, this.parseTemplate, "춘천부동산").build(), chuncheonMap);

        logger.info("──── End Chuncheon Multiple Crawling\n");
    }

    public void goodShopCrawler() throws Exception {
        Map<String, Integer> goodShopMap = categoryMapFactory.getGoodShopCategoryMap();
        logger.info("──── GoodShop Multiple Crawler initialize\n");

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.ID, Naver.PASSWORD, this.parseTemplate, "좋은점포구하기").build(), goodShopMap);

        logger.info("──── End GoodShop Multiple Crawling\n");
    }

    public void peterPanCrawler() throws Exception {
        Map<String, Integer> peterPanMap = categoryMapFactory.getPeterPanCategoryMap();
        logger.info("──── PeterPan Multiple Crawler initialize\n");

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.ID, Naver.PASSWORD, this.parseTemplate, "피터팬").build(), peterPanMap);

        logger.info("──── End PeterPan Multiple Crawling\n");
    }
}
