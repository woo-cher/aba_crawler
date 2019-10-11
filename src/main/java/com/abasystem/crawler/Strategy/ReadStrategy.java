package com.abasystem.crawler.Strategy;

import com.abasystem.crawler.Mapper.ModelMapper;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public interface ReadStrategy<P extends ModelMapper> {
    P parse(Document document, String url, String title);
}