package com.abasystem.crawler.unit;

import com.abasystem.crawler.api.service.converter.DataConverter;
import com.abasystem.crawler.api.service.reader.IrregularReader;
import com.abasystem.crawler.api.service.writer.CustomOpenCsvWriter;
import com.abasystem.crawler.model.office.Office;
import com.abasystem.crawler.storage.Naver;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.WriteAbortedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodTest {
    private static final Logger log = LoggerFactory.getLogger(MethodTest.class);

    @Test
    public void getMaxPage() throws IOException {
        Document nextDoc = Jsoup.connect(Naver.CAFE_PREFIX.concat("/ArticleList.nhn?search.clubid=10322296&search.menuid=1238&search.boardtype=L")).get();

        int maxPage = 1;

        while (true) {
            String nextUrl = nextDoc.select(Naver.DIV_POST_NEXT).attr("href");
            log.info("nextUrl : {}", nextUrl);

            if (nextUrl.isEmpty()) {
                break;
            }

            nextDoc = Jsoup.connect(Naver.CAFE_PREFIX.concat(nextUrl)).get();
            maxPage += 10;
        }

        log.info("maxPage : {}", maxPage);
    }

    @Test
    public void getPhoneNumber() throws IOException {
        Document document = Jsoup.connect("https://cafe.naver.com/kig/ArticleRead.nhn?clubid=10322296&page=373&menuid=455&boardtype=L&articleid=7893385&referrerAllArticles=false")
                .get();

        log.error("test : {}", document);
        IrregularReader reader = new IrregularReader();
        log.error("폰 : {}", reader.getPhoneNumber(document.select("#main-area")));
    }

    @Test
    public void ordinaryPageCrawling() throws Exception {
        final String[] TABLE_ROW = {"번호", "지번주소", "부가주소", "부동산이름", "대표자", "연락처1", "연락처2"};

        String endPoint = "http://www.karhanbang.com";
        String url = "http://www.karhanbang.com/office/?topM=09";

        final String OFFICE_SELECTOR = ".simpleList > tbody > tr";
        final String PAGE_SELECTOR = ".pagination > a";

        CustomOpenCsvWriter writer = new CustomOpenCsvWriter();

        writer.cw = writer.getCsvWriter("서울특별시", "office");
        writer.cw.writeNext(TABLE_ROW);

        Document document = Jsoup.connect(url).get();

        Elements offices = document.select(OFFICE_SELECTOR);
        Elements pages = document.select(PAGE_SELECTOR);

        // Init Offices
        while (true) {
            int index = 0;
            for (Element el : pages) {
                String nextPageUrl = endPoint + el.attr("href");

                offices.addAll(
                        Jsoup.connect(nextPageUrl).get().select(OFFICE_SELECTOR)
                );

                index++;

                if (index == pages.size()) {
                    url = endPoint + el.attr("href");
                }
            }

            if (pages.select(".gradient:contains(다음)").attr("href").isEmpty()) {
                log.info("break !!");
                break;
            }

            document = Jsoup.connect(url).get();
            pages = document.select(PAGE_SELECTOR).not(":contains(이전)");
        }

        Pattern pattern = Pattern.compile("[0-9]+");

        int i = 0;

        // Parse
        for (Element el : offices) {
            String href = el.select(".coln02 > a").attr("href");
            Matcher matcher = pattern.matcher(href);

            if (matcher.find()) {
                String detailUrl = endPoint + "/office/office_detail.asp?mem_no=" + matcher.group();
                log.info(detailUrl);

                Elements infoBox = Jsoup.connect(detailUrl).get().select(".realtorsInfoBig");
                Elements details = infoBox.select(".realtorsInfoBigBox > ul > li");

                /**
                 * key by index
                 *
                 * [0] -> 대표자 이름, [1] -> 소재지, [2] -> 부가주소, [3] -> 지번주소, [4] -> 연락처
                 *
                 * @see telAndPhone must be split because is typied like "052-123-123 / 010-1234-1234"
                 * Additionally, `.` means that is whitespace.
                 */
                List<String> phoneList = new ArrayList<>();

                phoneList.addAll(
                        Arrays.asList(details.get(4).select("em").text().split("./."))
                );

                if (phoneList.size() == 1) {
                    phoneList.add("없음");
                }

                Office office = Office.builder()
                        .name(infoBox.select("dl > dt").text())
                        .representative(details.get(0).select("em").text().trim())
                        .extraAddress(details.get(2).select("em").text().trim())
                        .jibunAddress(details.get(3).select("em").text().trim())
                        .tel(phoneList.get(0))
                        .mTel(phoneList.get(1))
                        .build();

                log.info("Office : {}", office);

                JsonObject object = DataConverter.convertModelToJsonObject(office);

                writer.cw.writeNext(new String[]{
                        String.valueOf(++i),
                        object.get("jibunAddress").getAsString(),
                        object.get("extraAddress").getAsString(),
                        object.get("name").getAsString(),
                        object.get("representative").getAsString(),
                        object.get("tel").getAsString(),
                        object.get("mTel").getAsString()
                });
            }
        }

        if (writer.cw.checkError()) {
            throw new WriteAbortedException("파일 쓰기에 실패했습니다", new IOException());
        }
    }
}
