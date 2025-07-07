package com.niit.mapper;

import com.niit.pojo.StudentCredit;
import org.apache.ibatis.annotations.Param;

public interface StudentCreditMapper {
    StudentCredit findStudentCreditBySno(@Param("sno") String sno);
}
