package com.abasystem.crawler.Strategy;

import com.gargoylesoftware.htmlunit.WebClient;

import java.util.Map;

public interface LoginStrategy {
    boolean isLogin();
    Map<String, String> getLoginCookie(WebClient webClient);
    boolean doLogin(WebClient webClient, String id, String pw) throws Exception;
}