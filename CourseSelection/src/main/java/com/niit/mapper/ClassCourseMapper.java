package com.niit.mapper;

import com.niit.pojo.Course;
import com.niit.pojo.StudentCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassCourseMapper {
    List<StudentCourse> findCourseByClassIdYear(@Param("classId")int classId,@Param("year")int year);
}
