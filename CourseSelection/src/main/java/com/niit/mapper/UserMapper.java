package com.niit.mapper;

import com.niit.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> selectUsers();
    User findUserByUsername(@Param("username") String username);

    Boolean createUser(@Param("username") String username,@Param("password") String password,@Param("userType") String userType);
}
