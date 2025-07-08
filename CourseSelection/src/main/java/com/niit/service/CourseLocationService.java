package com.niit.service;

import com.niit.mapper.LocationMapper;
import com.niit.pojo.CourseLocation;
import com.niit.util.MyBatisService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public class CourseLocationService {
    MyBatisService service = MyBatisService.getInstance();
    private final LocationMapper mapper = service.getMapper(LocationMapper.class);

    public int insertLocation(@Param("cno")String cno, @Param("dno") String dno){
        int i = mapper.insertLocation(cno, dno);
        if(i>0){
            service.commit();
        }else {
            service.rollback();
        }
        return i;
    }

    public int deleteLocation(String cno,String dno){
        int i = mapper.deleteLocation(cno,dno);
        if(i>0){
            service.commit();
        }else {
            service.rollback();
        }
        return i;
    }

    public String findDnoBydName(String dName){
        return mapper.findDnoBydName(dName);
    };

    public List<CourseLocation> selectAllLocation(){
        return mapper.selectAllLocation();
    }
}
