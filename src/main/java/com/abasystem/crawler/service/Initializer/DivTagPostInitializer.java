package com.abasystem.crawler.service.Initializer;

import com.abasystem.crawler.storage.Naver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("DivTagPost")
public class DivTagPostInitializer extends PostInitializer {

    @Override
    String getPostArticleSelector() {
        return Naver.DIV_POST_ARTICLE;
    }

    @Override
    String getPageNavigationSelector() {
        return Naver.PAGE_NAVIGATOR;
    }
}
