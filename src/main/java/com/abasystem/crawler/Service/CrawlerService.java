package com.abasystem.crawler.Service;

import com.abasystem.crawler.Factory.ServiceFactory;
import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Service.Converter.ModelConverter;
import com.abasystem.crawler.Service.Writer.CustomOpenCsv;
import com.abasystem.crawler.Strategy.CsvWriteStrategy;
import com.abasystem.crawler.Strategy.ValidationStrategy;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Init 메소드는 Util 성에 성격이 가까워보인다.
 */
@Service
public class CrawlerService<P extends ModelMapper> extends CustomOpenCsv {
    private static final Logger logger = LoggerFactory.getLogger(CrawlerService.class);

    private static final String[] TABLE_ROW = {
            "번호", "제목", "링크", "설명", "연락처", "등록일", "주소", "타입", "가격", "관리비", "옵션", "이사가능일",
            "방개수", "해당층/전체층", "관리비항목", "난방방식"
    };

    @Autowired
    public ValidationStrategy validationStrategy;

    @Autowired
    private ServiceFactory factory;

    public CrawlerService() {
        super();
    }

    public boolean writeAll(List<P> properties, String fileName, String directory) throws Exception {
        this.cw = getCSVWriter(fileName, directory);
        logger.warn("─────────────────── 세이브 완료!! : " + fileName);
        cw.writeNext(TABLE_ROW);

        int index = 1;

        for (P property : properties) {
            CsvWriteStrategy csvWriteStrategy = factory.writerCreator(property.getClass());
            JsonObject object = ModelConverter.convertModelToJsonObject(property);
            csvWriteStrategy.doWrite(object, cw, index);
            index++;
        }

        if (cw.checkError() == true) {
            return false;
        }

        return true;
    }
}