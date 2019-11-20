package com.abasystem.crawler.Scheduler;

import com.abasystem.crawler.Model.Dto.CrawlerDto;
import com.abasystem.crawler.Service.Operator.ParseTemplate;
import com.abasystem.crawler.Storage.Naver;
import com.abasystem.crawler.Strategy.ObtainDocumentStrategy;
import com.abasystem.crawler.Util.CommonsUtils;
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
public class HappyHouseCrawlingScheduler extends CrawlerTemplate {
    private static final Logger logger = LoggerFactory.getLogger(HappyHouseCrawlingScheduler.class);

    @Autowired
    @Qualifier("CategoryOfPropertyOperator")
    private ParseTemplate parseTemplate;

    @Override
    protected String getUrlAfterSearch() throws IOException {
        return CommonsUtils.getPostUrlWithSearch("직거래", Naver.HAPPY_CAFE_URL, Naver.HAPPY_SEARCH_BUTTON_XPATH);
    }

    @Scheduled(cron = "0 50 23 ? * 7")
    public void happyHouseCrawler() {
        try {
            logger.info("──── HappyHouse Crawler initialize\n");

            singleCrawling(
                new CrawlerDto(Naver.ID, Naver.PASSWORD, "직거래매물", 2, this.parseTemplate,
                    new ObtainDocumentStrategy() {
                        @Override
                        public Document getDocument(String url) throws IOException {
                            return Jsoup.connect(url).cookies(cookies).get();
                        }
                    }, "행가집")
            );

        } catch (Exception e) {
            logger.error("HappyHouseCrawling Failure : " + e);
        } finally {
            logger.info("──── End HappyHouse Crawling\n");
        }
    }
}