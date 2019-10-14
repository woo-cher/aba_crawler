package com.abasystem.crawler.Service.Writer;

import au.com.bytecode.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CustomOpenCsv {
    public CSVWriter cw;

    public CSVWriter getCSVWriter(String name) throws Exception {
        OutputStream stream = new FileOutputStream(name + "_" + getDate() + ".csv");
        Writer writer = new OutputStreamWriter(stream, "EUC-KR");
        return new CSVWriter(writer, ',', '"');
    }

    private String getDate() {
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        return sd.format(date);
    }
}
