package com.abasystem.crawler.Model.Dto;

import com.abasystem.crawler.Service.Operator.ParseTemplate;
import com.abasystem.crawler.Strategy.ObtainDocumentStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CrawlerDto {
    private String id;
    private String password;
    private String fileName;
    private int maxPage;
    private ParseTemplate parseTemplate;
    private ObtainDocumentStrategy strategy;
}
