package com.abasystem.crawler.Factory;

import com.abasystem.crawler.Mapper.ModelMapper;
import com.abasystem.crawler.Model.Property.IrregularProperty;
import com.abasystem.crawler.Model.Property.RegularProperty;
import com.abasystem.crawler.Strategy.BasicQueryStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryFactory {
    private static final Logger logger = LoggerFactory.getLogger(RepositoryFactory.class);

    @Autowired
    private BasicQueryStrategy<RegularProperty> regularRepository;

    @Autowired
    private BasicQueryStrategy<IrregularProperty> irregularRepository;

    public <P extends ModelMapper> BasicQueryStrategy<P> getTypeRepositoryCreator(Class clazz) {
        if(clazz.equals(RegularProperty.class)) {
            return (BasicQueryStrategy<P>) regularRepository;
        }
        else {
            return (BasicQueryStrategy<P>) irregularRepository;
        }
    }
}
