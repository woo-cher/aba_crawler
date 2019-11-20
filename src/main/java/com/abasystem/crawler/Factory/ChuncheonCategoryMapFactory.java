package com.abasystem.crawler.Factory;

import com.abasystem.crawler.Mapper.CategoryMapper;
import com.abasystem.crawler.Service.Converter.DataConverter;
import com.abasystem.crawler.Strategy.ObtainCategoryObjectStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Ref. https://cafe.naver.com/25land
 *  - a 태그의 href Attribute 를 직접 파싱하기에 시간 복잡도가 너무 커질 것
 */
@Component
public class ChuncheonCategoryMapFactory extends CategoryMapper implements ObtainCategoryObjectStrategy {

    @Override
    public Map<String, Integer> getCategoryMap() {

        /**
         *  --------------------------------------------------
         *  \\              개인매물-춘천직거래                \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=18824768&search.menuid=798&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=18824768&search.menuid=800&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=18824768&search.menuid=803&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=18824768&search.menuid=799&search.boardtype=L"), DEFAULT_MAX_PAGE);

        return map;
    }
}
