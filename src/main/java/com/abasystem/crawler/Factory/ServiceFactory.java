package com.abasystem.crawler.Factory;

import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Model.PeterPan.IrregularProperty;
import com.abasystem.crawler.Model.PeterPan.RegularProperty;
import com.abasystem.crawler.Strategy.ParseStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory {
    private static final Logger logger = LoggerFactory.getLogger(ServiceFactory.class);

    @Autowired
    private ParseStrategy<RegularProperty> regularParser;

    @Autowired
    private ParseStrategy<IrregularProperty> irregularParser;

    public <P extends ModelMapper> ParseStrategy<P> getTypeServiceCreator(boolean isRegular) {
        if (isRegular) {
            return (ParseStrategy<P>) regularParser;
        }
        else {
            return (ParseStrategy<P>) irregularParser;
        }
    }
}
