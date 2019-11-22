package com.abasystem.crawler.Strategy;

import java.io.IOException;

public interface ObtainHtmlResourceStrategy {
    String getUrlAfterSearch() throws IOException;
}