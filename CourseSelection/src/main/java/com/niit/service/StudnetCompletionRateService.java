package com.niit.service;

import com.niit.mapper.StudentMapper;
import com.niit.mapper.StudnetCompletionRateMapper;
import com.niit.pojo.StudnetCompletionRate;
import com.niit.util.MyBatisService;
import com.niit.util.MybatisUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

public class StudnetCompletionRateService {
    MyBatisService service = MyBatisService.getInstance();
    private final StudnetCompletionRateMapper mapper = service.getMapper(StudnetCompletionRateMapper.class);

    public StudnetCompletionRate findStudnetCompletionRateBySno(int sno){return mapper.findStudnetCompletionRateBySno(sno);};
}
