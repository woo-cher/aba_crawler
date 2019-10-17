package com.abasystem.crawler.Scheduler;

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
public class PerterPanCrawlingScheduler extends CrawlerTemplate {
    private static final Logger logger = LoggerFactory.getLogger(PerterPanCrawlingScheduler.class);

    @Autowired
    @Qualifier("peterOperator")
    private ParseTemplate parseTemplate;

    @Override
    String getUrlAfterSearch() throws IOException {
        return CommonsUtils.getPostUrlWithSearch("진주", Naver.APT_DIRECT_PROVINCES_URL, Naver.PETER_SEARCH_BUTTON_XPATH);
    }

    @Scheduled(cron = "0 30 23 ? * 7")
    public void peterPanCrawler() {
        try {
            logger.info("──── PeterPanCrawler initialize\n");

            crawling(Naver.ID, Naver.PASSWORD, "피터팬", 1, this.parseTemplate, new ObtainDocumentStrategy() {
                @Override
                public Document getDocument(String url) throws IOException {
                    return Jsoup.connect(url).cookies(cookies).get();
                }
            });
        } catch (Exception e) {
            logger.error("HappyHouseCrawling Failure : " + e);
        } finally {
            logger.info("──── End PeterPan Crawling\n");
        }
    }
}