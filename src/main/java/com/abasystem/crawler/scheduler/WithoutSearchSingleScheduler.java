package com.abasystem.crawler.scheduler;

import com.abasystem.crawler.api.service.Initializer.DivTagPostInitializer;
import com.abasystem.crawler.api.service.operator.ParseTemplate;
import com.abasystem.crawler.model.dto.CrawlerDto;
import com.abasystem.crawler.model.type.NaverCafeType;
import com.abasystem.crawler.storage.Naver;
import com.abasystem.crawler.strategy.ObtainHtmlResourceStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WithoutSearchSingleScheduler extends CrawlerTemplate {
    private static final Logger logger = LoggerFactory.getLogger(WithoutSearchSingleScheduler.class);

    @Autowired
    @Qualifier("CategoryOfPropertyOperator")
    private ParseTemplate parseTemplate;

    @Autowired
    @Qualifier("CategoryWithPostTypeOperator")
    private ParseTemplate parseWithTypeTemplate;

    @Scheduled(cron = "0 0 23 ? * 7")
    public void jinjuMomCrawler() throws Exception {
        logger.info("──── JinjuMom Crawler initialize\n");
        singleCrawling(
                new CrawlerDto(Naver.account, "부동산 (본인 직거래만 가능)", 45, this.parseTemplate, "진주맘",
                        new ObtainHtmlResourceStrategy() {
                            @Override
                            public String getUrlAfterSearch() {
                                return Naver.MOM_DIRECT_URL;
                            }
                        }
                ), DivTagPostInitializer.class, NaverCafeType.MOM);
        logger.info("──── End JinjuMom Crawling\n");
    }

    public void jinjuNCrawler() throws Exception {
        logger.info("──── JinJu_N Crawler initialize\n");
        singleCrawling(
                new CrawlerDto(Naver.account, "진주엔(부동산매물_개인)", 28, this.parseTemplate, "진주엔",
                        new ObtainHtmlResourceStrategy() {
                            @Override
                            public String getUrlAfterSearch() {
                                return Naver.JINJU_N_URL;
                            }
                        }
                ), DivTagPostInitializer.class, NaverCafeType.JINJU_N);
        logger.info("──── End JinJu_N Crawling\n");
    }

    public void peterOneRoomGangnamSeocho() throws Exception {
        // [원룸] 강남구.서초구
        logger.info("──── Custom Peterpan initialize\n {}");
        singleCrawling(
                new CrawlerDto(Naver.account, "[원룸]강남구.서초구3", 1000, this.parseWithTypeTemplate, "커스텀",
                        new ObtainHtmlResourceStrategy() {
                            @Override
                            public String getUrlAfterSearch() {
                                return "https://cafe.naver.com/ArticleList.nhn?search.clubid=10322296&search.menuid=2&search.boardtype=L";
                            }
                        }
                ), DivTagPostInitializer.class, NaverCafeType.PETERPAN);
        logger.info("──── End Custom Peterpan Crawling\n");
    }
}
