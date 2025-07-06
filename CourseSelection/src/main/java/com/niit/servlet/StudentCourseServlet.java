package com.niit.servlet;

import com.niit.pojo.Course;
import com.niit.pojo.StudentCourse;
import com.niit.service.CourseService;
import com.niit.service.StudentCourseService;
import com.niit.service.StudentService;
import com.niit.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet("/StudentCourseServlet")
public class StudentCourseServlet extends HttpServlet {
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
                req.getRequestDispatcher("/index.html").forward(req, resp);
            }
            return;
        }

        switch (action) {
            case "loading":
                loading(req, resp);
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                System.out.println("no action!be careful!!!");
                if (!resp.isCommitted()) {
                    req.getRequestDispatcher("/index.html").forward(req, resp);
                }
        }
    }

    private void loading(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String userType = (String) session.getAttribute("userType");

        String year = req.getParameter("year");
        int semester = Integer.parseInt(req.getParameter("semester"));
        int week = Integer.parseInt(req.getParameter("week"));

        // 初始化sendSC列表
        List<StudentCourse> sendSC = new ArrayList<>();

        if (Objects.equals(userType, "student")) {
            int userId = new UserService().findUserByUsername(username).getUserId();
            int sno = new StudentService().findStudentByUserId(userId).getSno();
            List<StudentCourse> studentCourses = new StudentCourseService().findStudentCourseBySno(sno);

            for (StudentCourse sc : studentCourses) {
                // 检查学年格式是否匹配
                if (sc.getAcademicYear().equals(year + "-" + (Integer.parseInt(year) + 1))
                        && sc.getSemester() == semester
                        && week >= sc.getStartWeek()
                        && week <= sc.getEndWeek()) {

                    // 处理单双周逻辑
                    if (sc.getWeekType().equals("双周") && week % 2 == 0) {
                        sendSC.add(sc);
                    } else if (sc.getWeekType().equals("单周") && week % 2 == 1) {
                        sendSC.add(sc);
                    } else if (sc.getWeekType().equals("每周")) {
                        // 添加每周都上的课程
                        sendSC.add(sc);
                    }
                }
            }
            session.setAttribute("StudentCourses", sendSC);

            // 重定向前检查响应是否已提交
            if (!resp.isCommitted()) {
                resp.sendRedirect("/studentCourse.jsp");
                return; // 确保重定向后不再执行后续代码
            }
        }

        // 处理非学生用户或其他异常情况
        if (!resp.isCommitted()) {
            resp.sendRedirect("/index.jsp");
        }
    }
}