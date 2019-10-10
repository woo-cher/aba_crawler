package com.abasystem.crawler.Service.Writer;

import au.com.bytecode.opencsv.CSVWriter;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

@Component
public class CustomOpenCsv {
    public OutputStream stream;
    public Writer writer;
    public CSVWriter cw;

    public CustomOpenCsv() throws Exception {
        this.stream = new FileOutputStream("property.csv");
        writer = new OutputStreamWriter(stream, "EUC-KR");
        cw = new CSVWriter(writer, ',', '"');
    }
}
