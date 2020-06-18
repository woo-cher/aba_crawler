package com.abasystem.crawler.api.service.Operator;

import com.abasystem.crawler.model.property.IrregularProperty;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("CategoryOfPropertyOperator")
public class CategoryOfPropertyOperator extends ParseTemplate {
    private static final Logger logger = LoggerFactory.getLogger(CategoryOfPropertyOperator.class);

    @Override
    public IrregularProperty getModelAfterParse(Elements elements, Document doc, String url, String title) {
        logger.info("CategoryOfPropertyOperator initialize");
        return (IrregularProperty) serviceFactory.parserCreator(false).parse(doc, url, title);
    }

    @Override
    public boolean isContainPropertyKeyword(Elements elements) {
        // Nothing to validation
        return true;
    }
}
