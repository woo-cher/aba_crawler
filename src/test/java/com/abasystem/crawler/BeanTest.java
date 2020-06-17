package com.abasystem.crawler;

import com.abasystem.crawler.strategy.ValidationStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanTest {

    @Autowired
    private Map<String, String> cookies;

    @Autowired
    private ValidationStrategy validationStrategy;

    @Test
    public void getBean() {
        assertNotNull(cookies);
    }
}
