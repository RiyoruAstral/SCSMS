package com.niit.mapper;

import com.niit.pojo.StudentCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentCourseMapper {
    List<StudentCourse> findStudentCourseBySno(@Param("sno") int sno);
}
