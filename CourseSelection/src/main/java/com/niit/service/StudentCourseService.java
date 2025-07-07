package com.niit.service;

import com.niit.mapper.CourseMapper;
import com.niit.mapper.StudentCourseMapper;
import com.niit.pojo.StudentCourse;
import com.niit.util.MyBatisService;
import com.niit.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentCourseService {
    MyBatisService service = MyBatisService.getInstance();
    private final StudentCourseMapper mapper = service.getMapper(StudentCourseMapper.class);

    public List<StudentCourse> findStudentCourseBySnoAndAcademicYear(int sno,int academicYear){return mapper.findStudentCourseBySnoAndAcademicYear(sno,academicYear);};
}
