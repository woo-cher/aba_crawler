package com.abasystem.crawler.Strategy;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public interface InitStrategy {
    Elements initPosts(Document document, int maxPage) throws IOException;
    String convertPageToNext(String url, int next);
}
