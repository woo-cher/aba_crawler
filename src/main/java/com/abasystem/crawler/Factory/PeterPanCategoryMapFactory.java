package com.abasystem.crawler.Factory;

import com.abasystem.crawler.Mapper.CategoryMapper;
import com.abasystem.crawler.Service.Converter.DataConverter;
import com.abasystem.crawler.Strategy.ObtainCategoryObjectStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Ref. https://cafe.naver.com/kig
 *  - a 태그의 href Attribute 를 직접 파싱하기에 시간 복잡도가 너무 커질 것
 */
@Component
public class PeterPanCategoryMapFactory extends CategoryMapper implements ObtainCategoryObjectStrategy {

    @Override
    public Map<String, Integer> getCategoryMap() {

        /**
         *  --------------------------------------------------
         *  \\                 [직거래]아파트                 \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=1104&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=1105&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=1108&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=1107&search.boardtype=L"), DEFAULT_MAX_PAGE);

        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=1106&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=1113&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=1114&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=1115&search.boardtype=L"), DEFAULT_MAX_PAGE);

        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=1109&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=1110&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=1111&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=1112&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\                 [직거래]오피스텔                \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=289&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=290&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=705&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=850&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\                 [직거래]서울 원룸               \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=2&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=48&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=3&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=49&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=50&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=4&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=5&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=6&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=51&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=7&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=69&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\                 [직거래]서울투룸이상             \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=71&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=76&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=77&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=73&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=75&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=72&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=74&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\                 [직거래]서울 전세               \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=100&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=102&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=103&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=104&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=105&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=106&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=101&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\                 [직거래]수도권                  \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=508&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=8&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=159&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=46&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=45&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=160&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=44&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=43&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=41&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=52&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\                 [직거래]지방권                  \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=509&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=510&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=511&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=512&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=513&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=55&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=56&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=57&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=9&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=1229&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\              [원룸텔.고시원.단기]                \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=686&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=675&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=673&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=182&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=719&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=718&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=676&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=362&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=455&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=898&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\               [직거래]상가용 매매                \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=1232&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\               [직거래]상가-업종별               \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=818&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=820&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=821&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=819&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=823&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=822&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=824&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=825&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\               [직거래]상가-지역별               \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=828&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=829&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=830&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=831&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=832&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=833&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=834&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=835&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=836&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=837&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\                  [직거래]사무실                 \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=840&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=841&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=842&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=843&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=844&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=845&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=846&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=847&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=848&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl("/ArticleList.nhn?search.clubid=10322296&search.menuid=849&search.boardtype=L"), DEFAULT_MAX_PAGE);

        return map;
    }
}