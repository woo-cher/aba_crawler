package com.abasystem.crawler.Service.Operator;

import com.abasystem.crawler.Mapper.ModelMapper;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("peterOperator")
public class PeterPanOperator extends ParseTemplate {

    @Override
    public ModelMapper getModelAfterParse(Elements elements, Document doc, String url, String title) {
        boolean flag = validationStrategy.isRegularPost(doc.select("#tbody"));

        return factory.parserCreator(flag).parse(doc, url, title);
    }

    @Override
    public boolean getValidationResult(Elements elements) {
        return validationStrategy.isPropertyPost(elements);
    }
}
