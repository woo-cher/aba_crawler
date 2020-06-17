package com.abasystem.crawler.strategy;

import org.jsoup.nodes.Document;

import java.io.IOException;

public interface ObtainDocumentStrategy {
    Document getDocument(String url) throws IOException;
}
