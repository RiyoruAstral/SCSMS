package com.niit.mapper;

import com.niit.pojo.Selection;
import org.apache.ibatis.annotations.Param;

public interface SelectionMapper {
    int insertSelection(@Param("sno") int sno,@Param("cno") int cno);

    int deleteSelection(@Param("sno")int sno,@Param("cno")int cno);
}
