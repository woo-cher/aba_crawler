package com.abasystem.crawler.Factory;

import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Model.Property.IrregularProperty;
import com.abasystem.crawler.Model.Property.RegularProperty;
import com.abasystem.crawler.Strategy.CsvWriteStrategy;
import com.abasystem.crawler.Strategy.ParseStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory<P extends ModelMapper> {
    private static final Logger logger = LoggerFactory.getLogger(ServiceFactory.class);

    @Autowired
    private ParseStrategy<RegularProperty> regularParser;

    @Autowired
    private ParseStrategy<IrregularProperty> irregularParser;

    @Autowired
    private CsvWriteStrategy<RegularProperty> regularWriter;

    @Autowired
    private CsvWriteStrategy<IrregularProperty> irregularWriter;

    public ParseStrategy<P> parserCreator(boolean isRegular) {
        if (isRegular) {
            return (ParseStrategy<P>) regularParser;
        } else {
            return (ParseStrategy<P>) irregularParser;
        }
    }

    public CsvWriteStrategy<P> writerCreator(Class<P> clazz) {
        if (clazz.equals(RegularProperty.class)) {
            return (CsvWriteStrategy<P>) regularWriter;
        } else {
            return (CsvWriteStrategy<P>) irregularWriter;
        }
    }
}