package com.niit.mapper;

import com.niit.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> selectUsers();
    User findUserByUsername(@Param("username") String username);
    User findUserByTno(@Param("tno")String tno);
    User findUserBySno(@Param("sno")String sno);

    int updateUserPassword(@Param("userId")int userId,@Param("password")String password);
    Boolean createUser(@Param("username") String username,@Param("password") String password,@Param("userType") String userType,@Param("otherNo") String otherNo);
    Boolean updateStudentUserId(@Param("sno") int sno,@Param("userId") int userId);


}
