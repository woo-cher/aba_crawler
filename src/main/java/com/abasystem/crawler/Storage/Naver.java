package com.abasystem.crawler.Storage;

public class Naver {
    /**
     * USER FOR LOGIN
     */
    public static final String ID = "uioo9034";
    public static final String PASSWORD = "tkfkd01";

    /**
     * URL
     */
    public static final String LOGIN_URL = "https://nid.naver.com/nidlogin.login";
    public static final String APT_DIRECT_PROVINCES_URL = "https://cafe.naver.com/ArticleList.nhn?search.clubid=10322296&search.menuid=1115&search.boardtype=L";

    /**
     * X-PATH
     */
    public static final String ID_XPATH = "//*[@id=\"id\"]";
    public static final String PW_XPATH = "//*[@id=\"pw\"]";
    public static final String SUBMIT_XPATH = "//*[@id=\"frmNIDLogin\"]/fieldset/input";
    public static final String ALL_SEARCH_BUTTON_XPATH = "//*[@id=\"info-search\"]/form/button";

    /**
     * Specified
     */
    public static final String CAFE_PREFIX = "https://cafe.naver.com";
    public static final String CAFE_POSTFIX = "&search.sortBy=date";

    /**
     * CSS QUERY SELECTOR
     */
    public static final String POST_MINI_TITLE = ".tit-box div table tbody tr td a";
    public static final String POST_ARTICLE = ".board-list .article";
    public static final String PAGE_NAVIGATOR = ".prev-next .on";
    public static final String POST_TABLE_TBODY = "#tbody table tbody";
}
