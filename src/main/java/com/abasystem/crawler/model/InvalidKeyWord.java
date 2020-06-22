package com.abasystem.crawler.model;

import com.abasystem.crawler.mapper.TypeMapper;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum InvalidKeyWord implements TypeMapper {
    KEY2("머무를"),
    KEY3("머물"),
    KEY4("머무를"),
    KEY5("구합니다"),
    KEY6("찾아요"),
    KEY7("구해요"),
    KEY8("공인중개사"),
    KEY9("소장"),
    KEY10("접수"),
    KEY11("부촌"),
    KEY12("프리마켓"),
    KEY13("구함"),
    KEY14("중개업체"),
    KEY15("있을까요"),
    KEY16("재테크"),
    KEY17("투자"),
    KEY18("공지"),

    SPECIFIC1("장갑"),
    SPECIFIC2("[양재동]1.5룸 반전세 있습니다"),
    SPECIFIC3("성남시 은행동 완벽한 리모델링 전세!!");

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
