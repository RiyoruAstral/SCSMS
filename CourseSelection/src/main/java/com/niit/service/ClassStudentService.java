package com.niit.service;

import com.niit.mapper.ClassStudentMapper;
import com.niit.mapper.CourseMapper;
import com.niit.pojo.ClassStudent;
import com.niit.util.MyBatisService;
import org.apache.ibatis.annotations.Mapper;

public class ClassStudentService {
    MyBatisService service = MyBatisService.getInstance();
    private final ClassStudentMapper mapper = service.getMapper(ClassStudentMapper.class);

    public int findClassIdBySno(String sno){
        return mapper.findClassIdBySno(sno);
    }


}
