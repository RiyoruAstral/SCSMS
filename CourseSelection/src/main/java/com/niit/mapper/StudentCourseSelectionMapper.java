package com.niit.mapper;

import com.niit.pojo.StudentCourseSelection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentCourseSelectionMapper {
    public List<StudentCourseSelection> findStudentCourseSelectionBySno(@Param("sno") int sno,@Param("startTime") int startTime,@Param("dayOfWeek") int dayOfWeek);
}
