package com.niit.service;

import com.niit.mapper.StudentCreditMapper;
import com.niit.pojo.StudentCredit;
import com.niit.util.MyBatisService;

public class StudentCreditService {
    MyBatisService service = MyBatisService.getInstance();
    private final StudentCreditMapper mapper = service.getMapper(StudentCreditMapper.class);

    public StudentCredit findStudentCreditBySno(String sno){return mapper.findStudentCreditBySno(sno);};
}
