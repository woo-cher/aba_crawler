package com.abasystem.crawler.model.type;

import com.abasystem.crawler.mapper.TypeMapper;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum NaverCafeType implements TypeMapper {

    /**
     * 네이버 카페 도메인 이름
     *  ex) https://cafe.naver.com/kig (피터팬)
     */
    MOM("/jinjululu"),
    HAPPY("/jinju0004"),
    PETERPAN("/kig"),

    UNKNOWN("Mismatch Cafe Name");

    private String name;

    NaverCafeType(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCode() {
        return name();
    }

    public static NaverCafeType create(String code) {
        for (NaverCafeType type : values()) {
            if (type.name.equals(code)) {
                return type;
            }
        }
        return UNKNOWN;
    }

    @Override
    public String toString() {
        return "NaverCafeName {" +
                "name='" + name + '\'' +
                '}';
    }
}
