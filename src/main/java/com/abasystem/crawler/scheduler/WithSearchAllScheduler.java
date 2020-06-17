package com.abasystem.crawler.scheduler;

import com.abasystem.crawler.model.Dto.CrawlerDto;
import com.abasystem.crawler.service.Initializer.DivTagPostInitializer;
import com.abasystem.crawler.service.Operator.ParseTemplate;
import com.abasystem.crawler.storage.Naver;
import com.abasystem.crawler.strategy.ObtainDocumentStrategy;
import com.abasystem.crawler.strategy.ObtainHtmlResourceStrategy;
import com.abasystem.crawler.util.CommonsUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
                new CrawlerDto(Naver.ID, Naver.PASSWORD, "피터팬(진주지역)", 2, this.templateWithType, "피터팬",
                        new ObtainDocumentStrategy() {
                            @Override
                            public Document getDocument(String url) throws IOException {
                                return Jsoup.connect(url).cookies(cookies).get();
                            }
                        },

                        new ObtainHtmlResourceStrategy() {
                            @Override
                            public String getUrlAfterSearch() throws IOException {
                                return CommonsUtils.getUrlWithSearch("진주", Naver.APT_DIRECT_PROVINCES_URL, Naver.PETER_SEARCH_BUTTON_XPATH);
                            }
                        }
                ), DivTagPostInitializer.class);
        logger.info("──── End PeterPan Single Crawling\n");
    }

    @Scheduled(cron = "0 30 23 ? * 7")
    public void happyHouseCrawler() throws Exception {
        logger.info("──── HappyHouse Crawler initialize\n");
        singleCrawling(
                new CrawlerDto(Naver.ID, Naver.PASSWORD, "직거래매물", 2, this.templateWithoutType, "행가집",
                        new ObtainDocumentStrategy() {
                            @Override
                            public Document getDocument(String url) throws IOException {
                                return Jsoup.connect(url).cookies(cookies).get();
                            }
                        },

                        new ObtainHtmlResourceStrategy() {
                            @Override
                            public String getUrlAfterSearch() throws IOException {
                                return CommonsUtils.getUrlWithSearch("직거래", Naver.HAPPY_CAFE_URL, Naver.HAPPY_SEARCH_BUTTON_XPATH);
                            }
                        }
                ), DivTagPostInitializer.class);
        logger.info("──── End HappyHouse Crawling\n");
    }

    public void daehakDongOneRoomCrawler() throws Exception {
        logger.info("──── daehakDong Crawler initialize\n");
        singleCrawling(
                new CrawlerDto(Naver.ID, Naver.PASSWORD, "대학동", 100, this.templateWithoutType, "관악구_대학동",
                        new ObtainDocumentStrategy() {
                            @Override
                            public Document getDocument(String url) throws IOException {
                                return Jsoup.connect(url).cookies(cookies).get();
                            }
                        },

                        new ObtainHtmlResourceStrategy() {
                            @Override
                            public String getUrlAfterSearch() throws IOException {
                                return CommonsUtils.getUrlWithSearch("대학동", Naver.PETERPAN_GWANAKGU_URL, Naver.PETER_SEARCH_BUTTON_XPATH);
                            }
                        }
                ), DivTagPostInitializer.class);
        logger.info("──── End daehakDong Crawler\n");
    }
}
