package com.abasystem.crawler.Strategy;

import org.jsoup.nodes.Document;

import java.io.IOException;

public interface ObtainDocumentStrategy {
    Document getDocument(String url) throws IOException;
}
