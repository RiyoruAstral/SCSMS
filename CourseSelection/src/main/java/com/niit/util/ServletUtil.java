package com.niit.util;

import com.niit.service.StudentService;
import com.niit.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ServletUtil {
    public int getSnoBySnameFromSeesion(HttpServletRequest req){
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        int userId = new UserService().findUserByUsername(username).getUserId();
        return new StudentService().findStudentByUserId(userId).getSno();
    }
    public String getUserTypeFromSeesion(HttpServletRequest req){
        HttpSession session = req.getSession();
        return (String) session.getAttribute("userType");
    }
}
