package com.abasystem.crawler.Strategy;

import com.gargoylesoftware.htmlunit.WebClient;

import java.util.Map;

public interface LoginStrategy {
    boolean isLogin();
    Map<String, String> makeLoginCookie(WebClient webClient);
    boolean doLogin(WebClient webClient, String id, String pw) throws Exception;
}