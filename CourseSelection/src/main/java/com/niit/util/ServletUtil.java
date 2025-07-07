package com.niit.util;

import com.niit.pojo.CourseSchedule;
import com.niit.service.StudentService;
import com.niit.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ServletUtil {
    public String getSnoBySnameFromSeesion(HttpServletRequest req){
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        int userId = new UserService().findUserByUsername(username).getUserId();
        return new StudentService().findStudentByUserId(userId).getSno();
    }
    public String getUserTypeFromSeesion(HttpServletRequest req){
        HttpSession session = req.getSession();
        return (String) session.getAttribute("userType");
    }
    public List<CourseSchedule> createCourseSchedules(){
        List<CourseSchedule> courseSchedules = new ArrayList<>();
        courseSchedules.add(new CourseSchedule("第一节 - 第二节",1,"周一",1));
        courseSchedules.add(new CourseSchedule("第三节 - 第四节",2,"周二",2));
        courseSchedules.add(new CourseSchedule("第五节 - 第六节",3,"周三",3));
        courseSchedules.add(new CourseSchedule("第七节 - 第八节",4,"周四",4));
        courseSchedules.add(new CourseSchedule("第九节 - 第十节",5,"周五",5));
        System.out.println(courseSchedules);
        return courseSchedules;
    }
}
