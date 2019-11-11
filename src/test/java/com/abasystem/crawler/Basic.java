package com.abasystem.crawler;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
        System.out.println("a.a : " + a.b);
        System.out.println("b.a : " + b.a);
        System.out.println("b.a : " + b.b);

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