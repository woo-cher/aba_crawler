package com.abasystem.crawler.Strategy;

import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public interface ValidationStrategy {
    boolean isPropertyPost(Elements elements);
    boolean isInvalidPost(Elements elements);
    boolean isRegularPost(Elements elements);
    boolean isExistPhoneNumber(Elements elements);
}