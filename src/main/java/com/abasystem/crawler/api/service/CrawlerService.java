package com.abasystem.crawler.api.service;

import com.abasystem.crawler.factory.ServiceFactory;
import com.abasystem.crawler.mapper.ModelMapper;
import com.abasystem.crawler.api.service.Converter.DataConverter;
import com.abasystem.crawler.api.service.Writer.CustomOpenCsvWriter;
import com.abasystem.crawler.strategy.CsvWriteStrategy;
import com.abasystem.crawler.strategy.ValidationStrategy;
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
public class CrawlerService<P extends ModelMapper> extends CustomOpenCsvWriter {
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

        if(properties.isEmpty()) {
            logger.warn("─────────────────── List is Empty. File make failure");
            return false;
        }

        this.cw = getCsvWriter(fileName, directory);
        logger.warn("─────────────────── File make success : " + fileName);
        cw.writeNext(TABLE_ROW);

        int index = 1;

        for (P property : properties) {
            CsvWriteStrategy csvWriteStrategy = factory.writerCreator(property.getClass());
            JsonObject object = DataConverter.convertModelToJsonObject(property);
            csvWriteStrategy.doWrite(object, cw, index);
            index++;
        }

        if (cw.checkError()) {
            return false;
        }

        return true;
    }
}
