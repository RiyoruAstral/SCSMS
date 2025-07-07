package com.niit.service;

import com.niit.mapper.SelectionMapper;
import com.niit.util.MyBatisService;
import org.apache.ibatis.annotations.Param;

public class SelectionService {
    MyBatisService service = MyBatisService.getInstance();
    private final SelectionMapper mapper = service.getMapper(SelectionMapper.class);

    public int insertSelection(int sno,int cno){
        int i = mapper.insertSelection(sno, cno);
        if(i > 0){
            service.commit();
        }else {
            service.rollback();
        }
        return i;
    }

    public int deleteSelection(int sno, int cno){
        int i = mapper.deleteSelection(sno, cno);
        if(i > 0){
            service.commit();
        }else {
            service.rollback();
        }
        return i;
    }
}
