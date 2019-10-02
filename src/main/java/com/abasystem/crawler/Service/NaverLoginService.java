package com.abasystem.crawler.Service;

import com.abasystem.crawler.Strategy.LoginStrategy;
import com.abasystem.crawler.Storage.Naver;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.util.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class NaverLoginService implements LoginStrategy {
    private static final Logger logger = LoggerFactory.getLogger(NaverLoginService.class);

    boolean isLogin;

    @Override
    public boolean isLogin() {
        return isLogin;
    }

    public Map<String, String> makeLoginCookie(WebClient webClient) {
        Map<String, String> cookies = new HashMap<>();
        CookieManager cookieManager = webClient.getCookieManager();

        Set<Cookie> cookieSet = cookieManager.getCookies();

        for (Cookie c : cookieSet) {
            cookies.put(c.getName(), c.getValue());
        }

        return cookies;
    }

    public boolean doLogin(WebClient webClient, String id, String pw) throws Exception {
        HtmlPage page = webClient.getPage(Naver.LOGIN_URL);

        HtmlTextInput inputId = page.getFirstByXPath(Naver.ID_XPATH);
        HtmlPasswordInput inputPassword = page.getFirstByXPath(Naver.PW_XPATH);
        HtmlSubmitInput inputSubmit = page.getFirstByXPath(Naver.SUBMIT_XPATH);

        inputId.setText(id);
        inputPassword.setText(pw);
        inputSubmit.dblClick();

        if (!page.asText().contains("Naver Sign in")) {
            isLogin = false;
            throw new Exception("cannot login with the id and pw");
        }

        else {
            isLogin = true;
            logger.debug("login success !!");
        }

        return isLogin;
    }
}
