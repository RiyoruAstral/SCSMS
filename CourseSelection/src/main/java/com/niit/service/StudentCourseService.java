package com.niit.service;

import com.niit.mapper.StudentCourseMapper;
import com.niit.pojo.StudentCourse;
import com.niit.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentCourseService {
    private static SqlSession sqlSession = null;
    static {
        try {
            sqlSession = MybatisUtil.getSqlSession();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<StudentCourse> findStudentCourseBySno(int sno){return this.getMapper().findStudentCourseBySno(sno);};


    private StudentCourseMapper getMapper(){
        return sqlSession.getMapper(StudentCourseMapper.class);
    }

    private void commit(){
        sqlSession.commit();
    }
    private void rollback(){
        sqlSession.rollback();
    }
}
