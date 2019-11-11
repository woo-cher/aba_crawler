package com.abasystem.crawler.Scheduler;

import com.abasystem.crawler.Factory.RepositoryFactory;
import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Model.Dto.CrawlerDto;
import com.abasystem.crawler.Repository.SchedulerRepository;
import com.abasystem.crawler.Service.CrawlerService;
import com.abasystem.crawler.Service.NaverLoginService;
import com.abasystem.crawler.Service.PostInitializer;
import com.abasystem.crawler.Strategy.BasicQueryStrategy;
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

    abstract protected String getUrlAfterSearch() throws IOException;

    public void singleCrawling(CrawlerDto dto) throws Exception {
        initializer(dto.getId(), dto.getPassword());

        Elements elements = initializer.initPosts(dto.getStrategy().getDocument(getUrlAfterSearch()), dto.getMaxPage());
        logger.info("──── Elements obtain Success");

        properties = dto.getParseTemplate().parseAll(elements, cookies);
        logger.info("──── Parsing Success");

        int row = 0;
        for (ModelMapper property : properties) {
            queryStrategy = factory.getTypeRepositoryCreator(property.getClass());
            row += queryStrategy.createProp(property);
        }
        logger.info("──── INSERT ROW COUNT : {}", row);

        service.writeAll(properties, dto.getFileName());
        logger.info("──── Crawling Success");

        repository.insertLog(row);
        logger.info("──── Log save complete");
        logger.info("──── End Crawling");
    }

    public void multipleCrawling(CrawlerDto dto, List<String> urls) throws Exception {
        initializer(dto.getId(), dto.getPassword());

        for(String url : urls) {
            Elements elements = initializer.initPosts(dto.getStrategy().getDocument(url), dto.getMaxPage());
            logger.info("──── Elements obtain OK");

            properties = dto.getParseTemplate().parseAll(elements, cookies);
            logger.info("──── Parsing OK");

            int row = 0;
            for (ModelMapper property : properties) {
                queryStrategy = factory.getTypeRepositoryCreator(property.getClass());
                row += queryStrategy.createProp(property);
            }
            logger.info("──── INSERT ROW COUNT : {}", row);

            service.writeAll(properties, dto.getFileName());
            logger.info("──── Crawling OK");

            repository.insertLog(row);
            logger.info("──── Log save complete");
            logger.info("──── End Crawling");
        }
    }

    private void initializer(String id, String pw) throws Exception {
        loginService.doLogin(id, pw);
        logger.info("──── Is login ?" + loginService.isLogin());

        cookies = loginService.getLoginCookie();
    }
}
