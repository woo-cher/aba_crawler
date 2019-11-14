package com.abasystem.crawler.Model.Dto;

import com.abasystem.crawler.Builder.CrawlerDtoBuilder;
import com.abasystem.crawler.Service.Operator.ParseTemplate;
import com.abasystem.crawler.Strategy.ObtainDocumentStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CrawlerDto {
    private String id;
    private String password;
    private String fileName;
    private int pageCount;
    private ParseTemplate parseTemplate;
    private ObtainDocumentStrategy strategy;

    public CrawlerDto(CrawlerDtoBuilder builder) {
        this.id = builder.getId();
        this.password = builder.getPassword();
        this.fileName = builder.getFileName();
        this.pageCount = builder.getPageCount();
        this.parseTemplate = builder.getParseTemplate();
        this.strategy = builder.getStrategy();
    }
}
