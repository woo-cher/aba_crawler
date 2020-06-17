package com.abasystem.crawler.strategy;

import au.com.bytecode.opencsv.CSVWriter;
import com.abasystem.crawler.mapper.ModelMapper;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

@Component
public interface CsvWriteStrategy<P extends ModelMapper> {
    void doWrite(JsonObject object, CSVWriter cw, int index);
}
