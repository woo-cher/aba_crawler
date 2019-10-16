package com.abasystem.crawler.Config;

import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Bean
    @Qualifier("webclient")
    public WebClient getWebClient() {
        WebClient webClient = new WebClient();

        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);

        return webClient;
    }

    @Bean
    public CookieManager getCookieManager() {
        return new CookieManager();
    }
}
