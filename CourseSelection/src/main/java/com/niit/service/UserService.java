package com.niit.service;

import com.niit.mapper.UserMapper;
import com.niit.pojo.User;
import com.niit.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserService {
    private static SqlSession sqlSession = null;
    static {
        try {
            sqlSession = MybatisUtil.getSqlSession();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> selectUsers(){
        return this.getMapper().selectUsers();
    }
    public User findUserByUsername(String username){
        return this.getMapper().findUserByUsername(username);
    }

    public Boolean createUser(String username,String password,String userType){
        Boolean b = this.getMapper().createUser(username, password, userType);
        if(b){
            this.commit();
        }else {
            this.rollback();
        }
        return b;
    }

    private UserMapper getMapper(){
        return sqlSession.getMapper(UserMapper.class);
    }

    private void commit(){
        sqlSession.commit();
    }
    private void rollback(){
        sqlSession.rollback();
    }
}
