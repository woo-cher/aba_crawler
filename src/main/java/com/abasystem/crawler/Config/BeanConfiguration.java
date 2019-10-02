package com.abasystem.crawler.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BeanConfiguration {

    @Bean
    public Map<String, String> hashMap() {
        return new HashMap<>();
    }
}
