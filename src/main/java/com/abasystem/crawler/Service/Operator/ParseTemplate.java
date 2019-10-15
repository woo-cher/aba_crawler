package com.abasystem.crawler.Service.Operator;

import com.abasystem.crawler.Factory.ServiceFactory;
import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Storage.Naver;
import com.abasystem.crawler.Strategy.ValidationStrategy;
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
    public ServiceFactory factory;

    @Autowired
    @Qualifier("customValidator")
    public ValidationStrategy validationStrategy;

    private List<? extends ModelMapper> properties;
    private Document document;
    private String url;
    private String title;

    public abstract <P extends ModelMapper> P getModelAfterParse(Elements elements, Document doc, String url, String title);

    public abstract boolean isProperty(Elements elements);

    public List<? extends ModelMapper> parseAll(Elements elements, Map<String, String> cookies) throws IOException {
        properties = new ArrayList<>();

        for (Element post : elements) {
            url = Naver.CAFE_PREFIX.concat(post.select("a").attr("href"));
            title = post.select("a").text();
            logger.info("title : {}", title);

            document = Jsoup.connect(url)
                    .cookies(cookies)
                    .get();

            Elements els = document.select(".inbox");

            if (validationStrategy.isInvalidPost(els)) {
                continue;
            }

            if (!isProperty(els)) {
                continue;
            }

            if (!validationStrategy.isExistPhoneNumber(els)) {
                logger.error("\t---------- 연락처가 없는 친구 ---------------\n");
                continue;
            }

            properties.add(getModelAfterParse(els, document, url, title));
        }

        return properties;
    }
}
