package com.abasystem.crawler.strategy;

import com.abasystem.crawler.mapper.ModelMapper;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public interface ReadStrategy<P extends ModelMapper> {
    P parse(Document document, String url, String title);
}
