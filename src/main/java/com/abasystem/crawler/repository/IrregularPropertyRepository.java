package com.abasystem.crawler.repository;

import com.abasystem.crawler.mapper.ModelMapper;
import com.abasystem.crawler.model.Property.IrregularProperty;
import com.abasystem.crawler.strategy.BasicQueryStrategy;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class IrregularPropertyRepository implements BasicQueryStrategy<IrregularProperty> {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<IrregularProperty> findAll() {
        return sqlSession.selectList("selectProps");
    }

    @Override
    public IrregularProperty selectOneById(int propertyId) {
        return sqlSession.selectOne("selectIrregularPropById", propertyId);
    }

    @Override
    public int createProp(IrregularProperty property) {
        return sqlSession.insert("insertIrregularProp", property);
    }

    @Override
    public int updateProp(IrregularProperty property) {
        return sqlSession.update("updateIrregularProp", property);
    }

    @Override
    public int deleteProp(int propertyId) {
        return sqlSession.delete("deleteIrregularProp", propertyId);
    }

    public int getLastIndexId() {
        return sqlSession.selectOne("selectLastId");
    }

    public int createPropByList(List<? extends ModelMapper> properties) {
        return sqlSession.insert("insertIrregularProps", properties);
    }
}
