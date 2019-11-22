package com.abasystem.crawler.Scheduler;

import com.abasystem.crawler.Factory.CafeCategoryMapFactory;
import com.abasystem.crawler.Factory.RepositoryFactory;
import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Model.Dto.CrawlerDto;
import com.abasystem.crawler.Repository.SchedulerRepository;
import com.abasystem.crawler.Service.Converter.DataConverter;
import com.abasystem.crawler.Service.CrawlerService;
import com.abasystem.crawler.Service.NaverLoginService;
import com.abasystem.crawler.Service.PostInitializer;
import com.abasystem.crawler.Storage.Naver;
import com.abasystem.crawler.Strategy.BasicQueryStrategy;
import com.abasystem.crawler.Strategy.ObtainDocumentStrategy;
import com.abasystem.crawler.Strategy.ObtainHtmlResourceStrategy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    protected CafeCategoryMapFactory categoryMapFactory;

    protected Map<String, String> cookies;
    protected List<? extends ModelMapper> properties;
    protected BasicQueryStrategy queryStrategy;

    protected void singleCrawling(CrawlerDto dto) throws Exception {
        initializer(dto.getId(), dto.getPassword());

        ObtainDocumentStrategy documentStrategy = dto.getDocumentStrategy();
        ObtainHtmlResourceStrategy resourceStrategy = dto.getResourceStrategy();
        String urlAfterSearch = resourceStrategy.getUrlAfterSearch();

        Elements elements = initializer.initPosts(documentStrategy.getDocument(urlAfterSearch), dto.getPageCount());
        logger.info("──── Elements obtain Success");

        properties = dto.getParseTemplate().parseAll(elements, cookies);
        logger.info("──── Parsing Success");

        int row = 0;

        for (ModelMapper property : properties) {
            queryStrategy = factory.getTypeRepositoryCreator(property.getClass());
            row += queryStrategy.createProp(property);
        }

        logger.info("──── INSERT ROW COUNT : {}", row);

        service.writeAll(properties, dto.getFileName(), dto.getDirectory());
        logger.info("──── Crawling Success");

        repository.insertLog(row);
        logger.info("──── Log save complete");
        logger.info("──── End Crawling");
    }

    protected void multipleCrawling(CrawlerDto dto, Map<String, Integer> map) throws Exception {
        initializer(dto.getId(), dto.getPassword());

        for (String urlKey : map.keySet()) {
            Document document = Jsoup.connect(urlKey).cookies(cookies).get();
            Elements elements = initializer.initPosts(document, map.get(urlKey));

            String categoryTitle = document.select(Naver.CATEGORY_TITLE).text();
            dto.setFileName(DataConverter.convertNameToValidFileName(categoryTitle));

            properties = dto.getParseTemplate().parseAll(elements, cookies);

            int row = 0;

            for (ModelMapper property : properties) {
                queryStrategy = factory.getTypeRepositoryCreator(property.getClass());
                row += queryStrategy.createProp(property);
            }

            service.writeAll(properties, dto.getFileName(), dto.getDirectory());

            repository.insertLog(row);
        }
    }

    private void initializer(String id, String pw) throws Exception {
        loginService.doLogin(id, pw);
        logger.info("──── Is login ?" + loginService.isLogin());

        cookies = loginService.getLoginCookie();
    }
}
