package com.niit.mapper;

import com.niit.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    List<Course> findElectiveCourse();
    List<String> findSelectionCourse(@Param("sno")String sno);
    String findMax_cno();

    int deleteCourse(@Param("cno")String cno);

    int insertCourse(
            @Param("cno") String cno,
            @Param("cName") String cName,
            @Param("year") int year,
            @Param("dayOfWeek") int dayOfWeek,
            @Param("time") int time,
            @Param("startWeek") int startWeek,
            @Param("endWeek") int endWeek,
            @Param("credit") int credit,
            @Param("type") String type,
            @Param("semester") int semester,
            @Param("selectPeople") int selectPeople,
            @Param("totalPeople") int totalPeople,
            @Param("examTime") int examTime,
            @Param("examWeek") int examWeek
    );
}
