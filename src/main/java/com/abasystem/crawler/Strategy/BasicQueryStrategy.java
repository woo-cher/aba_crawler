package com.abasystem.crawler.Strategy;

import com.abasystem.crawler.Mapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public interface BasicQueryStrategy<P extends ModelMapper> {
    List<P> findAll();
    P selectOneById(int propertyId);
    int createProp(P property);
    int updateProp(P property);
    int deleteProp(int propertyId);
}
