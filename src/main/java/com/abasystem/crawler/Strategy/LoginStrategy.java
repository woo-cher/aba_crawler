package com.abasystem.crawler.Strategy;

import java.util.Map;

public interface LoginStrategy {
    boolean isLogin();
    Map<String, String> getLoginCookie();
    boolean doLogin(String id, String pw) throws Exception;
}