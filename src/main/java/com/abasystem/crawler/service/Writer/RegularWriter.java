package com.abasystem.crawler.service.Writer;

import au.com.bytecode.opencsv.CSVWriter;
import com.abasystem.crawler.model.Property.RegularProperty;
import com.abasystem.crawler.strategy.CsvWriteStrategy;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegularWriter implements CsvWriteStrategy<RegularProperty> {
    private static final Logger logger = LoggerFactory.getLogger(RegularWriter.class);

    @Override
    public void doWrite(JsonObject object, CSVWriter cw, int index) {
        cw.writeNext(new String[] {
                String.valueOf(index),
                object.get("title").getAsString(),
                object.get("url").getAsString(),
                object.get("description").getAsString(),
                object.get("phone").getAsString(),
                object.get("date").getAsString(),
                object.get("address").getAsString(),
                object.get("propertyType").getAsString(),
                object.get("price").getAsString(),
                object.get("managementPrice").getAsString(),
                object.get("options").getAsString(),
                object.get("movePossibleDate").getAsString(),
                object.get("roomCount").getAsString(),
                object.get("floor").getAsString(),
                object.get("managementCategory").getAsString(),
                object.get("heatingType").getAsString()
        });
    }
}
