package com.niit.mapper;

import com.niit.pojo.StudnetCompletionRate;
import org.apache.ibatis.annotations.Param;

public interface StudnetCompletionRateMapper {
    StudnetCompletionRate findStudnetCompletionRateBySno(@Param("sno") int sno);
}
