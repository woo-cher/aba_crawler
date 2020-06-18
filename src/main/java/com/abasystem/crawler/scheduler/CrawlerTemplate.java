package com.abasystem.crawler.scheduler;

import com.abasystem.crawler.api.repository.IrregularPropertyRepository;
import com.abasystem.crawler.api.repository.SchedulerRepository;
import com.abasystem.crawler.api.service.converter.DataConverter;
import com.abasystem.crawler.api.service.CrawlerService;
import com.abasystem.crawler.api.service.Initializer.PostInitializer;
import com.abasystem.crawler.api.service.NaverLoginService;
import com.abasystem.crawler.factory.CafeCategoryMapFactory;
import com.abasystem.crawler.factory.PostInitializerFactory;
import com.abasystem.crawler.factory.RepositoryFactory;
import com.abasystem.crawler.mapper.ModelMapper;
import com.abasystem.crawler.model.dto.Account;
import com.abasystem.crawler.model.dto.CrawlerDto;
import com.abasystem.crawler.model.type.NaverCafeType;
import com.abasystem.crawler.storage.Naver;
import com.abasystem.crawler.strategy.BasicQueryStrategy;
import com.abasystem.crawler.strategy.ObtainDocumentStrategy;
import com.abasystem.crawler.strategy.ObtainHtmlResourceStrategy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
public class CrawlerTemplate {
    private static final Logger logger = LoggerFactory.getLogger(CrawlerTemplate.class);

    @Autowired
    protected CrawlerService service;

    @Autowired
    protected NaverLoginService loginService;

    @Autowired
    protected RepositoryFactory repositoryFactory;

    @Autowired
    protected SchedulerRepository repository;

    @Autowired
    protected PostInitializerFactory postInitializerFactory;

    @Autowired
    protected CafeCategoryMapFactory categoryMapFactory;

    @Autowired
    protected IrregularPropertyRepository irregularPropertyRepository;

    protected Map<String, String> cookies;
    protected List<? extends ModelMapper> properties;
    protected BasicQueryStrategy queryStrategy;
    protected PostInitializer postInitializer;

    protected void singleCrawling(CrawlerDto dto, Class clazz, NaverCafeType type) throws Exception {
        initializer(dto.getAccount(), clazz);

        ObtainDocumentStrategy documentStrategy = dto.getDocumentStrategy();
        ObtainHtmlResourceStrategy resourceStrategy = dto.getResourceStrategy();
        String urlAfterSearch = resourceStrategy.getUrlAfterSearch();

        Document document = Jsoup.connect(urlAfterSearch).cookies(cookies).get();
        Elements elements = postInitializer.initPosts(document, dto.getPageCount());

//        int maxPage = getMaxPage(document, clazz);
//        logger.info("──── Max Page : {}", maxPage);
//        Elements elements = postInitializer.initPosts(document, maxPage);
//        logger.info("──── Elements obtain Success");

        properties = dto.getParseTemplate().parseAll(elements, cookies, clazz, type);
        logger.info("──── Parsing Success");

        int row = 0;

        for (ModelMapper property : properties) {
            queryStrategy = repositoryFactory.getTypeRepositoryCreator(property.getClass());
            row += queryStrategy.createProp(property);
        }

        logger.info("──── INSERT ROW COUNT : {}", row);

        service.writeAll(properties, dto.getFileName(), dto.getDirectory());
        logger.info("──── Crawling Success");

        repository.insertLog(row);
        logger.info("──── Log save complete");
        logger.info("──── End Crawling");
    }

    protected void multipleCrawling(CrawlerDto dto, Map<String, Integer> map, Class clazz) throws Exception {
        initializer(dto.getAccount(), clazz);

        for (String urlKey : map.keySet()) {
            Document document = Jsoup.connect(urlKey).cookies(cookies).get();
            Elements elements = postInitializer.initPosts(document, map.get(urlKey));

//            int maxPage = getMaxPage(document, clazz);
//            logger.warn("maxPage : {}", maxPage);
//            Elements elements = postInitializer.initPosts(document, maxPage);

            String categoryTitle = document.select(Naver.CATEGORY_TITLE).text();
            dto.setFileName(DataConverter.convertNameToValidFileName(categoryTitle));

            properties = dto.getParseTemplate().parseAll(elements, cookies, clazz, NaverCafeType.UNKNOWN);

//            int row = irregularPropertyRepository.createPropByList(properties);
            int row = 0;
            logger.warn("─────────────────── End insert Query : {}", row);

            for (ModelMapper property : properties) {
                queryStrategy = repositoryFactory.getTypeRepositoryCreator(property.getClass());
                row += queryStrategy.createProp(property);
            }

            service.writeAll(properties, dto.getFileName(), dto.getDirectory());

            repository.insertLog(row);
            logger.warn("─────────────────── End writing");
        }
        logger.warn("─────────────────── End Loop");
    }

    private void initializer(Account account, Class clazz) throws Exception {
        loginService.doLogin(account.getUserId(), account.getPasswd());

        this.cookies = loginService.getLoginCookie();
        this.postInitializer = postInitializerFactory.getPostCreator(clazz);
    }

    private void clear() {
        loginService.close();
    }

    public int getMaxPage(Document document, Class clazz) throws IOException {
        Document nextDoc = document;

        int maxPage = 1;

        while(true) {
            String nextUrl = nextDoc.select(postInitializerFactory.getPagingNextSelector(clazz)).attr("href");

            if(nextUrl.isEmpty()) {
                break;
            }

            if(maxPage == 991) {
                break;
            }

            nextDoc = Jsoup.connect(Naver.CAFE_PREFIX.concat(nextUrl)).get();
            maxPage += 10;
        }

        return maxPage;
    }
}
