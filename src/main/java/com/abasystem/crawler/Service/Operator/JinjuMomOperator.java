package com.abasystem.crawler.Service.Operator;

import com.abasystem.crawler.Model.Property.IrregularProperty;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("momOperator")
public class JinjuMomOperator extends ParseTemplate {

    @Override
    public IrregularProperty getModelAfterParse(Elements elements, Document doc, String url, String title) {
        return (IrregularProperty) factory.parserCreator(false).parse(doc, url, title);
    }

    @Override
    public boolean getValidationResult(Elements elements) {
        return false;
    }
}
