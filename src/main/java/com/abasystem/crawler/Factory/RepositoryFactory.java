package com.abasystem.crawler.Factory;

import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Model.PeterPan.IrregularProperty;
import com.abasystem.crawler.Model.PeterPan.RegularProperty;
import com.abasystem.crawler.Strategy.BasicQueryStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryFactory <P extends ModelMapper> {
    private static final Logger logger = LoggerFactory.getLogger(RepositoryFactory.class);

    @Autowired
    private BasicQueryStrategy<RegularProperty> regularRepository;

    @Autowired
    private BasicQueryStrategy<IrregularProperty> irregularRepository;

    public BasicQueryStrategy<P> getTypeRepositoryCreator(Class clazz) {
        if(clazz.equals(RegularProperty.class)) {
            return (BasicQueryStrategy<P>) regularRepository;
        }
        else {
            return (BasicQueryStrategy<P>) irregularRepository;
        }
    }
}
