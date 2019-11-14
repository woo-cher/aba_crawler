package com.abasystem.crawler.Factory;

import com.abasystem.crawler.Storage.Naver;
import com.abasystem.crawler.Strategy.ObtainCategoryObjectStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PeterPanCategoryMapFactory implements ObtainCategoryObjectStrategy {

    @Override
    public Map<String, String> getCategoryMap() {
        Map<String, String> map = new HashMap<>();

        map.put("아파트.전세.서울", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1104&search.boardtype=L");
        map.put("아파트.전세.경기", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1105&search.boardtype=L");
        map.put("아파트.전세.인천", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1108&search.boardtype=L");
        map.put("아파트.전세.지방", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1107&search.boardtype=L");

        map.put("아파트.월세.서울", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1106&search.boardtype=L");
        map.put("아파트.월세.경기", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1113&search.boardtype=L");
        map.put("아파트.월세.인천", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1114&search.boardtype=L");
        map.put("아파트.월세.지방", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1115&search.boardtype=L");

        map.put("아파트.매매.서울", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1109&search.boardtype=L");
        map.put("아파트.매매.경기", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1110&search.boardtype=L");
        map.put("아파트.매매.인천", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1111&search.boardtype=L");
        map.put("아파트.매매.지방", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1112&search.boardtype=L");

        map.put("오피스텔.전월세.서울", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=289&search.boardtype=L");
        map.put("오피스텔.전월세.수도권", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=290&search.boardtype=L");
        map.put("오피스텔.전월세.지방권", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=705&search.boardtype=L");
        map.put("오피스텔.매매.전국", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=850&search.boardtype=L");

        map.put("[원룸]강남구.서초구", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=2&search.boardtype=L");
        map.put("[원룸]강동구.송파구", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=48&search.boardtype=L");
        map.put("[원룸]관악구.동작구", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=3&search.boardtype=L");
        map.put("[원룸]영등포.구로.금천", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=49&search.boardtype=L");
        map.put("[원룸]강서구.양천구", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=50&search.boardtype=L");
        map.put("[원룸]서대문.은평구", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=4&search.boardtype=L");
        map.put("[원룸]마포구.용산구", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=5&search.boardtype=L");
        map.put("[원룸]중구.종로.성북", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=6&search.boardtype=L");
        map.put("[원룸]광진구.중랑구", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=51&search.boardtype=L");
        map.put("[원룸]강북.노원.도봉", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=7&search.boardtype=L");
        map.put("[원룸]동대문.성동구", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=69&search.boardtype=L");

        map.put("[투룸]강남.서초.강동.송파", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=71&search.boardtype=L");
        map.put("[투룸]성북.성동.광진.용산", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=76&search.boardtype=L");
        map.put("[투룸]중랑.강북.노원.도봉", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=77&search.boardtype=L");
        map.put("[투룸]금천.구로.강서.양천", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=73&search.boardtype=L");
        map.put("[투룸]종구.종로.동대문", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=75&search.boardtype=L");
        map.put("[투룸]동작.관악.영등포", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=72&search.boardtype=L");
        map.put("[투룸]마포.은평.서대문", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=74&search.boardtype=L");

        map.put("[전세]강남.서초.강동.송파", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=100&search.boardtype=L");
        map.put("[전세]금천.구로.강서.양천", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=102&search.boardtype=L");
        map.put("[전세]마포.은평.서대문구", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=103&search.boardtype=L");
        map.put("[전세]종구.종로.동대문구", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=104&search.boardtype=L");
        map.put("[전세]성북.성동.광진.용산", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=105&search.boardtype=L");
        map.put("[전세]중랑.강북.노원.도봉", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=106&search.boardtype=L");
        map.put("[전세]동작.관악.영등포구", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=101&search.boardtype=L");

        map.put("[직거래]인천광역시", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=508&search.boardtype=L");
        map.put("[직거래]부천.김포.광명", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=8&search.boardtype=L");
        map.put("[직거래]안산.시흥.정왕", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=159&search.boardtype=L");
        map.put("[직거래]안양.군포.의왕", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=46&search.boardtype=L");
        map.put("[직거래]수원.오산.화성", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=45&search.boardtype=L");
        map.put("[직거래]안성.평택.용인", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=160&search.boardtype=L");
        map.put("[직거래]성남.이천.하남", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=44&search.boardtype=L");
        map.put("[직거래]고양.일산.파주", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=43&search.boardtype=L");
        map.put("[직거래]의정부.남양주.구리", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=41&search.boardtype=L");
        map.put("[직거래]기타 경기권", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=52&search.boardtype=L");

        map.put("[직거래]부산광역시", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=510&search.boardtype=L");
        map.put("[직거래]대구광역시", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=510&search.boardtype=L");
        map.put("[직거래]울산광역시", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=511&search.boardtype=L");
        map.put("[직거래]대전광역시", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=512&search.boardtype=L");
        map.put("[직거래]광주광역시", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=513&search.boardtype=L");
        map.put("[직거래]경상도지역", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=55&search.boardtype=L");
        map.put("[직거래]전라도지역", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=56&search.boardtype=L");
        map.put("[직거래]충청도지역", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=57&search.boardtype=L");
        map.put("[직거래]강원도지역", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=9&search.boardtype=L");
        map.put("[직거래]제주도지역", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1229&search.boardtype=L");

        map.put("[원룸텔.고시원.단기]강남.서초.강동.송파", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=686&search.boardtype=L");
        map.put("[원룸텔.고시원.단기]동작.관악.영등포", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=675&search.boardtype=L");
        map.put("[원룸텔.고시원.단기]금천.구로.강서.양천", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=673&search.boardtype=L");
        map.put("[원룸텔.고시원.단기]마포.은평.서대문", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=182&search.boardtype=L");
        map.put("[원룸텔.고시원.단기]중구.종로.동대문", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=719&search.boardtype=L");
        map.put("[원룸텔.고시원.단기]성북.성동.광진.용산", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=718&search.boardtype=L");
        map.put("[원룸텔.고시원.단기]중랑.강북.노원.도봉", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=676&search.boardtype=L");
        map.put("[원룸텔.고시원.단기]인천.경기권.수도권", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=362&search.boardtype=L");
        map.put("[원룸텔.고시원.단기]레지던스.민박.하숙", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=455&search.boardtype=L");
        map.put("[원룸텔.고시원.단기]게스트하우스", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=898&search.boardtype=L");

        map.put("[매매]펜션.모텔", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=1232&search.boardtype=L");

        map.put("[상가]카페.호프.BAR", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=818&search.boardtype=L");
        map.put("[상가]음식점.식당.분식", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=820&search.boardtype=L");
        map.put("[상가]의류.미용실.네일", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=821&search.boardtype=L");
        map.put("[상가]PC방.당구장.노래방", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=819&search.boardtype=L");
        map.put("[상가]편의점.마트.부동산", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=823&search.boardtype=L");
        map.put("[상가]학원.헬스장.요가", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=822&search.boardtype=L");
        map.put("[상가]다용도.핸드폰.점포", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=824&search.boardtype=L");
        map.put("[상가]기타 상가 매물", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=825&search.boardtype=L");

        map.put("[상가]강남.서초.강동.송파", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=828&search.boardtype=L");
        map.put("[상가]동작.관악.영등포", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=829&search.boardtype=L");
        map.put("[상가]금천.구로.강서.양천", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=830&search.boardtype=L");
        map.put("[상가]마포.은평.서대문", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=831&search.boardtype=L");
        map.put("[상가]중구.종로.동대문", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=832&search.boardtype=L");
        map.put("[상가]성북.성동.광진.용산", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=833&search.boardtype=L");
        map.put("[상가]중랑.강북.노원.도봉", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=834&search.boardtype=L");
        map.put("[상가]인천.경기지역 상가", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=835&search.boardtype=L");
        map.put("[상가]충청.강원지역 상가", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=836&search.boardtype=L");
        map.put("[상가]전라.경상지역 상가", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=837&search.boardtype=L");

        map.put("[사무실]강남.서초.강동.송파", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=840&search.boardtype=L");
        map.put("[사무실]동작.관악.영등포", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=841&search.boardtype=L");
        map.put("[사무실]금천.구로.강서.양천", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=842&search.boardtype=L");
        map.put("[사무실]마포.은평.서대문", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=843&search.boardtype=L");
        map.put("[사무실]중구.종로.동대문", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=844&search.boardtype=L");
        map.put("[사무실]성북.성동.광진.용산", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=845&search.boardtype=L");
        map.put("[사무실]중랑.강북.노원.도봉", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=846&search.boardtype=L");
        map.put("[사무실]인천.경기 사무실", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=847&search.boardtype=L");
        map.put("[사무실]충청.강원 사무실", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=848&search.boardtype=L");
        map.put("[사무실]전라.경상 사무실", Naver.CAFE_PREFIX + "/ArticleList.nhn?search.clubid=10322296&search.menuid=849&search.boardtype=L");

        return map;
    }
}