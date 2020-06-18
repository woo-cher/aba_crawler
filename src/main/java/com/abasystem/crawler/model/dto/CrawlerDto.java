package com.abasystem.crawler.model.dto;

import com.abasystem.crawler.builder.CrawlerDtoBuilder;
import com.abasystem.crawler.api.service.operator.ParseTemplate;
import com.abasystem.crawler.strategy.ObtainDocumentStrategy;
import com.abasystem.crawler.strategy.ObtainHtmlResourceStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CrawlerDto {
    private Account account;
    private String fileName;
    private int pageCount;
    private ParseTemplate parseTemplate;
    private String directory;
    private ObtainDocumentStrategy documentStrategy;
    private ObtainHtmlResourceStrategy resourceStrategy;

    public CrawlerDto(CrawlerDtoBuilder builder) {
        this.account = builder.getAccount();
        this.fileName = builder.getFileName();
        this.pageCount = builder.getPageCount();
        this.parseTemplate = builder.getParseTemplate();
        this.documentStrategy = builder.getDocumentStrategy();
        this.directory = builder.getDirectory();
    }

    public CrawlerDto(Account account, String fileName, int pageCount, ParseTemplate parseTemplate, String directory, ObtainHtmlResourceStrategy resourceStrategy) {
        this.account = account;
        this.fileName = fileName;
        this.pageCount = pageCount;
        this.parseTemplate = parseTemplate;
        this.directory = directory;
        this.resourceStrategy = resourceStrategy;
    }
}
