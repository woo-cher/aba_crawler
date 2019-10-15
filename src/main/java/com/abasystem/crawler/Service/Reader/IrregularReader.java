package com.abasystem.crawler.Service.Reader;

import com.abasystem.crawler.Model.Property.IrregularProperty;
import com.abasystem.crawler.Service.CustomValidator;
import com.abasystem.crawler.Strategy.ReadStrategy;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class IrregularReader implements ReadStrategy<IrregularProperty> {
    private static final Logger logger = LoggerFactory.getLogger(IrregularReader.class);

    @Override
    public IrregularProperty parse(Document document, String url, String title) {
        logger.info("IrregularParser.parse initialize");
        String phone = getPhoneNumber(document.select("#tbody"));

        return new IrregularProperty(title, document.select("#tbody").text(), document.select(".date").text(), url, phone);
    }

    private String getPhoneNumber(Elements elements) {
        Pattern pattern = Pattern.compile(CustomValidator.PHONE_REGEX);
        Matcher matcher = pattern.matcher(elements.text());

        if(matcher.find()) {
            return matcher.group();
        }

        throw new NullPointerException("ERROR : 연락처가 존재하지 않는 게시글입니다.");
    }
}
