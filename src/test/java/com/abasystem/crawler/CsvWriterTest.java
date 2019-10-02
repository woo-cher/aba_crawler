package com.abasystem.crawler;

import au.com.bytecode.opencsv.CSVWriter;
import com.abasystem.crawler.Builder.RegularPostBuilder;
import com.abasystem.crawler.Factory.ServiceFactory;
import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Model.PeterPan.IrregularProperty;
import com.abasystem.crawler.Service.Converter.ModelConverter;
import com.abasystem.crawler.Service.PeterPanService;
import com.abasystem.crawler.Strategy.CsvWriteStrategy;
import com.google.gson.JsonObject;
import org.junit.After;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class CsvWriterTest {
    private static final Logger logger = LoggerFactory.getLogger(CsvWriterTest.class);

    @Autowired
    private ServiceFactory factory;

    @Autowired
    private PeterPanService service;

    private List<ModelMapper> properties;
    private OutputStream stream;
    private Writer writer;
    private CSVWriter cw;

    @Before
    public void setup() throws Exception {
        properties = new ArrayList<>();
        stream = new FileOutputStream("C:\\Users\\ABA_System_WC\\Desktop\\test-property.csv");
        writer = new OutputStreamWriter(stream, "EUC-KR");
        cw = new CSVWriter(writer, ',', '"');
    }

    @After
    public void after() throws Exception {
        cw.close();
        cw.flush();
    }

    @Test
    public void csvWrite() {
        for(int i = 1; i < 11; i++) {
            properties.add(new RegularPostBuilder(("TITLE" + i), ("URL" + i), ("DATE" + i), ("DESC" + i)).build());
        }

        cw.writeNext(new String[] {"번호", "제목", "링크", "날짜", "설명2"});
        int index = 1;
        for(ModelMapper property : properties) {
            JsonObject object = ModelConverter.convertModelToJsonObject(property);
            CsvWriteStrategy csvWriteStrategy = factory.writerCreator(property.getClass());
            csvWriteStrategy.doWrite(object, cw, index++);
        }
        assertFalse(cw.checkError());
    }

    @Test
    public void csvAllWrite() {
        for(int i = 1; i < 11; i++) {
            properties.add(new RegularPostBuilder(("TITLE" + i), ("URL" + i), ("DATE" + i), ("DESC" + i)).build());
            properties.add(new IrregularProperty("TITLE" + i, "DESCRIPTION" + i, "DATE" + i, "URL" + i));
        }

        assertFalse(service.writeAll(properties));
    }
}