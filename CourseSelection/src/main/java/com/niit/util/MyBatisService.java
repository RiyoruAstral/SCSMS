package com.niit.util;
import org.apache.ibatis.session.SqlSession;

public class MyBatisService {
    private static MyBatisService instance;
    private static SqlSession sqlSession;

    static {
        try {
            sqlSession = MybatisUtil.getSqlSession();
        } catch (Exception e) {
            throw new RuntimeException("初始化SqlSession失败", e);
        }
    }

    private MyBatisService() {}

    public static synchronized MyBatisService getInstance() {
        if (instance == null) {
            instance = new MyBatisService();
        }
        return instance;
    }

    public <T> T getMapper(Class<T> mapperClass) {
        return sqlSession.getMapper(mapperClass);
    }

    public void commit() {
        sqlSession.commit();
    }

    public void rollback() {
        sqlSession.rollback();
    }

    public void close() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}