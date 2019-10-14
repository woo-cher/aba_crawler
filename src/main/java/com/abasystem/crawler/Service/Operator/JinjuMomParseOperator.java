package com.abasystem.crawler.Service.Operator;

import com.abasystem.crawler.Model.Property.IrregularProperty;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("momOperator")
public class JinjuMomParseOperator extends ParseTemplate {
    private static final Logger logger = LoggerFactory.getLogger(JinjuMomParseOperator.class);

    @Override
    public IrregularProperty getModelAfterParse(Elements elements, Document doc, String url, String title) {
        logger.info("MomOperator initialize");
        return (IrregularProperty) factory.parserCreator(false).parse(doc, url, title);
    }

    @Override
    public boolean getValidationResult(Elements elements) {
        return true;
    }
}
