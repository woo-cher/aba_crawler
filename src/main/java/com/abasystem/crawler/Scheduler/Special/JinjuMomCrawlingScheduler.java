package com.abasystem.crawler.Scheduler.Special;

import com.abasystem.crawler.Model.Dto.CrawlerDto;
import com.abasystem.crawler.Scheduler.CrawlerTemplate;
import com.abasystem.crawler.Service.Operator.ParseTemplate;
import com.abasystem.crawler.Storage.Naver;
import com.abasystem.crawler.Strategy.ObtainDocumentStrategy;
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
public class JinjuMomCrawlingScheduler extends CrawlerTemplate {
    private static final Logger logger = LoggerFactory.getLogger(JinjuMomCrawlingScheduler.class);

    @Autowired
    @Qualifier("CategoryOfPropertyOperator")
    private ParseTemplate parseTemplate;

    @Override
    protected String getUrlAfterSearch() throws IOException {
        // Nothing to search
        return Naver.MOM_DIRECT_URL;
    }

    @Scheduled(cron = "0 40 23 ? * 7")
    public void momCrawler() {
        try {
            logger.info("──── JinjuMom Crawler initialize\n");

            singleCrawling(
                new CrawlerDto(Naver.ID, Naver.PASSWORD, "부동산 (본인 직거래만 가능)", 4, this.parseTemplate,
                    new ObtainDocumentStrategy() {
                        @Override
                        public Document getDocument(String url) throws IOException {
                            return Jsoup.connect(url).cookies(cookies).get();
                        }
                    }, "진주맘")
            );

        } catch (Exception e) {
            logger.error("MomCrawling Failure : " + e);
        } finally {
            logger.info("──── End JinjuMom Crawling\n");
        }
    }
}