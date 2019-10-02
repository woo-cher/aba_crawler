package com.abasystem.crawler.Config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AbaCrawlerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AbaCrawlerApplication.class, args);
    }
}
