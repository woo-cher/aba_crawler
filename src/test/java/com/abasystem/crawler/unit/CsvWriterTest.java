package com.abasystem.crawler.unit;

import au.com.bytecode.opencsv.CSVWriter;
import com.abasystem.crawler.builder.RegularPostBuilder;
import com.abasystem.crawler.factory.ServiceFactory;
import com.abasystem.crawler.mapper.ModelMapper;
import com.abasystem.crawler.model.property.IrregularProperty;
import com.abasystem.crawler.api.service.Converter.DataConverter;
import com.abasystem.crawler.api.service.CrawlerService;
import com.abasystem.crawler.strategy.CsvWriteStrategy;
import com.google.gson.JsonObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CsvWriterTest {
    private static final Logger logger = LoggerFactory.getLogger(CsvWriterTest.class);

    @Autowired
    private ServiceFactory factory;

    @Autowired
    private CrawlerService service;

    private List<ModelMapper> properties;

    @Before
    public void setup() {
        properties = new ArrayList<>();
    }

    @Test
    public void csvWrite() throws Exception {
        OutputStream stream = new FileOutputStream("C:\\Users\\ABA_System_WC\\Desktop\\test-property.csv");
        Writer writer = new OutputStreamWriter(stream, "EUC-KR");
        CSVWriter cw = new CSVWriter(writer, ',', '"');

        for (int i = 1; i < 11; i++) {
            properties.add(new RegularPostBuilder(("TITLE" + i), ("URL" + i), ("DATE" + i), ("DESC" + i)).build());
        }

        cw.writeNext(new String[]{"번호", "제목", "링크", "날짜", "설명2"});
        int index = 1;
        for (ModelMapper property : properties) {
            JsonObject object = DataConverter.convertModelToJsonObject(property);
            CsvWriteStrategy csvWriteStrategy = factory.writerCreator(property.getClass());
            csvWriteStrategy.doWrite(object, cw, index++);
        }

        assertFalse(cw.checkError());

        cw.close();
        cw.flush();
    }

    @Test
    public void csvAllWrite() throws Exception {
        for (int i = 1; i < 11; i++) {
            properties.add(new RegularPostBuilder(("TITLE" + i), ("URL" + i), ("DATE" + i), ("DESC" + i)).build());
            properties.add(new IrregularProperty("TITLE" + i, "DESCRIPTION" + i, "DATE" + i, "URL" + i, "PHONE" + i));
        }

        assertTrue(service.writeAll(properties, "TestCSV", "TEST_CSV"));
        properties.clear();
        assertFalse(service.writeAll(properties, "TestCSV", "TEST_CSV"));
    }
}
