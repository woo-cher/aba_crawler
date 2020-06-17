package com.abasystem.crawler.api.service.Operator;

import com.abasystem.crawler.mapper.ModelMapper;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("CategoryWithPostTypeOperator")
public class CategoryWithPostTypeOperator extends ParseTemplate {
    private static final Logger logger = LoggerFactory.getLogger(CategoryWithPostTypeOperator.class);

    @Override
    public ModelMapper getModelAfterParse(Elements elements, Document doc, String url, String title) {
        boolean flag = validationStrategy.isRegularPost(doc.select("#tbody"));
        logger.info("CategoryWithPostTypeOperator initialize");
        return serviceFactory.parserCreator(flag).parse(doc, url, title);
    }

    /**
     * '진주' 지역만 검색해서 뽑는 크롤러의 경우에만 사용
     * @param elements
     * @return
     */
    @Override
    public boolean isContainPropertyKeyword(Elements elements) {
        return true;
//        return validationStrategy.isPropertyPost(elements);
    }
}
