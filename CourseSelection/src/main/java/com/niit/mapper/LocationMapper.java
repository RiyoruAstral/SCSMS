package com.niit.mapper;

import java.util.List;
import com.niit.pojo.CourseLocation;
import org.apache.ibatis.annotations.Param;

public interface LocationMapper {
    List<CourseLocation> selectAllLocation();
    String findDnoBydName(@Param("dName")String dName);

    int insertLocation(@Param("cno")String cno,@Param("dno") String dno);
}
