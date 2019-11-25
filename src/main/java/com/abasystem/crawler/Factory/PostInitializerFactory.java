package com.abasystem.crawler.Factory;

import com.abasystem.crawler.Service.Initializer.PostInitializer;
import com.abasystem.crawler.Service.Initializer.SpanTagPostInitializer;
import com.abasystem.crawler.Storage.Naver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostInitializerFactory {

    @Autowired
    private PostInitializer spanTagPostInitializer;

    @Autowired
    private PostInitializer divTagPostInitializer;

    public PostInitializer getPostCreator(Class clazz) {
        if(clazz.equals(SpanTagPostInitializer.class)) {
            return spanTagPostInitializer;
        }
        else {
            return divTagPostInitializer;
        }
    }

    public String getPostTitleSelector(Class clazz) {
        if(clazz.equals(SpanTagPostInitializer.class)) {
            return Naver.SPAN_POST_ARTICLE;
        }

        else return Naver.DIV_POST_ARTICLE;
    }
}
