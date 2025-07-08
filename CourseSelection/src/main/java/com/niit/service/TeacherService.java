package com.niit.service;

import com.niit.mapper.StudentMapper;
import com.niit.mapper.TeacherMapper;
import com.niit.pojo.Student;
import com.niit.pojo.Teacher;
import com.niit.util.MyBatisService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public class TeacherService {
    MyBatisService service = MyBatisService.getInstance();
    private final TeacherMapper mapper = service.getMapper(TeacherMapper.class);

    public int insertTeaching(String tno, String cno){
        int i = mapper.insertTeaching(tno, cno);
        if(i>0){
            service.commit();
        }else {
            service.rollback();
        }
        return i;
    }

    public Teacher findTeacherByUserId(int userId){return mapper.findTeacherByUserId(userId);}
    public Teacher findTeacherByTno(String tno){
        return mapper.findTeacherByTno(tno);
    }
}
