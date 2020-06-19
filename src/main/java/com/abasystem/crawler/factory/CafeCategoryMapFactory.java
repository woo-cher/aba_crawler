package com.abasystem.crawler.factory;

import com.abasystem.crawler.mapper.CategoryMapper;
import com.abasystem.crawler.api.service.converter.DataConverter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CafeCategoryMapFactory extends CategoryMapper {

    /**
     *  Ref. https://cafe.naver.com/25land
     */
    public Map<String, Integer> getChuncheonCategoryMap() {
        clear(map);
        String prefix = "/ArticleList.nhn?search.clubid=18824768&";

        /**
         *  --------------------------------------------------
         *  \\              개인매물-춘천직거래                \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=798&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=800&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=803&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=799&search.boardtype=L"), DEFAULT_MAX_PAGE);

        return map;
    }

    /**
     *  Ref. https://cafe.naver.com/ttcu
     */
    public Map<String, Integer> getGoodShopCategoryMap() {
        clear(map);
        String prefix = "/ArticleList.nhn?search.clubid=22081311&";

        /**
         *  --------------------------------------------------
         *  \\               업종별 부동산매물                 \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=391&search.boardtype=L"), 4);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=392&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=393&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=394&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=395&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=396&search.boardtype=L"), 3);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=398&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=397&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=450&search.boardtype=L"), DEFAULT_MAX_PAGE);

        return map;
    }

    /**
     *  Ref. https://cafe.naver.com/kig
     */
    public Map<String, Integer> getPeterPanCategoryMap() {
        clear(map);
        String prefix = "/ArticleList.nhn?search.clubid=10322296&";

        /**
         *  --------------------------------------------------
         *  \\                 [직거래]아파트                 \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1104&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1105&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1108&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1107&search.boardtype=L"), DEFAULT_MAX_PAGE);

        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1106&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1113&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1114&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1115&search.boardtype=L"), DEFAULT_MAX_PAGE);

        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1109&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1110&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1111&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1112&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\                 [직거래]오피스텔                \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=289&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=290&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=705&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=850&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\                 [직거래]서울 원룸               \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=2&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=48&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=3&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=49&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=50&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=4&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=5&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=6&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=51&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=7&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=69&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\                 [직거래]서울투룸이상             \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=71&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=76&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=77&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=73&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=75&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=72&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=74&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\                 [직거래]서울 전세               \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=100&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=102&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=103&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=104&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=105&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=106&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=101&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\                 [직거래]수도권                  \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=508&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=8&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=159&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=46&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=45&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=160&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=44&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=43&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=41&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=52&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\                 [직거래]지방권                  \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=509&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=510&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=511&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=512&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=513&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=55&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=56&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=57&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=9&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1229&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\              [원룸텔.고시원.단기]                \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=686&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=675&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=673&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=182&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=719&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=718&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=676&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=362&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=455&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=898&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\               [직거래]상가용 매매                \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1232&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\               [직거래]상가-업종별               \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=818&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=820&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=821&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=819&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=823&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=822&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=824&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=825&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\               [직거래]상가-지역별               \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=828&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=829&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=830&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=831&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=832&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=833&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=834&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=835&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=836&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=837&search.boardtype=L"), DEFAULT_MAX_PAGE);

        /**
         *  --------------------------------------------------
         *  \\                  [직거래]사무실                 \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=840&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=841&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=842&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=843&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=844&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=845&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=846&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=847&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=848&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=849&search.boardtype=L"), DEFAULT_MAX_PAGE);

        return map;
    }

    /**
     *  Ref. https://cafe.naver.com/svzero
     */
    public Map<String, Integer> getBoodongDirectCategoryMap() {
        clear(map);
        String prefix = "/ArticleList.nhn?search.clubid=13173024&";

        /**
         *  --------------------------------------------------
         *  \\               ★ 부동산 직거래                  \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=657&search.boardtype=L"), 2);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=624&search.boardtype=L"), 4);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=623&search.boardtype=L"), 4);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=656&search.boardtype=L"), 10);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=655&search.boardtype=L"), 7);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=658&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=628&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=626&search.boardtype=L"), 5);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=627&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=621&search.boardtype=L"), 5);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=649&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=629&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=664&search.boardtype=L"), DEFAULT_MAX_PAGE);

        return map;
    }

    /**
     *  Ref. https://cafe.naver.com/kig070
     */
    public Map<String, Integer> getChangWonCategoryMap() {
        map.clear();
        String prefix = "/ArticleList.nhn?search.clubid=20662382&";

        /**
         *  --------------------------------------------------
         *  \\             ★ 회원 직거래 게시판               \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=17&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=18&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=19&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=143&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=144&search.boardtype=L"), DEFAULT_MAX_PAGE);

        return map;
    }

    /**
     *  Ref. https://cafe.naver.com/ydbusan
     */
    public Map<String, Integer> getBusanRoomCategoryMap() {
        map.clear();
        String prefix = "/ArticleList.nhn?search.clubid=20024874&";

        /**
         *  --------------------------------------------------
         *  \\            ★ 부산 직거래 [전월세]               \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=35&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=33&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=38&search.boardtype=L"), 2);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=39&search.boardtype=L"), 2);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=45&search.boardtype=L"), 2);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=55&search.boardtype=L"), DEFAULT_MAX_PAGE);

        return map;
    }

    /**
     *  Ref. https://cafe.naver.com/kig042
     */
    public Map<String, Integer> getCheonanDirectCategoryMap() {
        map.clear();
        String prefix = "/ArticleList.nhn?search.clubid=18355813&";

        /**
         *  --------------------------------------------------
         *  \\                 천안시 직거래                  \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=19&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=17&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=18&search.boardtype=L"), DEFAULT_MAX_PAGE);

        return map;
    }

    /**
     *  Ref. https://cafe.naver.com/chobomamy
     */
    public Map<String, Integer> getYangSanMomCategoryMap() {
        map.clear();
        String prefix = "/ArticleList.nhn?search.clubid=20655292&";

        /**
         *  --------------------------------------------------
         *  \\               ◆ 부동산 직거래방                 \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1223&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1224&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1225&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1226&search.boardtype=L"), DEFAULT_MAX_PAGE);
//        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1227&search.boardtype=L"), DEFAULT_MAX_PAGE);
//        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1228&search.boardtype=L"), DEFAULT_MAX_PAGE);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=1229&search.boardtype=L"), DEFAULT_MAX_PAGE);

        return map;
    }

    /**
     *  Ref. https://cafe.naver.com/jinju0004
     */
    public Map<String, Integer> getHappyHouseCategoryMap() {
        map.clear();
        String prefix = "/ArticleList.nhn?search.clubid=19167452&";

        /**
         *  --------------------------------------------------
         *  \\                  ◆ 진주원룸                   \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=392&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=49&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=44&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=43&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=47&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=179&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=146&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=176&search.boardtype=L"), 100);

        /**
         *  --------------------------------------------------
         *  \\             ◆ 진주 투/쓰리룸                   \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=393&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=56&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=51&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=50&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=54&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=180&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=148&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=184&search.boardtype=L"), 100);

        /**
         *  --------------------------------------------------
         *  \\            ◆ 아파트 임대/매매                   \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=394&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=245&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=299&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=210&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=358&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=359&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=212&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=213&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=214&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=215&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=793&search.boardtype=L"), 100);

        /**
         *  --------------------------------------------------
         *  \\            ◆ 주택 전월세임대                   \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=395&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=57&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=181&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=794&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=185&search.boardtype=L"), 100);

        /**
         *  --------------------------------------------------
         *  \\            ◆ 건물/주택 매매                   \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=157&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=814&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=59&search.boardtype=L"), 100);

        /**
         *  --------------------------------------------------
         *  \\            ◆ 반점포/창고/상가                   \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=277&search.boardtype=L"), 100);
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=946&search.boardtype=L"), 100);

        /**
         *  --------------------------------------------------
         *  \\                   ◆ 땅/토지                   \\
         *  --------------------------------------------------
         */
        map.put(DataConverter.convertPostFixToNaverUrl(prefix + "search.menuid=153&search.boardtype=L"), 100);

        return map;
    }

    private void clear(Map map) {
        map.clear();
    }
}
