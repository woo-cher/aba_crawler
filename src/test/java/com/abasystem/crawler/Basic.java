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
}