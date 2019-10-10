package com.abasystem.crawler.Repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SchedulerRepository {

    @Autowired
    private SqlSession sqlSession;

    public int insertLog(int row) {
        return sqlSession.insert("insertLog", row);
    }

    public int getNextId() {
        return sqlSession.selectOne("selectRowCount");
    }
}