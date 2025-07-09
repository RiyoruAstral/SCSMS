package com.niit.mapper;

import org.apache.ibatis.annotations.Param;

public interface ClassMapper {
    String findClassNameByClassId(@Param("classId") int classId);
}
