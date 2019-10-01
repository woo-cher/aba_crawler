package com.abasystem.crawler.Repository;

import com.abasystem.crawler.Model.PeterPan.IrregularProperty;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class IrregularPropertyRepository {

    @Autowired
    private SqlSession sqlSession;

    public List<IrregularProperty> findAll() {
        return sqlSession.selectList("selectProps");
    }

    public IrregularProperty selectOneById(int propertyId) {
        return sqlSession.selectOne("selectIrregularPropById", propertyId);
    }

    public int createProp(IrregularProperty property) {
        return sqlSession.insert("insertIrregularProp", property);
    }

    public int updateProp(IrregularProperty property) {
        return sqlSession.update("updateIrregularProp", property);
    }

    public int deleteProp(int propertyId) {
        return sqlSession.delete("deleteIrregularProp", propertyId);
    }

    public int getLastIndexId() {
        return sqlSession.selectOne("selectLastId");
    }
}
