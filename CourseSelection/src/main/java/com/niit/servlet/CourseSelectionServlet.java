package com.niit.servlet;

import com.niit.pojo.StudentCourseSelection;
import com.niit.pojo.StudnetCompletionRate;
import com.niit.service.StudentCourseSelectionService;
import com.niit.service.StudnetCompletionRateService;
import com.niit.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CourseSelectionServlet")
public class CourseSelectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userType = new ServletUtil().getUserTypeFromSeesion(req);
        int sno = new ServletUtil().getSnoBySnameFromSeesion(req);
        StudnetCompletionRate studentCompletionRate = new StudnetCompletionRateService().findStudnetCompletionRateBySno(sno);
        System.out.println(studentCompletionRate);

        int dayOfWeek = Integer.parseInt(req.getParameter("dayOfWeek"));
        int startTime = Integer.parseInt(req.getParameter("startTime"));


        List<StudentCourseSelection> courseSelections = new StudentCourseSelectionService().findStudentCourseSelectionBySno(sno,startTime,dayOfWeek);
        System.out.println(courseSelections);

        req.setAttribute("CSS",courseSelections);

        req.setAttribute("SCR",studentCompletionRate);
        req.getRequestDispatcher("/student/courseSelection.jsp").forward(req,resp);
    }
}
