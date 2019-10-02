package com.abasystem.crawler.Strategy;

import au.com.bytecode.opencsv.CSVWriter;
import com.abasystem.crawler.Mapper.ModelMapper;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

@Component
public interface CsvWriteStrategy<P extends ModelMapper> {
    void doWrite(JsonObject object, CSVWriter cw, int index);
}
