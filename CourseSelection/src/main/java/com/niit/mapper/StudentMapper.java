package com.niit.mapper;

import com.niit.pojo.Student;
import org.apache.ibatis.annotations.Param;


public interface StudentMapper {
    Student findStudentBySno(@Param("sno") String sno);
    Student findStudentByUserId(@Param("userId") int userId);
}
