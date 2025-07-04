package com.niit.mapper;

import com.niit.pojo.Course;

import java.util.List;

public interface CourseMapper {
    List<Course> selectCourses();
}
