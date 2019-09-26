package com.abasystem.crawler.Strategy;

import com.abasystem.crawler.Mapper.ModelMapper;
import org.jsoup.nodes.Document;

import java.io.IOException;

public interface ParseStrategy<P extends ModelMapper> {
   <P> P parse(Document document, String url, String title) throws IOException;
}
