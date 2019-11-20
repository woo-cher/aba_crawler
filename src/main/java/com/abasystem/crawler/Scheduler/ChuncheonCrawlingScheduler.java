package com.abasystem.crawler.Scheduler;

import com.abasystem.crawler.Builder.CrawlerDtoBuilder;
import com.abasystem.crawler.Factory.ChuncheonCategoryMapFactory;
import com.abasystem.crawler.Service.Operator.ParseTemplate;
import com.abasystem.crawler.Storage.Naver;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ChuncheonCrawlingScheduler extends CrawlerTemplate {
    private static final Logger logger = LoggerFactory.getLogger(ChuncheonCrawlingScheduler.class);

    @Autowired
    @Qualifier("CategoryOfPropertyOperator")
    private ParseTemplate parseTemplate;

    @Autowired
    private ChuncheonCategoryMapFactory categoryMapFactory;

    @Override
    protected String getUrlAfterSearch() {
        // Nothing to do
        return StringUtils.EMPTY;
    }

    public void categoriesCrawler() throws Exception{
        Map<String, Integer> chuncheonMap = categoryMapFactory.getCategoryMap();

        logger.info("──── Chuncheon Multiple Crawler initialize\n");

        multipleCrawling(
                new CrawlerDtoBuilder(Naver.ID, Naver.PASSWORD, this.parseTemplate, "춘천부동산").build(), chuncheonMap);

        logger.info("──── End Chuncheon Multiple Crawling\n");
    }
}
