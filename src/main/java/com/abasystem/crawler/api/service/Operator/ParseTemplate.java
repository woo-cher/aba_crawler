package com.abasystem.crawler.api.service.Operator;

import com.abasystem.crawler.factory.PostInitializerFactory;
import com.abasystem.crawler.factory.ServiceFactory;
import com.abasystem.crawler.mapper.ModelMapper;
import com.abasystem.crawler.storage.Naver;
import com.abasystem.crawler.strategy.ValidationStrategy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public abstract class ParseTemplate {
    private static final Logger logger = LoggerFactory.getLogger(ParseTemplate.class);

    @Autowired
    public ServiceFactory serviceFactory;

    @Autowired
    public PostInitializerFactory initializerFactory;

    @Autowired
    @Qualifier("customValidator")
    public ValidationStrategy validationStrategy;

    private List<? extends ModelMapper> properties;
    private Document document;
    private String url;
    private String title;

    public abstract <P extends ModelMapper> P getModelAfterParse(Elements elements, Document doc, String url, String title);

    public abstract boolean isContainPropertyKeyword(Elements elements);

    public List<? extends ModelMapper> parseAll(Elements elements, Map<String, String> cookies, Class clazz) throws IOException {
        properties = new ArrayList<>();
        String selector = initializerFactory.getPostTitleSelector(clazz);

        for (Element post : elements) {
            url = Naver.CAFE_PREFIX.concat(post.select(selector).attr("href")).replace("ca-fe", "kig");
            title = post.select(selector).text();
            logger.info("TITLE : {}", title);
            logger.info("URL : {}", url);

            document = Jsoup.connect(url)
                    .cookies(cookies)
                    .get();

            elementsGarbageClear(document);

            Elements els = document.select("#main-area");

            if (validationStrategy.isInvalidPost(els)) {
                logger.error("\t---------- Is not a post for sail property ---------------\n");
                continue;
            }

            if (!isContainPropertyKeyword(els)) {
                logger.error("\t---------- The post is invalid ---------------\n");
                continue;
            }

            if (!validationStrategy.isExistPhoneNumber(els)) {
                logger.error("\t---------- Don't exist phone number at post ---------------\n");
                continue;
            }

            properties.add(getModelAfterParse(els, document, url, title));
        }

        return properties;
    }

    private void elementsGarbageClear(Document document) {
        document.select("#main-area form").remove();
    }
}
