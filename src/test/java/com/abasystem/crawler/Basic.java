package com.abasystem.crawler;

import com.abasystem.crawler.model.type.NaverCafeType;
import com.abasystem.crawler.storage.Naver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class Basic {

    @Test
    public void testCase() {
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();

        System.out.println("format ? " + sd.format(date));
    }

    @Test
    public void testCase2() {
        A a = new A();
        B b = new B();

        a.a = 1;
        a.b = 2;
        b.a = 3;
        b.b = 4;

        System.out.println("a.a : " + a.a);
        System.out.println("a.b : " + a.b);
        System.out.println("b.a : " + b.a);
        System.out.println("b.b : " + b.b);

        System.out.println("" + a.sub(new I() {
                @Override
                public boolean m() {
                    return false;
                }
            })
        );
    }

    @Test
    public void testCase3() {
        String str = "공지 (필독) 진아카페가입시 회칙 확인후 활동부탁드립니다. | 진아카페회칙(필독) 2014.10.29. 16:13 말머리없음 매니저 단이네79(bavo****) 카페매니저";

        assertTrue(str.contains("공지"));
    }

    @Test
    public void phoneValidation() {
        Pattern pattern;
        Matcher matcher;

        String p1 = "##ㅁㄴ# 0일0.12오사-4이2팔 123123";
        String p2 = "010-12오사-4이2팔";
        String p3 = "영일0-12오사-4이2팔";
        String p4 = "영10-12오사-4이2팔";
        String p5 = "영일영-12오사-4이2팔";

        pattern = Pattern.compile("[0일|01|영일|영1]{2}[0|영][-?|.?].{4}[-?|.?].{4}");

        matcher = pattern.matcher(p1);

        if(matcher.find()) {
            System.out.println(matcher.group());
        }

        matcher = pattern.matcher(p2);
        if(matcher.find()) {
            System.out.println(matcher.group());
        }

        matcher = pattern.matcher(p3);
        if(matcher.find()) {
            System.out.println(matcher.group());
        }

        matcher = pattern.matcher(p4);
        if(matcher.find()) {
            System.out.println(matcher.group());
        }

        matcher = pattern.matcher(p5);
        if(matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void hashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");

        for(String key : map.keySet()) {
            System.out.println(String.format("키 : %s, 값 : %s", key, map.get(key)));
        }
    }

    @Test
    public void testCase4() throws IOException {
        Document document = Jsoup.connect(Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=2&search.boardtype=L").get();
        Elements elements = document.select("#sub-tit .sub-tit-color");

        System.out.println(elements.text());
    }

    @Test
    public void testCase5() {
        String invalidChar = "[\\\\|/|:|*|?|\"|>|<|]";
        String case1 = "개인:직거래";
        String case2 = "개인*직거래";
        String case3 = "<개인>직거래";
        String case4 = "개인|직거래";
        String case5 = "\"개인\"직거래";
        String case6 = "개인\\직거래";

        for(String str : invalidChar.split("")) {
            if(case1.contains(str)) {
                System.out.println("true");
            }
        }

        System.out.println(case1.replaceAll(invalidChar, ""));
        System.out.println(case2.replaceAll(invalidChar, ""));
        System.out.println(case3.replaceAll(invalidChar, ""));
        System.out.println(case4.replaceAll(invalidChar, ""));
        System.out.println(case5.replaceAll(invalidChar, ""));
        System.out.println(case6.replaceAll(invalidChar, ""));
    }

    @Test
    public void testCase6() {
        List list = new ArrayList();
        System.out.println("Result : " + list.isEmpty());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testCase7() {
        NaverCafeType name = NaverCafeType.create("/kig");
        System.out.println("name : " + name);
        System.out.println("getName : " + name.getName());
        System.out.println("getCode : " + name.getCode());
        System.out.println("is equals? " + NaverCafeType.PETERPAN.equals(name));
    }
}

class Super {
    public int a;
    public int b;
}

class A extends Super {
    A() {
        super();
    }

    boolean sub(I i) {
        return i.m();
    }

}

class B extends Super {
    B() {
        super();
    }
}

interface I {
    boolean m();
}
