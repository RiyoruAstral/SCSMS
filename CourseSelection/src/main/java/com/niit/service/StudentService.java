package com.niit.service;

import com.niit.mapper.StudentMapper;
import com.niit.pojo.Student;
import com.niit.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class StudentService {
    private static SqlSession sqlSession = null;
    static {
        try {
            sqlSession = MybatisUtil.getSqlSession();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Student findStudentBySnoAndDepartment(int sno,int dno){return getMapper().findStudentBySnoAndDepartment(sno,dno);}
    public Student findStudentByUserId(int userId){return this.getMapper().findStudentByUserId(userId);}


    public void updateStudentUserId(int sno, int userId){
        this.getMapper().updateStudentUserId(sno, userId);
    }

    private StudentMapper getMapper(){
        return sqlSession.getMapper(StudentMapper.class);
    }

    private void commit(){
        sqlSession.commit();
    }
    private void rollback(){
        sqlSession.rollback();
    }
}
