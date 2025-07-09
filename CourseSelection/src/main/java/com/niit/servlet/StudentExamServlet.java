package com.niit.servlet;

import com.niit.pojo.StudentCourse;
import com.niit.service.StudentCourseService;
import com.niit.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/StudentExamServlet")
public class StudentExamServlet extends HttpServlet {
    private int year;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sno = new ServletUtil().getSnoByUsernameFromSession(req);
        year = Integer.parseInt(req.getParameter("year"));
        List<StudentCourse> studentCourses = new StudentCourseService().findStudentCourseBySnoAndYear(sno, year);
        System.out.println(studentCourses);
        req.setAttribute("studentCourses",studentCourses);
        req.getRequestDispatcher("/student/exam.jsp").forward(req,resp);

    }
}
