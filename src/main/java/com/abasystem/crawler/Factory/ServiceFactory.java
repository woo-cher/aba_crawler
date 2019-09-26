package com.abasystem.crawler.Factory;

import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Model.PeterPan.IrregularProperty;
import com.abasystem.crawler.Model.PeterPan.RegularProperty;
import com.abasystem.crawler.Service.parser.IrregularParser;
import com.abasystem.crawler.Service.parser.RegularParser;
import com.abasystem.crawler.Strategy.ParseStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceFactory {
    private static final Logger logger = LoggerFactory.getLogger(ServiceFactory.class);

    private ParseStrategy<RegularProperty> regularParser;
    private ParseStrategy<IrregularProperty> irregularParser;

    public <P extends ModelMapper> ParseStrategy<P> getTypeServiceCreator(boolean isRegular) {
        if (isRegular) {
            regularParser = new RegularParser();
            return (ParseStrategy<P>) regularParser;
        }
        else {
            irregularParser = new IrregularParser();
            return (ParseStrategy<P>) irregularParser;
        }
    }
}
