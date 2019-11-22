package com.abasystem.crawler.Scheduler.Normal;

import com.abasystem.crawler.Scheduler.CrawlerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WithoutSearchSingleScheduler extends CrawlerTemplate {
    private static final Logger logger = LoggerFactory.getLogger(WithoutSearchSingleScheduler.class);

    @Override
    protected String getUrlAfterSearch() throws IOException {
        // Nothing to search
        return "";
    }
}
