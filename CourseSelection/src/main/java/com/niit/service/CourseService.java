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

    public int insertCourse(
            Course course
    ){
        int i = mapper.insertCourse(
                course.getCno(),
                course.getCName(),
                course.getYear(),
                course.getDayOfType(),
                course.getTime(),
                course.getStartWeek(),
                course.getEndWeek(),
                course.getCredit(),
                course.getType(),
                course.getSemester(),
                course.getSelectPeople(),
                course.getTotalPeople()
        );
        if(i>0){
            service.commit();
        }else {
            service.rollback();
        }
        return i;
    }

    public String findMax_cno(){
        return mapper.findMax_cno();
    }

    public int deleteCourse(String cno){
        int i = mapper.deleteCourse(cno);
        if(i>0){
            service.commit();
        }else {
            service.rollback();
        }
        return i;
    }

    public List<Course> findElectiveCourse(){return mapper.findElectiveCourse();}
    public List<String> findSelectionCourse(String sno){return mapper.findSelectionCourse(sno);}


}
