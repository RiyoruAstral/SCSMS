package com.niit.mapper;

import com.niit.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    List<Course> findElectiveCourse();
    List<String> findSelectionCourse(@Param("sno")String sno);

}
