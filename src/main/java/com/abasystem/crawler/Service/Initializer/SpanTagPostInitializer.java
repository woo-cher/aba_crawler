package com.abasystem.crawler.Service.Initializer;

import com.abasystem.crawler.Storage.Naver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SpanTagPost")
public class SpanTagPostInitializer extends PostInitializer {

    @Override
    String getPostArticleSelector() {
        return Naver.SPAN_POST_ARTICLE;
    }

    @Override
    String getPageNavigationSelector() {
        return Naver.PAGE_NAVIGATOR2;
    }
}
