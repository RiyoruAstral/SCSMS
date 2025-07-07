package com.niit.service;

import com.niit.mapper.CourseMapper;
import com.niit.mapper.StudentMapper;
import com.niit.pojo.Student;
import com.niit.util.MyBatisService;
import com.niit.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class StudentService {
    MyBatisService service = MyBatisService.getInstance();
    private final StudentMapper mapper = service.getMapper(StudentMapper.class);

    public Student findStudentBySno(String sno){return mapper.findStudentBySno(sno);}
    public Student findStudentByUserId(int userId){return mapper.findStudentByUserId(userId);}

}
