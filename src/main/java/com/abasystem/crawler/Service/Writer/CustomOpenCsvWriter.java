package com.abasystem.crawler.Service.Writer;

import au.com.bytecode.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CustomOpenCsvWriter {
    private static final Logger logger = LoggerFactory.getLogger(CustomOpenCsvWriter.class);

    public CSVWriter cw;
    private String path;
    private String name;

    public CSVWriter getCsvWriter(String fileName, String directory) throws Exception {
        String today = getDate();

        this.path = "./property/".concat(directory).concat("/").concat(today).concat("/");
        this.name = fileName.concat(".csv");

        directoryMaker(path);

        OutputStream stream = new FileOutputStream(path + name);
        Writer writer = new OutputStreamWriter(stream, "EUC-KR");

        return new CSVWriter(writer, ',', '"');
    }

    private String getDate() {
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();

        return sd.format(date);
    }

    private void directoryMaker(String path) {
        File cafeFile = new File(path);

        if(!cafeFile.exists()) {
            cafeFile.mkdirs();
        }
    }
}
