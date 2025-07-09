package com.niit.service;

import com.niit.mapper.StudentMapper;
import com.niit.mapper.UserMapper;
import com.niit.pojo.User;
import com.niit.util.MyBatisService;
import com.niit.util.MybatisUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    public User findUserByTno(String tno){
        return mapper.findUserByTno(tno);
    }
    public User findUserBySno(String sno){
        return mapper.findUserBySno(sno);
    }

    public int updateUserPassword(int userId,String password){
        int i = mapper.updateUserPassword(userId,password);
        if(i>0){
            service.commit();
        }else{
            service.rollback();
        }
        return i;
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

    public int insertUser(int userId,String username,String password,String userType,String otherNo){
        int i = mapper.insertUser(userId, username, password, userType, otherNo);
        if(i > 0){
            service.commit();
        }else{
            service.rollback();
        }
        return i;
    }

    public int findMaxUserId(){
        return mapper.findMaxUserId();
    }

    public User findUserByUserId(int userId){
        return mapper.findUserByUserId(userId);
    }
    
    public User findUserByOtherId(String otherId){
        return mapper.findUserByOtherId(otherId);
    }
    

}
