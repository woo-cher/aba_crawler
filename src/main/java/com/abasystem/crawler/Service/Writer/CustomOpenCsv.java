package com.abasystem.crawler.Service.Writer;

import au.com.bytecode.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CustomOpenCsv {
    public CSVWriter cw;

    public CSVWriter getCSVWriter(String fileName, String directory) throws Exception {
        String path = "./property/".concat(directory).concat("/");
        String name = fileName.concat("_").concat(getDate()).concat(".csv");

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
        File file = new File(path);

        if(!file.exists()) {
            file.mkdirs();
        }
    }
}
