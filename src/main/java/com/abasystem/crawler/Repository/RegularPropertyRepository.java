package com.abasystem.crawler.Repository;

import com.abasystem.crawler.Model.PeterPan.RegularProperty;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RegularPropertyRepository {

    @Autowired
    private SqlSession sqlSession;

    public List<RegularProperty> findAll() {
        return sqlSession.selectList("selectProps");
    }

    public RegularProperty selectOneById(int propertyId) {
        return sqlSession.selectOne("selectPropById", propertyId);
    }

    public int createProp(RegularProperty property) {
        return sqlSession.insert("insertProp", property);
    }

    public int updateProp(RegularProperty property) {
        return sqlSession.update("updateProp", property);
    }

    public int deleteProp(int propertyId) {
        return sqlSession.delete("deleteProp", propertyId);
    }

    public int getLastIndexId() {
        return sqlSession.selectOne("selectLastId");
    }
}
