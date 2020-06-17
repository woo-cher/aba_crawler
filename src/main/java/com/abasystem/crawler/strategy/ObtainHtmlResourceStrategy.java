package com.abasystem.crawler.strategy;

import java.io.IOException;

public interface ObtainHtmlResourceStrategy {
    String getUrlAfterSearch() throws IOException;
}
