package com.abasystem.crawler.Strategy;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface InitStrategy {
    Elements initPosts(Document document, int pageCount) throws IOException;
    String convertPageToNext(String url, int next);
}
