package com.niit.service;

import com.niit.mapper.StudentMapper;
import com.niit.mapper.UserMapper;
import com.niit.pojo.User;
import com.niit.util.MyBatisService;
import com.niit.util.MybatisUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserService {
    MyBatisService service = MyBatisService.getInstance();
    private final UserMapper mapper = service.getMapper(UserMapper.class);

    public List<User> selectUsers(){
        return mapper.selectUsers();
    }
    public User findUserByUsername(String username){
        return mapper.findUserByUsername(username);
    }

    public Boolean createUser(String username,String password,String userType,String otherNo){
        Boolean b = mapper.createUser(username, password, userType,otherNo);
        if(b){
            service.commit();
        }else {
            service.rollback();
        }
        return b;
    }

    public Boolean updateStudentUserId(int sno, int userId){
        Boolean b = mapper.updateStudentUserId(sno, userId);
        if(b){
            service.commit();
        }else {
            service.rollback();
        }
        return b;
    }
}
