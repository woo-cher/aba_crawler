package com.abasystem.crawler.Service;

import com.abasystem.crawler.Storage.Naver;
import com.abasystem.crawler.Strategy.LoginStrategy;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.util.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class NaverLoginService implements LoginStrategy {
    private static final Logger logger = LoggerFactory.getLogger(NaverLoginService.class);

    @Autowired
    @Qualifier("webclient")
    public WebClient webClient;

    boolean isLogin;

    @Override
    public boolean isLogin() {
        return isLogin;
    }

    public Map<String, String> getLoginCookie() {
        Map<String, String> cookies = new HashMap<>();
        CookieManager cookieManager = webClient.getCookieManager();

        Set<Cookie> cookieSet = cookieManager.getCookies();

        for (Cookie c : cookieSet) {
            cookies.put(c.getName(), c.getValue());
        }

        logger.info("Get Cookies : {}", cookies);

        return cookies;
    }

    public boolean doLogin(String id, String pw) throws Exception {
        isLogin = false;

        HtmlPage page = webClient.getPage(Naver.LOGIN_URL);

        HtmlTextInput inputId = page.getFirstByXPath(Naver.ID_XPATH);
        HtmlPasswordInput inputPassword = page.getFirstByXPath(Naver.PW_XPATH);
        HtmlSubmitInput inputSubmit = page.getFirstByXPath(Naver.SUBMIT_XPATH);

        webClient.waitForBackgroundJavaScriptStartingBefore(200);
        webClient.waitForBackgroundJavaScript(20000);

        inputId.setText(id);
        inputPassword.setText(pw);
        inputSubmit.dblClick();

        if (!page.asText().contains("Naver Sign in")) {
            isLogin = false;
            throw new Exception("Cannot login with the id and pw");
        }

        else {
            isLogin = true;
            logger.info("──── login success");
        }

        page.remove();

        return isLogin;
    }

    public void close() {
        this.webClient.close();
    }
}
