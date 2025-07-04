package com.niit.service;

import com.niit.mapper.CourseMapper;
import com.niit.pojo.Course;
import com.niit.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CourseService {

    private static SqlSession sqlSession = null;
    static {
        try {
            sqlSession = MybatisUtil.getSqlSession();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Course> selectCourses(){
        return this.getMapper().selectCourses();
    }

    private CourseMapper getMapper(){
        return sqlSession.getMapper(CourseMapper.class);
    }
    private void commit(){
        sqlSession.commit();
    }
    private void rollback(){
        sqlSession.rollback();
    }
}
