package com.abasystem.crawler.Builder;

import com.abasystem.crawler.Model.Dto.CrawlerDto;
import com.abasystem.crawler.Service.Operator.ParseTemplate;
import com.abasystem.crawler.Strategy.ObtainDocumentStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrawlerDtoBuilder implements Buildable {
    private String id;
    private String password;
    private String fileName;
    private int pageCount;
    private ParseTemplate parseTemplate;
    private ObtainDocumentStrategy strategy;

    public CrawlerDtoBuilder(String id, String password, ParseTemplate parseTemplate) {
        this.id = id;
        this.password = password;
        this.parseTemplate = parseTemplate;
    }

    public CrawlerDtoBuilder id(String id) {
        this.id = id;
        return this;
    }

    public CrawlerDtoBuilder password(String password) {
        this.password = password;
        return this;
    }

    public CrawlerDtoBuilder fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public CrawlerDtoBuilder pageCount(int maxPage) {
        this.pageCount = maxPage;
        return this;
    }

    public CrawlerDtoBuilder parseTemplate(ParseTemplate parseTemplate) {
        this.parseTemplate = parseTemplate;
        return this;
    }

    public CrawlerDtoBuilder strategy(ObtainDocumentStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    @Override
    public CrawlerDto build() {
        return new CrawlerDto(this);
    }
}
