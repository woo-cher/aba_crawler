package com.abasystem.crawler.Service;

import com.abasystem.crawler.Factory.ServiceFactory;
import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Service.Converter.ModelConverter;
import com.abasystem.crawler.Service.Writer.CustomOpenCsv;
import com.abasystem.crawler.Strategy.CsvWriteStrategy;
import com.abasystem.crawler.Strategy.InitStrategy;
import com.abasystem.crawler.Strategy.ValidationStrategy;
import com.abasystem.crawler.Storage.Naver;
import com.google.gson.JsonObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Init 메소드는 Util 성에 성격이 가까워보인다.
 */
@Service
public class PeterPanService <P extends ModelMapper> extends CustomOpenCsv implements InitStrategy {
    private static final Logger logger = LoggerFactory.getLogger(PeterPanService.class);

    private static final String[] TABLE_ROW = {
            "번호", "제목", "링크", "설명", "등록일", "주소", "타입", "연락처", "가격", "관리비", "옵션", "이사가능일",
            "방개수", "해당층/전체층", "관리비항목", "난방방식"
    };

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

    public PeterPanService() throws Exception {
        super();
    }

    public boolean writeAll(List<P> properties) {
        cw.writeNext(TABLE_ROW);

        int index = 1;

        for(P property : properties) {
            CsvWriteStrategy csvWriteStrategy = factory.writerCreator(property.getClass());
            JsonObject object = ModelConverter.convertModelToJsonObject(property);
            csvWriteStrategy.doWrite(object, cw, index);
            index++;
        }

        if(cw.checkError() == true) {
            return false;
        }
        return true;
    }

    public List<P> parseAll(Elements elements, Map<String, String> cookies) throws IOException {
        properties = new ArrayList<>();

        for (Element post : elements) {
            url = Naver.CAFE_PREFIX.concat(post.select("a").attr("href"));
            title = post.select("a").text();

            document = Jsoup.connect(url)
                    .cookies(cookies)
                    .get();

            if (validationStrategy.postValidate(document.select(".inbox"))) {
                continue;
            }

            boolean flag = validationStrategy.isRegularPost(document.select("#tbody"));

            properties.add(factory.parserCreator(flag).parse(document, url, title));
        }

        return (List<P>) properties;
    }

    @Override
    public Elements initPosts(Document document, int maxPage) throws IOException {
        this.elements = document.select(Naver.POST_ARTICLE);
        this.pageUrl = Naver.CAFE_PREFIX.concat(document.select(Naver.PAGE_NAVIGATOR).attr("href"));

        for (int n = 2; n < maxPage + 1; n++) {
            elements.addAll(
                    Jsoup.connect(convertPageToNext(pageUrl, n)).get().select(Naver.POST_ARTICLE)
            );
        }

        logger.info("init posts successfully: {}", elements);
        return elements;
    }

    @Override
    public String convertPageToNext(String url, int next) {
        String str = "";

        str = url.substring(0, url.length() - 1);
        str = str.concat(Integer.toString(next));

        return str.concat(Naver.CAFE_POSTFIX);
    }
}