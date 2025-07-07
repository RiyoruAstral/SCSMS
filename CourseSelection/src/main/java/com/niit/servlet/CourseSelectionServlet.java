package com.niit.servlet;

import com.niit.pojo.*;

import com.niit.service.*;

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
                select(req, resp);
                break;
            case "cancel":
                cancel(req, resp);
                break;
            default:
                System.out.println("no action!be careful!!!");
                if (!resp.isCommitted()) {
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
        }
    }

    private void loading(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 课程对应表
        List<CourseSchedule> courseSchedules = new ServletUtil().createCourseSchedules();
        req.setAttribute("CourseSchedules",courseSchedules);
        // 时间 星期
        int dayOfWeek = Integer.parseInt(req.getParameter("dayOfWeek"));
        int startTime = Integer.parseInt(req.getParameter("startTime"));
        int semester = Integer.parseInt(req.getParameter("semester"));
        int year = Integer.parseInt(req.getParameter("year"));
        System.out.println(dayOfWeek);
        System.out.println(startTime);
        System.out.println(semester);
        System.out.println(year);
        req.setAttribute("year",year);
        req.setAttribute("semester",semester);
        //用户
        String userType = new ServletUtil().getUserTypeFromSeesion(req);
        String sno = new ServletUtil().getSnoBySnameFromSeesion(req);
        //先修学分 总修学分
        StudentCredit studentCredit = new StudentCreditService().findStudentCreditBySno(sno);
        System.out.println(studentCredit);
        req.setAttribute("studentCredit", studentCredit);
        //查找所有选修课
        List<StudentCourse> studentCourses = new StudentCourseService().findElectiveCourseBySnoDayTime(sno,dayOfWeek,startTime);
        System.out.println(studentCourses);
        req.setAttribute("studentCourses",studentCourses);
        // 文本
        String title = req.getParameter("title");
        System.out.println(title);
        req.setAttribute("title", title);

        req.getRequestDispatcher("/student/courseSelection.jsp").forward(req, resp);
    }

    private void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sno = new ServletUtil().getSnoBySnameFromSeesion(req);
        String cno = req.getParameter("cno");
        // 插入选择数据
        String msg = ""; // 存储操作结果消息

        // 1. 校验参数合法性
        if (sno == null || sno.trim().isEmpty() || cno == null || cno.trim().isEmpty()) {
            msg = "选课失败：学生编号或课程编号不能为空";
            req.getSession().setAttribute("msg", msg);
            resp.sendRedirect(req.getContextPath() + "/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0&year=2025&semester=1&title=error");
            return;
        }

        // 2. 执行插入选课记录
        //先检查是否存在当前时间段的课程
        int year = Integer.parseInt(req.getParameter("year"));
        new StudentCourseService().findStudentCourseBySnoAndYear(sno,year);

        int i1 = new StudentCourseService().insertSelectionCourse(sno, cno);
        if (i1 <= 0) {
            // 插入失败：可能原因（重复选课、外键不存在、数据库异常）
            msg = "选课失败：该课程可能已选或课程信息无效";
            req.getSession().setAttribute("msg", msg);
            resp.sendRedirect(req.getContextPath() + "/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0&year=2025&semester=1&title=error");
            return;
        }

        // 3. 执行更新课程人数
        int i2 = new StudentCourseService().updateSelectionCourse(cno);
        if (i2 <= 0) {
            // 人数更新失败：需回滚（假设StudentCourseService有删除选课记录的方法，若没有则提示异常）
            // 此处利用现有逻辑反向操作，确保数据一致
            new StudentCourseService().dropSelectionCourse(sno, cno);
            new StudentCourseService().deleteSelectionCourse(cno); // 假设存在该方法（若不存在可忽略，仅提示错误）
            msg = "选课失败：课程人数更新异常，请重试";
            req.getSession().setAttribute("msg", msg);
            resp.sendRedirect(req.getContextPath() + "/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0&year=2025&semester=1&title=error");
            return;
        }

        System.out.println("选课成功");
        req.getSession().setAttribute("msg", "选课成功");
        resp.sendRedirect(req.getContextPath() + "/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0&year=2025&semester=1&title=success");
    }

    private void cancel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sno = new ServletUtil().getSnoBySnameFromSeesion(req);
        String cno = req.getParameter("cno");
        // 插入选择数据
        String msg = ""; // 存储操作结果消息

        // 1. 校验参数合法性
        if (sno == null || sno.trim().isEmpty() || cno == null || cno.trim().isEmpty()) {
            msg = "退课失败：学生编号或课程编号不能为空";
            req.getSession().setAttribute("msg", msg);
            resp.sendRedirect(req.getContextPath() + "/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0&year=2025&semester=1&title=error");
            return;
        }

        // 2. 执行删除选课记录
        int i1 = new StudentCourseService().dropSelectionCourse(sno, cno);
        if (i1 <= 0) {
            // 插入失败：可能原因（重复选课、外键不存在、数据库异常）
            msg = "退课失败：该课程可能未选或课程信息无效";
            req.getSession().setAttribute("msg", msg);
            resp.sendRedirect(req.getContextPath() + "/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0&year=2025&semester=1&title=error");
            return;
        }
        // 3. 执行更新课程人数
        int i2 = new StudentCourseService().deleteSelectionCourse(cno);
        if (i2 <= 0) {
            // 人数更新失败：需回滚（假设StudentCourseService有删除选课记录的方法，若没有则提示异常）
            // 此处利用现有逻辑反向操作，确保数据一致
            new StudentCourseService().updateSelectionCourse(cno);
            new StudentCourseService().insertSelectionCourse(sno, cno);
            msg = "退课失败：课程人数更新异常，请重试";
            req.getSession().setAttribute("msg", msg);
            resp.sendRedirect(req.getContextPath() + "/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0&year=2025&semester=1&title=error");
            return;
        }

        System.out.println("退课成功");
        req.getSession().setAttribute("msg", "退课成功");
        resp.sendRedirect(req.getContextPath() + "/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0&year=2025&semester=1&title=success");
    }
}