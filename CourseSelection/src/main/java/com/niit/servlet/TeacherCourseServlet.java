package com.niit.servlet;

import com.niit.pojo.CourseSchedule;
import com.niit.pojo.StudentCourse;
import com.niit.pojo.TeacherCourse;
import com.niit.service.StudentCourseService;
import com.niit.service.TeacherCourseService;
import com.niit.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet("/TeacherCourseServlet")
public class TeacherCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 移除不必要的响应内容类型设置，避免提前提交响应
        // resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");
        if (action == null) {
            System.out.println("no action!be careful!!!");
            // 重定向前确保响应未提交
            if (!resp.isCommitted()) {
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
            return;
        }

        switch (action) {
            case "loading":
                System.out.println("loading");
                loading(req, resp);
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                System.out.println("no action!be careful!!!");
                if (!resp.isCommitted()) {
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
        }
    }
    private void loading(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //用户信息
        String tno = new ServletUtil().getTnoByUsernameFromSeesion(req);
        String userType = new ServletUtil().getUserTypeFromSeesion(req);
        System.out.println(tno);
        System.out.println(userType);
        //时间信息
        int year = Integer.parseInt(req.getParameter("year"));
        int semester = Integer.parseInt(req.getParameter("semester"));
        int week = Integer.parseInt(req.getParameter("week"));
        System.out.println(year);
        System.out.println(semester);
        System.out.println(week);
        // 初始化sendSC列表
        List<TeacherCourse> sendTC = new ArrayList<>();
        //如果当前是学生
        if (Objects.equals(userType, "teacher")) {
            //获取时间映射表
            List<CourseSchedule> courseSchedules = new ServletUtil().createCourseSchedules();
            req.setAttribute("CourseSchedules",courseSchedules);
            //获取课程表
            List<TeacherCourse> teacherCourses = new TeacherCourseService().findTeacherCourseBySnoAndYear(tno,year);
            if(teacherCourses == null){
                resp.sendRedirect("/index.jsp");
                return;
            }

            for(TeacherCourse c : teacherCourses){
                if(year == Integer.parseInt(c.getYear()) && semester == c.getSemester() && week <= c.getEndWeek() && week >= c.getStartWeek()){
                    sendTC.add(c);
                }
            }

            System.out.println("添加到session的课程数量: " + sendTC.size()); // 调试用
            System.out.println(sendTC);


            req.setAttribute("TeacherCourses", sendTC);


            req.getRequestDispatcher("/teacher/scheduleView.jsp").forward(req,resp);
            return;
        }
        resp.sendRedirect("/index.jsp");
    }
}
