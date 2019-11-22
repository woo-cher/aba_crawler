package com.abasystem.crawler.Scheduler;

import com.abasystem.crawler.Model.Dto.CrawlerDto;
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

    @Scheduled(cron = "0 40 23 ? * 7")
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
                )
        );
        logger.info("──── End JinjuMom Crawling\n");
    }
}
