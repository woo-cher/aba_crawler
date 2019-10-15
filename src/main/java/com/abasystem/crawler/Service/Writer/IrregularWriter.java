package com.abasystem.crawler.Service.Writer;

import au.com.bytecode.opencsv.CSVWriter;
import com.abasystem.crawler.Model.Property.IrregularProperty;
import com.abasystem.crawler.Strategy.CsvWriteStrategy;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class IrregularWriter implements CsvWriteStrategy<IrregularProperty> {
    private static final Logger logger = LoggerFactory.getLogger(IrregularWriter.class);

    @Override
    public void doWrite(JsonObject object, CSVWriter cw, int index) {
        cw.writeNext(new String[]{
                String.valueOf(index),
                object.get("title").getAsString(),
                object.get("url").getAsString(),
                object.get("description").getAsString(),
                object.get("phone").getAsString(),
                object.get("date").getAsString()
        });
    }
}
