package com.abasystem.crawler.Scheduler;

import com.abasystem.crawler.Factory.RepositoryFactory;
import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Repository.SchedulerRepository;
import com.abasystem.crawler.Service.CrawlerService;
import com.abasystem.crawler.Service.NaverLoginService;
import com.abasystem.crawler.Service.PostInitializer;
import com.abasystem.crawler.Strategy.BasicQueryStrategy;
import com.gargoylesoftware.htmlunit.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomScheduler {
    private static final Logger logger = LoggerFactory.getLogger(CustomScheduler.class);

    @Autowired
    protected CrawlerService service;

    @Autowired
    protected NaverLoginService loginService;

    @Autowired
    protected RepositoryFactory factory;

    @Autowired
    protected SchedulerRepository repository;

    @Autowired
    protected PostInitializer initializer;

    protected Map<String, String> cookies;
    protected List<? extends ModelMapper> properties;
    protected BasicQueryStrategy queryStrategy;
}
