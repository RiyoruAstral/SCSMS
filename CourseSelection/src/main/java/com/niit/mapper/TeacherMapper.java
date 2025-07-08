package com.niit.mapper;


import com.niit.pojo.Student;
import com.niit.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    Teacher findTeacherByTno(@Param("tno") String tno);
    Teacher findTeacherByUserId(@Param("userId") int userId);

    int insertTeaching(@Param("tno")String tno,@Param("cno")String cno);
}
