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

    public Student findStudentBySnoAndDepartment(int sno,int dno){return mapper.findStudentBySnoAndDepartment(sno,dno);}
    public Student findStudentByUserId(int userId){return mapper.findStudentByUserId(userId);}

    public Boolean updateStudentUserId(int sno, int userId){
        Boolean b = mapper.updateStudentUserId(sno, userId);
        if(b){
            service.commit();
        }else {
            service.rollback();
        }
        return b;
    }

}
