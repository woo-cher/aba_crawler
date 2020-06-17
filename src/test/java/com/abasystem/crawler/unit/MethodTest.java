package com.abasystem.crawler.unit;

import com.abasystem.crawler.service.Reader.IrregularReader;
import com.abasystem.crawler.storage.Naver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MethodTest {
    private static final Logger logger = LoggerFactory.getLogger(MethodTest.class);

    @Test
    public void getMaxPage() throws IOException {
        Document nextDoc = Jsoup.connect(Naver.CAFE_PREFIX.concat("/ArticleList.nhn?search.clubid=10322296&search.menuid=1238&search.boardtype=L")).get();

        int maxPage = 1;

        while(true) {
            String nextUrl = nextDoc.select(Naver.DIV_POST_NEXT).attr("href");
            logger.info("nextUrl : {}", nextUrl);

            if(nextUrl.isEmpty()) {
                break;
            }

            nextDoc = Jsoup.connect(Naver.CAFE_PREFIX.concat(nextUrl)).get();
            maxPage += 10;
        }

        logger.info("maxPage : {}", maxPage);
    }

    @Test
    public void getPhoneNumber() throws IOException {
        Document document = Jsoup.connect("https://cafe.naver.com/ArticleRead.nhn?clubid=10322296&page=373&menuid=455&boardtype=L&articleid=7893385&referrerAllArticles=false")
                            .get();

        IrregularReader reader = new IrregularReader();
        logger.error("폰 : {}", reader.getPhoneNumber(document.select(".inbox")));
    }
}
