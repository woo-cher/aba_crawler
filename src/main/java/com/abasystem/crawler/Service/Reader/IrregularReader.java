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
        String phone = getPhoneNumber(document.select(".inbox"));

        return new IrregularProperty(title, document.select("#tbody").text(), document.select(".date").text(), url, phone);
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
