package com.abasystem.crawler.Repository;

import com.abasystem.crawler.Model.PeterPan.IrregularProperty;
import com.abasystem.crawler.Model.PeterPan.RegularProperty;
import com.abasystem.crawler.Strategy.BasicQueryStrategy;
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
}
