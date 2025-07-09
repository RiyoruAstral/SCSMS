package com.niit.mapper;

import com.niit.pojo.StudentCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentCourseMapper {
    List<StudentCourse> findStudentCourseBySnoAndYear(@Param("sno") String sno,@Param("year") int year);
    List<StudentCourse> findCourseByClassIdYear(@Param("classId")int classId,@Param("year")int year);

    List<StudentCourse> findElectiveCourseBySnoDayTime(@Param("sno") String sno,@Param("dayOfWeek")int dayOfWeek,@Param("time")int time);
    List<StudentCourse> selectStudentCourseGrade();
    int countElectiveCourseBySno(@Param("sno")String sno);
    int deleteStudentCourse(@Param("cno")String cno);

    int updateGradeBySnoCno(@Param("sno")String sno,@Param("cno") String cno,@Param("grade")int grade);

    int insertSelectionCourse(@Param("sno")String sno,@Param("cno")String cno);
    int dropSelectionCourse(@Param("sno")String sno,@Param("cno")String cno);

    int updateSelectionCourse(@Param("cno")String cno);
    int deleteSelectionCourse(@Param("cno")String cno);

}
