package com.abasystem.crawler.util;

import com.abasystem.crawler.model.dto.Account;
import com.abasystem.crawler.storage.Naver;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Todo)
 *  1. 현재 피터팬 카페에 관한 액션만 구현되어 있어서, 다형성을 갖도록 리팩토링 해야한다
 *  2. 이름이 갖는 의미가 에매하다
 */
@UtilityClass
public class CommonsUtils {
    private static final Logger logger = LoggerFactory.getLogger(CommonsUtils.class);

    public static String getUrlWithSearch(String key, String url, String submitXPath) throws IOException {
        WebClient webClient = new WebClient();

        // Get Page
        HtmlPage currPage = webClient.getPage(url);
        logger.debug("page ? {}", currPage);

        // Find Form with 'name' attribute
        HtmlForm form = currPage.getFormByName("frmBoardSearch");
        logger.debug("form ? {}", form);

        // Find 'input' element with 'name' attribute
        HtmlTextInput query = form.getInputByName("query");
        logger.debug("query ? {}", query);

        // Find 'button' element with XPath
        HtmlButton btn = (HtmlButton) form.getByXPath(submitXPath).get(0);

        /**
         * Result URL : https://cafe.naver.com/ArticleSearchList.nhn?search.clubid=10322296&search.searchBy=0&search.query=%C1%F8%C1%D6
         * 1. Set attribute at input box
         * 2. Find button and click
         * 3. Get URL at Response page with keyword
         */
        query.setValueAttribute(key);
        currPage = btn.click();
        logger.debug("currPage ? {}", currPage.getUrl());

        return currPage.getUrl().toString().concat(Naver.CAFE_POSTFIX);
    }

    public static Account getAccountByProperties(String ... aliasName) {
        Account account = null;

        try {
            FileInputStream fi = new FileInputStream("account.properties");
            Properties prop = new Properties();
            prop.load(fi);

            String id = prop.getProperty(aliasName[0]);
            String pw = prop.getProperty(aliasName[1]);

            account = new Account(id, pw);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return account;
    }
}
