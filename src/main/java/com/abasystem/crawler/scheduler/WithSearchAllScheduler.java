package com.abasystem.crawler.scheduler;

import com.abasystem.crawler.api.service.Initializer.DivTagPostInitializer;
import com.abasystem.crawler.api.service.operator.ParseTemplate;
import com.abasystem.crawler.model.dto.CrawlerDto;
import com.abasystem.crawler.model.type.NaverCafeType;
import com.abasystem.crawler.storage.Naver;
import com.abasystem.crawler.strategy.ObtainHtmlResourceStrategy;
import com.abasystem.crawler.util.CommonsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WithSearchAllScheduler extends CrawlerTemplate {
    private static final Logger logger = LoggerFactory.getLogger(WithSearchAllScheduler.class);

    @Autowired
    @Qualifier("CategoryWithPostTypeOperator")
    private ParseTemplate templateWithType;

    @Autowired
    @Qualifier("CategoryOfPropertyOperator")
    private ParseTemplate templateWithoutType;

    @Scheduled(cron = "0 30 22 ? * 7")
    public void jinjuAreaCrawler() throws Exception {
        logger.info("──── PeterPan Single Crawler initialize\n");
        singleCrawling(
                new CrawlerDto(Naver.account, "피터팬(진주지역)", 22, this.templateWithType, "피터팬",
                        new ObtainHtmlResourceStrategy() {
                            @Override
                            public String getUrlAfterSearch() throws IOException {
                                return CommonsUtils.getUrlWithSearch("진주", Naver.PETERPAN_CAFE_URL, Naver.PETER_SEARCH_BUTTON_XPATH);
                            }
                        }
                ), DivTagPostInitializer.class, NaverCafeType.PETERPAN);
        logger.info("──── End PeterPan Single Crawling\n");
    }

    @Scheduled(cron = "0 30 23 ? * 7")
    public void happyHouseCrawler() throws Exception {
        logger.info("──── HappyHouse Crawler initialize\n");
        singleCrawling(
                new CrawlerDto(Naver.account, "직거래매물", 2, this.templateWithoutType, "행가집",
                        new ObtainHtmlResourceStrategy() {
                            @Override
                            public String getUrlAfterSearch() throws IOException {
                                return CommonsUtils.getUrlWithSearch("직거래", Naver.HAPPY_CAFE_URL, Naver.HAPPY_SEARCH_BUTTON_XPATH);
                            }
                        }
                ), DivTagPostInitializer.class, NaverCafeType.HAPPY_HOUSE);
        logger.info("──── End HappyHouse Crawling\n");
    }

    public void daehakDongOneRoomCrawler() throws Exception {
        logger.info("──── daehakDong Crawler initialize\n");
        singleCrawling(
                new CrawlerDto(Naver.account, "대학동", 100, this.templateWithoutType, "관악구_대학동",
                        new ObtainHtmlResourceStrategy() {
                            @Override
                            public String getUrlAfterSearch() throws IOException {
                                return CommonsUtils.getUrlWithSearch("대학동", Naver.PETERPAN_GWANAKGU_URL, Naver.PETER_SEARCH_BUTTON_XPATH);
                            }
                        }
                ), DivTagPostInitializer.class, NaverCafeType.PETERPAN);
        logger.info("──── End daehakDong Crawler\n");
    }
}
