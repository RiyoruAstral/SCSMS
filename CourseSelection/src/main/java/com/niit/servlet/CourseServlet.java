package com.niit.servlet;

import com.niit.pojo.Course;
import com.niit.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if(action == null){
            System.out.println("no action!be careful!!!");
            req.getRequestDispatcher("/index.html").forward(req,resp);
        }
        switch (action){
            case "loading":
                loading(req, resp);
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                System.out.println("no action!be careful!!!");
                req.getRequestDispatcher("/index.html").forward(req,resp);
        }
    }

    private void loading(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Course> courses = new CourseService().selectCourses();
        System.out.println("I'm selecting course,Watching page!");
        // temp test
        for(Course c : courses){
            resp.getWriter().println(c);
        }
        // if finish code
//        req.setAttribute("courses",courses);
//        req.getRequestDispatcher("/course.jsp").forward(req,resp);
    }
}
