package com.abasystem.crawler.factory;

import com.abasystem.crawler.mapper.ModelMapper;
import com.abasystem.crawler.model.property.IrregularProperty;
import com.abasystem.crawler.model.property.RegularProperty;
import com.abasystem.crawler.strategy.CsvWriteStrategy;
import com.abasystem.crawler.strategy.ReadStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory<P extends ModelMapper> {
    private static final Logger logger = LoggerFactory.getLogger(ServiceFactory.class);

    @Autowired
    private ReadStrategy<RegularProperty> regularParser;

    @Autowired
    private ReadStrategy<IrregularProperty> irregularParser;

    @Autowired
    private CsvWriteStrategy<RegularProperty> regularWriter;

    @Autowired
    private CsvWriteStrategy<IrregularProperty> irregularWriter;

    public ReadStrategy<P> parserCreator(boolean isRegular) {
        if (isRegular) {
            return (ReadStrategy<P>) regularParser;
        } else {
            return (ReadStrategy<P>) irregularParser;
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
