package com.abasystem.crawler.Service.Operator;

import com.abasystem.crawler.Mapper.ModelMapper;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("peterOperator")
public class PeterPanParseOperator extends ParseTemplate {
    private static final Logger logger = LoggerFactory.getLogger(PeterPanParseOperator.class);

    @Override
    public ModelMapper getModelAfterParse(Elements elements, Document doc, String url, String title) {
        boolean flag = validationStrategy.isRegularPost(doc.select("#tbody"));
        logger.info("PeterOperation initialize");
        return factory.parserCreator(flag).parse(doc, url, title);
    }

    @Override
    public boolean isContainModerateKeyword(Elements elements) {
        return validationStrategy.isPropertyPost(elements);
    }
}
