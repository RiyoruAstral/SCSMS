package com.niit.service;

import com.niit.mapper.StudentCourseMapper;
import com.niit.mapper.StudentCourseSelectionMapper;
import com.niit.pojo.StudentCourseSelection;
import com.niit.util.MyBatisService;

import java.util.List;

public class StudentCourseSelectionService {
    MyBatisService service = MyBatisService.getInstance();
    StudentCourseSelectionMapper mapper = service.getMapper(StudentCourseSelectionMapper.class);

    public List<StudentCourseSelection> findStudentCourseSelectionBySno(int sno,int startTime,int dayOfWeek){return mapper.findStudentCourseSelectionBySno(sno,startTime,dayOfWeek);}
}
