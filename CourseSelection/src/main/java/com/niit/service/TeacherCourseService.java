package com.niit.service;

import com.niit.mapper.StudentCourseMapper;
import com.niit.mapper.TeacherCourseMapper;
import com.niit.pojo.TeacherCourse;
import com.niit.util.MyBatisService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public class TeacherCourseService {
    MyBatisService service = MyBatisService.getInstance();
    private final TeacherCourseMapper mapper = service.getMapper(TeacherCourseMapper.class);

    public List<TeacherCourse> findTeacherCourseBySnoAndYear(String tno,int year){
        return mapper.findTeacherCourseByTnoAndYear(tno, year);
    }
    public List<TeacherCourse> findTeacherCourseNotInTno(String tno,int year){
        return mapper.findTeacherCourseNotInTno(tno, year);
    };

    public int deleteTeacherAndCourse(@Param("tno")String tno, @Param("cno")String cno){
        int i = mapper.deleteTeacherAndCourse(tno, cno);
        if(i > 0){
            service.commit();
        }else{
            service.rollback();
        }
        return i;
    }
}
