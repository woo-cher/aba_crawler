package com.abasystem.crawler.Scheduler;

import com.abasystem.crawler.Builder.CrawlerDtoBuilder;
import com.abasystem.crawler.Factory.PeterPanCategoryMapFactory;
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
import java.util.Map;

@Component
public class PerterPanCrawlingScheduler extends CrawlerTemplate {
    private static final Logger logger = LoggerFactory.getLogger(PerterPanCrawlingScheduler.class);

    @Autowired
    @Qualifier("peterOperator")
    private ParseTemplate parseTemplate;

    @Autowired
    private PeterPanCategoryMapFactory categoryFactory;

    @Override
    protected String getUrlAfterSearch() throws IOException {
        return CommonsUtils.getPostUrlWithSearch("진주", Naver.APT_DIRECT_PROVINCES_URL, Naver.PETER_SEARCH_BUTTON_XPATH);
    }

    @Scheduled(cron = "0 30 22 ? * 7")
    public void jinjuAreaCrawler() {
        try {
            logger.info("──── PeterPan Single Crawler initialize\n");

            singleCrawling(
                new CrawlerDto(Naver.ID, Naver.PASSWORD, "피터팬", 1, this.parseTemplate,
                    new ObtainDocumentStrategy() {
                        @Override
                        public Document getDocument(String url) throws IOException {
                            return Jsoup.connect(url).cookies(cookies).get();
                        }
                    }, "피터팬")
            );

        } catch (Exception e) {
            logger.error("PeterPan Single Crawling Failure : " + e);
        } finally {
            logger.info("──── End PeterPan Single Crawling\n");
        }
    }

    public void categoriesCrawler() throws Exception {
            Map<String, Integer> peterPanMap = categoryFactory.getCategoryMap();
            logger.info("──── PeterPan Multiple Crawler initialize\n");

            multipleCrawling(
                    new CrawlerDtoBuilder(Naver.ID, Naver.PASSWORD, this.parseTemplate, "피터팬").pageCount(1).build(), peterPanMap);

            logger.info("──── End PeterPan Multiple Crawling\n");
    }
}