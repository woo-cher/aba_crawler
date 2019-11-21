package com.abasystem.crawler.Factory;

import com.abasystem.crawler.Mapper.CategoryMapper;
import com.abasystem.crawler.Service.Converter.DataConverter;
import com.abasystem.crawler.Strategy.ObtainCategoryObjectStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Ref. https://cafe.naver.com/ttcu
 */
@Component
public class GoodShopCategoryMapFactory extends CategoryMapper implements ObtainCategoryObjectStrategy {

    @Override
    public Map<String, Integer> getCategoryMap() {

        /**
         *  --------------------------------------------------
         *  \\               업종별 부동산매물                 \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=22081311&search.menuid=391&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=22081311&search.menuid=392&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=22081311&search.menuid=393&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=22081311&search.menuid=394&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=22081311&search.menuid=395&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=22081311&search.menuid=396&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=22081311&search.menuid=398&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=22081311&search.menuid=397&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=22081311&search.menuid=450&search.boardtype=L"), DEFAULT_MAX_PAGE);

        return map;
    }
}
