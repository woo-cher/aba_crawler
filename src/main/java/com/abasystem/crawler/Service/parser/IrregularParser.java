package com.abasystem.crawler.Service.parser;

import com.abasystem.crawler.Model.PeterPan.IrregularProperty;
import com.abasystem.crawler.Strategy.ParseStrategy;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class IrregularParser implements ParseStrategy<IrregularProperty> {
    private static final Logger logger = LoggerFactory.getLogger(IrregularParser.class);

    @Override
    public IrregularProperty parse(Document document, String url, String title) throws IOException {
        logger.debug("IrregularParser.parse initialize");
        return new IrregularProperty(title, document.select("#tbody").text(), document.select(".date").text(), url);
    }
}
