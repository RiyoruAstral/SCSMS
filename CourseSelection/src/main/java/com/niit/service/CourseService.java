package com.niit.service;

import com.niit.mapper.CourseMapper;
import com.niit.pojo.Course;
import com.niit.util.MyBatisService;

import com.niit.util.MybatisUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CourseService {

    MyBatisService service = MyBatisService.getInstance();
    private final CourseMapper mapper = service.getMapper(CourseMapper.class);


    public List<Course> selectCourses(){return mapper.selectCourses();}
    public Course findCourseBySnoAndCno(int sno, int cno){
        return mapper.findCourseBySnoAndCno(sno, cno);
    }
    public Course findPreCourseBysNoAndCno(int sno,int cno){return mapper.findPreCourseBySnoAndCno(sno,cno);};

}
