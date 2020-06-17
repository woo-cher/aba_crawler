package com.abasystem.crawler.repository;

import com.abasystem.crawler.model.Property.RegularProperty;
import com.abasystem.crawler.strategy.BasicQueryStrategy;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RegularPropertyRepository implements BasicQueryStrategy<RegularProperty> {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<RegularProperty> findAll() {
        return sqlSession.selectList("selectRegularProps");
    }

    @Override
    public RegularProperty selectOneById(int propertyId) {
        return sqlSession.selectOne("selectRegularPropById", propertyId);
    }

    @Override
    public int createProp(RegularProperty property) {
        return sqlSession.insert("insertRegularProp", property);
    }

    @Override
    public int updateProp(RegularProperty property) {
        return sqlSession.update("updateRegularProp", property);
    }

    @Override
    public int deleteProp(int propertyId) {
        return sqlSession.delete("deleteRegularProp", propertyId);
    }

    public int getLastIndexId() {
        return sqlSession.selectOne("selectLastId");
    }
}
