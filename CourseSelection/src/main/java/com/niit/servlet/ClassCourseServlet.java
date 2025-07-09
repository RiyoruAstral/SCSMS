package com.niit.servlet;

import com.niit.pojo.CourseSchedule;
import com.niit.pojo.StudentCourse;
import com.niit.service.ClassService;
import com.niit.service.ClassStudentService;
import com.niit.service.StudentCourseService;
import com.niit.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ClassCourseServlet")
public class ClassCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String action = req.getParameter("action");
        if (action == null) {
            System.out.println("no action!be careful!!!");
            if (!resp.isCommitted()) {
                req.getRequestDispatcher("/index.html").forward(req, resp);
            }
            return;
        }

        System.out.println(action);
        switch (action) {
            case "loading":
                loading(req, resp);
                break;
            case "select":
                break;
            case "cancel":
                break;
            default:
                System.out.println("no action!be careful!!!");
                if (!resp.isCommitted()) {
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
        }
    }

    private void loading(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int year = Integer.parseInt(req.getParameter("year"));
        int semester = Integer.parseInt(req.getParameter("semester"));
        int week = Integer.parseInt(req.getParameter("week"));
        System.out.println(year);
        System.out.println(semester);
        System.out.println(week);


        //获取时间映射表
        List<CourseSchedule> courseSchedules = new ServletUtil().createCourseSchedules();
        req.setAttribute("CourseSchedules",courseSchedules);
        //从当前学生获取班级
        String sno = new ServletUtil().getSnoByUserIdFromSession(req);
        int classId = new ClassStudentService().findClassIdBySno(sno);

        String className = new ClassService().findClassNameByClassId(classId);
        System.out.println(className);
        req.setAttribute("ClassName", className);
        //从班级获取所有课程
        List<StudentCourse> classCourses = new StudentCourseService().findClassByClassIdYear(classId,year);
        System.out.println(classCourses);

        List<StudentCourse> sendCC = new ArrayList<>();

        for(StudentCourse c : classCourses){
            if(year == Integer.parseInt(c.getYear()) && semester ==  c.getSemester() && week <= c.getEndWeek() && week >= c.getStartWeek()){
                sendCC.add(c);
            }
        }

        System.out.println(sendCC);
        req.setAttribute("ClassCourses", sendCC);

        req.getRequestDispatcher("/student/classSchedule.jsp").forward(req,resp);

    }
}

