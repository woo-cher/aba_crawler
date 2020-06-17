package com.abasystem.crawler.Storage;

public class Naver {

    /**
     *  --------------------------------------------------
     *  \\              USER FOR LOGIN                  \\
     *  --------------------------------------------------
     */
    public static final String ID = "aba9246";
    public static final String PASSWORD = "dkqk123!!";

    public static final String ID2 = "uioo9034";
    public static final String PASSWORD2 = "tkfkd01";

//    public static final String MOM_ID = "kthlove0328";
//    public static final String MOM_PW = "xognsqudtls";

   /**
     *  --------------------------------------------------
     *  \\                    URLs                      \\
     *  --------------------------------------------------
     */
    public static final String LOGIN_URL = "http://nid.naver.com/nidlogin.login";
    public static final String APT_DIRECT_PROVINCES_URL = "https://cafe.naver.com/ArticleList.nhn?search.clubid=10322296&search.menuid=1115&search.boardtype=L";
    public static final String MOM_DIRECT_URL = "https://cafe.naver.com/ArticleList.nhn?search.clubid=24207408&search.menuid=98&search.boardtype=L";

    public static final String PETERPAN_CAFE_URL = "https://cafe.naver.com/kig";
    public static final String PETERPAN_GWANAKGU_URL= "https://cafe.naver.com/ArticleList.nhn?search.clubid=10322296&search.menuid=3&search.boardtype=L";

    public static final String HAPPY_CAFE_URL = "https://cafe.naver.com/ArticleList.nhn?search.clubid=19167452&search.menuid=857&search.boardtype=L";

    /**
     *  --------------------------------------------------
     *  \\                   X-PATH                     \\
     *  --------------------------------------------------
     */
    public static final String ID_XPATH = "//*[@id=\"id\"]";
    public static final String PW_XPATH = "//*[@id=\"pw\"]";
    public static final String SUBMIT_XPATH = "//*[@id=\"frmNIDLogin\"]/fieldset/input";
    public static final String PETER_SEARCH_BUTTON_XPATH = "//*[@id=\"cafe-search\"]/form/button";
    public static final String HAPPY_SEARCH_BUTTON_XPATH = "//*[@id=\"cafe-search\"]/form/button";

    /**
     *  --------------------------------------------------
     *  \\                  SPECIFIED                  \\
     *  --------------------------------------------------
     */
    public static final String CAFE_PREFIX = "https://cafe.naver.com";
    public static final String CAFE_POSTFIX = "&search.sortBy=date";

    /**
     *  --------------------------------------------------
     *  \\              CSS QUERY SELECTOR              \\
     *  --------------------------------------------------
     */
    public static final String POST_MINI_TITLE = ".tit-box div table tbody tr td a";

    public static final String DIV_POST_ARTICLE = ".article";
    public static final String SPAN_POST_ARTICLE = "a[onmouseover='']";

    public static final String DIV_POST_NEXT = ".pgR";
    public static final String SPAN_POST_NEXT = ".pn";

    public static final String PAGE_NAVIGATOR = ".prev-next .on";
    public static final String PAGE_NAVIGATOR2 = ".prev-next td[class='on'] a";

    public static final String POST_TABLE_TBODY = "#tbody table tbody";
    public static final String CATEGORY_TITLE = "#sub-tit .sub-tit-color";
}
