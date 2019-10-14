package com.abasystem.crawler.Model;

import com.abasystem.crawler.Mapper.TypeMapper;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum InvalidKeyWord implements TypeMapper {
    KEY1("구해요"),
    KEY2("머무를"),
    KEY3("머물"),
    KEY4("머무를"),
    KEY5("구합니다"),
    KEY6("찾아요"),
    KEY7("공지");

    private String name;

    InvalidKeyWord(String name) {
        this.name = name;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "InvalidKeyWord{" +
                "name='" + name + '\'' +
                '}';
    }
}
