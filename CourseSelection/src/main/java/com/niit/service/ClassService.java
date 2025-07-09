package com.niit.service;

import com.niit.mapper.ClassMapper;
import com.niit.mapper.ClassStudentMapper;
import com.niit.util.MyBatisService;

public class ClassService {
    MyBatisService service = MyBatisService.getInstance();
    private final ClassMapper mapper = service.getMapper(ClassMapper.class);

    public String findClassNameByClassId(int classId){
        return mapper.findClassNameByClassId(classId);
    }
}
