package com.abasystem.crawler.Strategy;

import com.abasystem.crawler.Mapper.ModelMapper;
import org.jsoup.nodes.Document;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface ParseStrategy<P extends ModelMapper> {
    P parse(Document document, String url, String title);
}