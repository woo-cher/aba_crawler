package com.abasystem.crawler.Service.Reader;

import com.abasystem.crawler.Model.Property.IrregularProperty;
import com.abasystem.crawler.Strategy.ReadStrategy;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class IrregularReader implements ReadStrategy<IrregularProperty> {
    private static final Logger logger = LoggerFactory.getLogger(IrregularReader.class);

    @Override
    public IrregularProperty parse(Document document, String url, String title) {
        logger.info("IrregularParser.parse initialize");
        return new IrregularProperty(title, document.select("#tbody").text(), document.select(".date").text(), url);
    }
}
