package com.niit.mapper;

import com.niit.pojo.TeacherCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherCourseMapper {
    List<TeacherCourse> findTeacherCourseByTnoAndYear(@Param("tno") String tno, @Param("year") int year);
    List<TeacherCourse> findTeacherCourseNotInTno(@Param("tno")String tno,@Param("year") int year);

    int deleteTeacherAndCourse(@Param("tno")String tno, @Param("cno")String cno);
}
