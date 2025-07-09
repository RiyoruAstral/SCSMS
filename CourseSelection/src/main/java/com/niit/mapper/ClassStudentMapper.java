package com.niit.mapper;

import com.niit.pojo.ClassStudent;
import org.apache.ibatis.annotations.Param;

public interface ClassStudentMapper {
    int findClassIdBySno(@Param("sno")String sno);
}
