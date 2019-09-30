package com.abasystem.crawler.Service;

import com.abasystem.crawler.Factory.ServiceFactory;
import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Strategy.InitStrategy;
import com.abasystem.crawler.Strategy.ValidationStrategy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PeterPanService implements InitStrategy {
    public final String postfix = "&search.sortBy=date";
    public final String prefix = "https://cafe.naver.com";

    @Autowired
    public ValidationStrategy validationStrategy;

    @Autowired
    private ServiceFactory factory;

    private Elements elements;
    private Document document;

    private List<ModelMapper> properties;

    private String pageUrl;
    private String url;
    private String title;

    public PeterPanService() {}

    public List<ModelMapper> parseAll(Elements elements, Map<String, String> cookies) throws IOException {
        properties = new ArrayList<>();

        for (Element post : elements) {
            url = prefix.concat(post.select("a").attr("href"));
            title = post.select("a").text();

            document = Jsoup.connect(url)
                    .cookies(cookies)
                    .get();

//            if (validator.isInvalidPost(document.select(".tit-box div table tbody tr td a"))) {
            if (validationStrategy.postValidate(document.select(".inbox"))) {
                continue;
            }

            boolean flag = validationStrategy.isRegularPost(document.select("#tbody"));

            properties.add(factory.getTypeServiceCreator(flag).parse(document, url, title));
        }

        return properties;
    }

    @Override
    public Elements initPosts(Document document, int maxPage) throws IOException {
        this.elements = document.select(".board-list .article");
        this.pageUrl = prefix.concat(document.select(".prev-next .on").attr("href"));

        for (int n = 2; n < maxPage + 1; n++) {
            elements.addAll(
                    Jsoup.connect(convertPageToNext(pageUrl, n)).get().select(".board-list .article")
            );
        }

        return elements;
    }

    @Override
    public String convertPageToNext(String url, int next) {
        String str = "";

        str = url.substring(0, url.length() - 1);
        str = str.concat(Integer.toString(next));

        return str.concat(postfix);
    }
}