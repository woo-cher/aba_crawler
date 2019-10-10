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
    public OutputStream stream;
    public Writer writer;
    public CSVWriter cw;

    public CustomOpenCsv() throws Exception {
        this.stream = new FileOutputStream("property" + getDate() + ".csv");
        writer = new OutputStreamWriter(stream, "UTF-8");
        cw = new CSVWriter(writer, ',', '"');
    }

    private String getDate() {
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        return sd.format(date);
    }
}
