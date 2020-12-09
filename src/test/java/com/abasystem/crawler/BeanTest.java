package com.abasystem.crawler;

import com.abasystem.crawler.strategy.ValidationStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanTest {
    private static final Logger logger = LoggerFactory.getLogger(BeanTest.class);

    @Autowired
    private Map<String, String> cookies;

    @Autowired
    private Map<String, String> cookies2;

    @Autowired
    private ValidationStrategy validationStrategy;

    @Test
    public void getBean() {
        assertNotNull(cookies);
        assertNotNull(cookies2);
        logger.info("addr : {}", System.identityHashCode(cookies));
        logger.info("addr2 : {}", System.identityHashCode(cookies2));
        assertEquals(cookies, cookies2);
        cookies.put("k", "v");
        logger.info("1. : {}", cookies);
        logger.info("2. : {}", cookies2);
    }
}
