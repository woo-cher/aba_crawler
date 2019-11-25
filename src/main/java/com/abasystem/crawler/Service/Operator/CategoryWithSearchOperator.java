package com.abasystem.crawler.Service.Operator;

import com.abasystem.crawler.Model.Property.IrregularProperty;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("CategoryWithSearchOperator")
public class CategoryWithSearchOperator extends ParseTemplate {
    private static final Logger logger = LoggerFactory.getLogger(CategoryWithSearchOperator.class);

    @Override
    public IrregularProperty getModelAfterParse(Elements elements, Document doc, String url, String title) {
        logger.info("CategoryWithSearchOperator initialize");
        return (IrregularProperty) serviceFactory.parserCreator(false).parse(doc, url, title);
    }

    @Override
    public boolean isContainPropertyKeyword(Elements elements) {
        return validationStrategy.isContainPropertyType(elements);
    }
}
