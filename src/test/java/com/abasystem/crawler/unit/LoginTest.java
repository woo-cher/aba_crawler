package com.abasystem.crawler.unit;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginTest {
    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    private WebClient webClient;
    private HtmlPage htmlPage;

//    @Before
//    public void setup() {
//        this.webClient = new WebClient();
//
//        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
//        webClient.getOptions().setThrowExceptionOnScriptError(false);
//    }
//
//    @After
//    public void after() {
//        webClient.close();
//    }
//
//    @Test
//    public void doLogin() throws IOException {
//        htmlPage = webClient.getPage(Naver.LOGIN_URL);
//
//        HtmlTextInput inputId = htmlPage.getFirstByXPath(Naver.ID_XPATH);
//        HtmlPasswordInput inputPassword = htmlPage.getFirstByXPath(Naver.PW_XPATH);
//        HtmlSubmitInput inputSubmit = htmlPage.getFirstByXPath(Naver.SUBMIT_XPATH);
//
//        inputId.setText(Naver.ID);
//        inputPassword.setText(Naver.PASSWORD);
//        inputSubmit.dblClick();
//
//        assertTrue(htmlPage.asText().contains("Naver Sign in"));
//    }
//
//    @Test
//    public void getCookie() throws IOException {
//        doLogin();
//        Set<Cookie> cookies = this.webClient.getCookieManager().getCookies();
//        logger.debug("Cookie : {}", cookies);
//        assertNotEquals(cookies.size(), 0);
//    }
}