package com.abasystem.crawler;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

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