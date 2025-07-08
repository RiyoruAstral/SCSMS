package com.niit.util;

import com.niit.pojo.CourseSchedule;
import com.niit.pojo.User;
import com.niit.service.StudentService;
import com.niit.service.TeacherService;
import com.niit.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ServletUtil {
    public String getSnoByUsernameFromSession(HttpServletRequest req){
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        int userId = new UserService().findUserByUsername(username).getUserId();
        return new StudentService().findStudentByUserId(userId).getSno();
    }
    public String getTnoByUsernameFromSession(HttpServletRequest req){
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        int userId = new UserService().findUserByUsername(username).getUserId();
        return new TeacherService().findTeacherByUserId(userId).getTno();
    }
    public String getUserTypeFromSession(HttpServletRequest req){
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


    public User findUserFromSession(HttpServletRequest req){
        String userType = new ServletUtil().getUserTypeFromSession(req);
        System.out.println(userType);
        req.setAttribute("userType",userType);
        User user = new User();
        if(Objects.equals(userType, "student")){
            String sno = new ServletUtil().getSnoByUsernameFromSession(req);
            System.out.println(sno);
            user = new UserService().findUserBySno(sno);


        }else if(Objects.equals(userType, "teacher")){
            String tno = new ServletUtil().getTnoByUsernameFromSession(req);
            System.out.println(tno);
            user = new UserService().findUserByTno(tno);
        }
        return user;
    }

}
