package com.niit.mapper;

import com.niit.pojo.StudentCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentCourseMapper {
    List<StudentCourse> findStudentCourseBySnoAndAcademicYear(@Param("sno") int sno,@Param("academicYear") int academicYear);
}
