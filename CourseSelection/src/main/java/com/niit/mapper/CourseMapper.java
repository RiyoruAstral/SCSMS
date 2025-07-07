package com.niit.mapper;

import com.niit.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    List<Course> selectCourses();
    Course findCourseBySnoAndCno(@Param("sno") int sno,@Param("cno") int cno);

    Course findPreCourseBySnoAndCno(@Param("sno") int sno,@Param("cno") int cno);
}
