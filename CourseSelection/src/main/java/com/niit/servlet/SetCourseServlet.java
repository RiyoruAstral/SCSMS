package com.niit.servlet;

import com.niit.pojo.StudentCourse;
import com.niit.pojo.TeacherCourse;
import com.niit.service.CourseLocationService;
import com.niit.service.CourseService;
import com.niit.service.StudentCourseService;
import com.niit.service.TeacherCourseService;
import com.niit.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SetCourseServlet")
public class SetCourseServlet extends HttpServlet {
    private int year;

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
        year = Integer.parseInt(req.getParameter("year"));

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
                System.out.println("loading");
                loading(req, resp);
                break;
            case "update":
                System.out.println("update");
                update(req, resp);
                break;
            case "delete":
                System.out.println("delete");
                delete(req, resp);
                break;
            default:
                System.out.println("no action!be careful!!!");
                if (!resp.isCommitted()) {
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
        }


    }

    private void loading (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取当前tno的所有课程
        String tno = new ServletUtil().getTnoByUsernameFromSession(req);

        List<TeacherCourse> teacherCourses = new TeacherCourseService().findTeacherCourseBySnoAndYear(tno, year);
        System.out.println(teacherCourses);
        req.setAttribute("teacherCourses",teacherCourses);

        //获取所有课程成绩 学生选课记录
        List<StudentCourse> studentCourses = new StudentCourseService().selectStudentCourseGrade();
        System.out.println(studentCourses);
        req.setAttribute("studentCourses",studentCourses);

        req.getRequestDispatcher("/teacher/setCourse.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sno = req.getParameter("sno");
        String cno = req.getParameter("cno");
        int newGrade = Integer.parseInt(req.getParameter("newGrade"));

        System.out.println(newGrade);
        int i = new StudentCourseService().updateGradeBySnoCno(sno, cno, newGrade);
        if(i > 0){
            String msg = "提交成功";
            System.out.println(msg);
            req.getSession().setAttribute("setCourseMsg", msg);
            resp.sendRedirect("/SetCourseServlet?action=loading&year="+year);
            return;
        }
        String msg = "提交失败";
        System.out.println(msg);
        req.getSession().setAttribute("setCourseMsg", msg);
        resp.sendRedirect("/SetCourseServlet?action=loading&year="+year);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cno = req.getParameter("cno");
        String tno = req.getParameter("tno");
        String dname = req.getParameter("dname");
        //解除教师关联
        int i = new TeacherCourseService().deleteTeacherAndCourse(tno, cno);
        if(i > 0){
            System.out.println("已解除教师关联");
            //解除位置关联
            String dno = new CourseLocationService().findDnoBydName(dname);
            int i1 = new CourseLocationService().deleteLocation(cno, dno);
            if(i1 > 0){
                System.out.println("已解除位置关联");
                //解除学生关联
                int i2 = new StudentCourseService().deleteStudentCourse(cno);
                    System.out.println("已解除学生关联");
                    //取消课程
                    int i3 = new CourseService().deleteCourse(cno);
                    if(i3 > 0){
                        String msg = "删除成功";
                        System.out.println(msg);
                        req.getSession().setAttribute("setCourseMsg", msg);
                        resp.sendRedirect("/SetCourseServlet?action=loading&year="+year);
                        return;
                    }
            }
            String msg = "删除失败";
            System.out.println(msg);
            req.getSession().setAttribute("setCourseMsg", msg);
            resp.sendRedirect("/SetCourseServlet?action=loading&year="+year);
        }





    }

}
