package com.abasystem.crawler.api.service.writer;

import au.com.bytecode.opencsv.CSVWriter;
import com.abasystem.crawler.model.office.Office;
import com.abasystem.crawler.strategy.CsvWriteStrategy;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OfficeWriter implements CsvWriteStrategy<Office> {

    @Override
    public void doWrite(JsonObject object, CSVWriter cw, int index) {
        cw.writeNext(new String[]{
                object.get("jibunAddress").getAsString(),
                object.get("extraAddress").getAsString(),
                object.get("name").getAsString(),
                object.get("representative").getAsString(),
                object.get("tel").getAsString(),
                object.get("phone").getAsString()
        });
    }
}
