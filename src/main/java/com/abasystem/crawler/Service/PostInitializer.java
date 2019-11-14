package com.abasystem.crawler.Service;

import com.abasystem.crawler.Storage.Naver;
import com.abasystem.crawler.Strategy.InitStrategy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PostInitializer implements InitStrategy {
    private static final Logger logger = LoggerFactory.getLogger(PostInitializer.class);

    private Elements elements;
    private String pageUrl;

    @Override
    public Elements initPosts(Document document, int pageCount) throws IOException {
        this.elements = document.select(Naver.POST_ARTICLE);
        this.pageUrl = Naver.CAFE_PREFIX.concat(document.select(Naver.PAGE_NAVIGATOR).attr("href"));

        for (int n = 2; n < pageCount + 1; n++) {
            elements.addAll(
                    Jsoup.connect(convertPageToNext(pageUrl, n)).get().select(Naver.POST_ARTICLE)
            );
        }

        logger.info("init posts successfully: {}");
        return elements;
    }

    @Override
    public String convertPageToNext(String url, int next) {
        String str = "";

        str = url.substring(0, url.length() - 1);
        str = str.concat(Integer.toString(next));

        return str.concat(Naver.CAFE_POSTFIX);
    }

    @Override
    public Elements initMultiplePosts(int pageCount, Document... documents) throws IOException {
        Elements multiplePosts = new Elements();

        for(Document document : documents) {
            if(!multiplePosts.addAll(initPosts(document, pageCount))) {
                throw new NullPointerException("addAll() run fail");
            }
        }

        if(multiplePosts.isEmpty()) {
            throw new NullPointerException("InitMultiplePosts Error");
        }

        return multiplePosts;
    }
}
