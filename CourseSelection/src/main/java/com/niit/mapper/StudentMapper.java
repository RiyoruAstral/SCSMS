package com.niit.mapper;

import com.niit.pojo.Student;
import org.apache.ibatis.annotations.Param;


public interface StudentMapper {
    Student findStudentBySnoAndDepartment(@Param("sno") int sno,@Param("dno") int dno);
    Student findStudentByUserId(@Param("userId") int userId);

    Boolean updateStudentUserId(@Param("sno") int sno,@Param("userId") int userId);
}
