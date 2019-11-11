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
import java.util.HashMap;
import java.util.Map;

@Component
public class PerterPanCrawlingScheduler extends CrawlerTemplate {
    private static final Logger logger = LoggerFactory.getLogger(PerterPanCrawlingScheduler.class);

    @Autowired
    @Qualifier("peterOperator")
    private ParseTemplate parseTemplate;

    public PerterPanCrawlingScheduler() {
    }

    @Override
    protected String getUrlAfterSearch() throws IOException {
        return CommonsUtils.getPostUrlWithSearch("진주", Naver.APT_DIRECT_PROVINCES_URL, Naver.PETER_SEARCH_BUTTON_XPATH);
    }

    @Scheduled(cron = "0 30 23 ? * 7")
    public void crawlingAfterSearch() {
        try {
            logger.info("──── PeterPan Single Crawler initialize\n");

            singleCrawling(
                new CrawlerDto(Naver.ID, Naver.PASSWORD, "피터팬", 1, this.parseTemplate,
                    new ObtainDocumentStrategy() {
                        @Override
                        public Document getDocument(String url) throws IOException {
                            return Jsoup.connect(url).cookies(cookies).get();
                        }
                    })
            );

        } catch (Exception e) {
            logger.error("PeterPan Single Crawling Failure : " + e);
        } finally {
            logger.info("──── End PeterPan Single Crawling\n");
        }
    }

    public void crawlingCategories() {
        try {
            logger.info("──── PeterPan Multiple Crawler initialize\n");

        } catch (Exception e) {
            logger.error("PeterPan Multiple Crawling Failure : " + e);
        } finally {
            logger.info("──── End PeterPan Multiple Crawling\n");
        }
    }

    private Map<String, String> getCustomMap() {
        Map<String, String> map = new HashMap<>();

        map.put("아파트.전세.서울", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1104&search.boardtype=L");
        map.put("아파트.전세.경기", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1105&search.boardtype=L");
        map.put("아파트.전세.인천", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1108&search.boardtype=L");
        map.put("아파트.전세.지방", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1107&search.boardtype=L");

        map.put("아파트.월세.서울", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1106&search.boardtype=L");
        map.put("아파트.월세.경기", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1113&search.boardtype=L");
        map.put("아파트.월세.인천", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1114&search.boardtype=L");
        map.put("아파트.월세.지방", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1115&search.boardtype=L");

        map.put("아파트.매매.서울", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1109&search.boardtype=L");
        map.put("아파트.매매.경기", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1110&search.boardtype=L");
        map.put("아파트.매매.인천", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1111&search.boardtype=L");
        map.put("아파트.매매.지방", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1112&search.boardtype=L");

        /*map.put("오피스텔.전월세.서울", Naver.CAFE_PREFIX + "");
        map.put("오피스텔.전월세.수도권", Naver.CAFE_PREFIX + "");
        map.put("오피스텔.전월세.지방권", Naver.CAFE_PREFIX + "");
        map.put("오피스텔.매매.전국", Naver.CAFE_PREFIX + "");*/

        return map;
    }
}