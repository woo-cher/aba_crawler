package com.abasystem.crawler.Strategy;

import org.jsoup.select.Elements;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface ValidationStrategy {
    boolean postValidate(Elements elements);
    boolean isRegularPost(Elements elements);
}