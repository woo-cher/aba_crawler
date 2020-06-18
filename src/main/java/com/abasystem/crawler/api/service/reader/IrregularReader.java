package com.abasystem.crawler.api.service.reader;

import com.abasystem.crawler.model.property.IrregularProperty;
import com.abasystem.crawler.api.service.CustomValidator;
import com.abasystem.crawler.strategy.ReadStrategy;
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
        String phone = getPhoneNumber(document.select("#main-area"));

        return new IrregularProperty(title, document.select("#tbody").text(), document.select(".m-tcol-c.date").text(), url, phone);
    }

    public String getPhoneNumber(Elements elements) {
        String str = elements.text().replaceAll(" ", "");

        Pattern pattern = Pattern.compile(CustomValidator.PHONE_REGEX);
        Matcher matcher = pattern.matcher(str);

        if(matcher.find()) {
            return matcher.group();
        }

        throw new NullPointerException("ERROR : Phone Number Not Find");
    }
}
