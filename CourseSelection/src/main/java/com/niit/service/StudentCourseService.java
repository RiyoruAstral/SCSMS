package com.niit.service;


import com.niit.mapper.StudentCourseMapper;
import com.niit.pojo.StudentCourse;
import com.niit.util.MyBatisService;


import java.util.List;

public class StudentCourseService {
    MyBatisService service = MyBatisService.getInstance();
    private final StudentCourseMapper mapper = service.getMapper(StudentCourseMapper.class);

    public int updateGradeBySnoCno(String sno,String cno,int grade){
        int i = mapper.updateGradeBySnoCno(sno,cno,grade);
        if(i > 0){
            service.commit();
        }else{
            service.rollback();
        }
        return i;
    }

    public int deleteStudentCourse(String cno){
        int i = mapper.deleteStudentCourse(cno);
        if(i > 0){
            service.commit();
        }else{
            service.rollback();
        }
        return i;
    }

    public int insertSelectionCourse(String sno,String cno){
        int i = mapper.insertSelectionCourse(sno, cno);
        if(i > 0){
            service.commit();
        }else {
            service.rollback();
        }
        return i;
    }

    public int dropSelectionCourse(String sno,String cno){
        int i = mapper.dropSelectionCourse(sno, cno);
        if(i > 0){
            service.commit();
        }else {
            service.rollback();
        }
        return i;
    }

    public int updateSelectionCourse(String cno){
        int i = mapper.updateSelectionCourse(cno);
        if(i > 0){
            service.commit();
        }else {
            service.rollback();
        }
        return i;
    }

    public int deleteSelectionCourse(String cno){
        int i = mapper.deleteSelectionCourse(cno);
        if(i > 0){
            service.commit();
        }else {
            service.rollback();
        }
        return i;
    }

    public int countElectiveCourseBySno(String sno){
        return mapper.countElectiveCourseBySno(sno);
    };

    public List<StudentCourse> selectStudentCourseGrade(){
        return mapper.selectStudentCourseGrade();
    };
    public List<StudentCourse> findStudentCourseBySnoAndYear(String sno,int year){return mapper.findStudentCourseBySnoAndYear(sno,year);};
    public List<StudentCourse> findElectiveCourseBySnoDayTime(String sno,int dayOfWeek,int time){return mapper.findElectiveCourseBySnoDayTime(sno,dayOfWeek
    ,time);}
}
