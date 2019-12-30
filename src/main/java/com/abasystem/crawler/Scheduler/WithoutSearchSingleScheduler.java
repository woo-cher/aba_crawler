package com.abasystem.crawler.Scheduler;

import com.abasystem.crawler.Model.Dto.CrawlerDto;
import com.abasystem.crawler.Service.Converter.DataConverter;
import com.abasystem.crawler.Service.Initializer.DivTagPostInitializer;
import com.abasystem.crawler.Service.Operator.ParseTemplate;
import com.abasystem.crawler.Storage.Naver;
import com.abasystem.crawler.Strategy.ObtainDocumentStrategy;
import com.abasystem.crawler.Strategy.ObtainHtmlResourceStrategy;
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
public class WithoutSearchSingleScheduler extends CrawlerTemplate {
    private static final Logger logger = LoggerFactory.getLogger(WithoutSearchSingleScheduler.class);

    @Autowired
    @Qualifier("CategoryOfPropertyOperator")
    private ParseTemplate parseTemplate;

    @Scheduled(cron = "0 0 23 ? * 7")
    public void jinjuMomCrawler() throws Exception {
        logger.info("──── JinjuMom Crawler initialize\n");
        singleCrawling(
                new CrawlerDto(Naver.ID, Naver.PASSWORD, "부동산 (본인 직거래만 가능)", 4, this.parseTemplate, "진주맘",
                        new ObtainDocumentStrategy() {
                            @Override
                            public Document getDocument(String url) throws IOException {
                                return Jsoup.connect(url).cookies(cookies).get();
                            }
                        },

                        new ObtainHtmlResourceStrategy() {
                            @Override
                            public String getUrlAfterSearch() {
                                return Naver.MOM_DIRECT_URL;
                            }
                        }
                ), DivTagPostInitializer.class);
        logger.info("──── End JinjuMom Crawling\n");
    }

    public void test() throws Exception {
        logger.info("──── initialize\n");
        singleCrawling(
                new CrawlerDto(Naver.ID, Naver.PASSWORD, "[사무실]전라.경상 사무실", 4, this.parseTemplate, "[직거래]상가-업종별",
                        new ObtainDocumentStrategy() {
                            @Override
                            public Document getDocument(String url) throws IOException {
                                return Jsoup.connect(url).cookies(cookies).get();
                            }
                        },

                        new ObtainHtmlResourceStrategy() {
                            @Override
                            public String getUrlAfterSearch() {
                                return DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=849&search.boardtype=L");
                            }
                        }
                ), DivTagPostInitializer.class);
        logger.info("──── End JinjuMom Crawling\n");
    }
}
