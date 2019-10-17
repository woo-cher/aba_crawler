package com.abasystem.crawler.Scheduler;

import com.abasystem.crawler.Factory.RepositoryFactory;
import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Repository.SchedulerRepository;
import com.abasystem.crawler.Service.CrawlerService;
import com.abasystem.crawler.Service.NaverLoginService;
import com.abasystem.crawler.Service.Operator.ParseTemplate;
import com.abasystem.crawler.Service.PostInitializer;
import com.abasystem.crawler.Strategy.BasicQueryStrategy;
import com.abasystem.crawler.Strategy.ObtainDocumentStrategy;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public abstract class CrawlerTemplate {
    private static final Logger logger = LoggerFactory.getLogger(CrawlerTemplate.class);

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

    abstract String getUrlAfterSearch() throws IOException;

    public void crawling(String id, String pw, String fileName, int maxPage, ParseTemplate parseTemplate, ObtainDocumentStrategy strategy) throws Exception {
        loginService.doLogin(id, pw);
        logger.info("──── Is login ?" + loginService.isLogin());

        cookies = loginService.getLoginCookie();

        Elements elements = initializer.initPosts(strategy.getDocument(getUrlAfterSearch()), maxPage);
        logger.info("──── Elements obtain Success");

        properties = parseTemplate.parseAll(elements, cookies);
        logger.info("──── Parsing Success");

        int row = 0;
        for (ModelMapper property : properties) {
            queryStrategy = factory.getTypeRepositoryCreator(property.getClass());
            row += queryStrategy.createProp(property);
        }
        logger.info("──── INSERT ROW COUNT : {}", row);

        service.writeAll(properties, fileName);
        logger.info("──── Crawling Success");

        repository.insertLog(row);
        logger.info("──── Log save complete");
        logger.info("──── End Crawling");
    }
}
