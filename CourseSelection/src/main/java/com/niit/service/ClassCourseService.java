package com.niit.service;

import com.niit.mapper.ClassCourseMapper;
import com.niit.mapper.ClassStudentMapper;
import com.niit.pojo.Course;
import com.niit.pojo.StudentCourse;
import com.niit.util.MyBatisService;

import java.util.List;

public class ClassCourseService {
    MyBatisService service = MyBatisService.getInstance();
    private final ClassCourseMapper mapper = service.getMapper(ClassCourseMapper.class);

    public List<StudentCourse> findClassByClassIdYear(int classId, int year){
        return mapper.findCourseByClassIdYear(classId,year);
    }
}
