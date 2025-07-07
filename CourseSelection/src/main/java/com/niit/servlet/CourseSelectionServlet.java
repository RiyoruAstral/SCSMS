package com.niit.servlet;

import com.niit.pojo.Course;
import com.niit.pojo.StudentCourseSelection;
import com.niit.pojo.StudnetCompletionRate;
import com.niit.service.CourseService;
import com.niit.service.SelectionService;
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

        System.out.println(action);
        switch (action){
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
        String userType = new ServletUtil().getUserTypeFromSeesion(req);
        int sno = new ServletUtil().getSnoBySnameFromSeesion(req);
        StudnetCompletionRate studentCompletionRate = new StudnetCompletionRateService().findStudnetCompletionRateBySno(sno);
        System.out.println(studentCompletionRate);

        int dayOfWeek = Integer.parseInt(req.getParameter("dayOfWeek"));
        int startTime = Integer.parseInt(req.getParameter("startTime"));
        String title = req.getParameter("title");

        List<StudentCourseSelection> courseSelections = new StudentCourseSelectionService().findStudentCourseSelectionBySno(sno,startTime,dayOfWeek);
        System.out.println(courseSelections);

        System.out.println(dayOfWeek);
        System.out.println(startTime);
        System.out.println(title);

        req.setAttribute("CSS",courseSelections);
        req.setAttribute("title",title);
        req.setAttribute("SCR",studentCompletionRate);
        req.getRequestDispatcher("/student/courseSelection.jsp").forward(req,resp);
    }

    private void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cno = Integer.parseInt(req.getParameter("cno"));
        int sno = new ServletUtil().getSnoBySnameFromSeesion(req);

//        req.setAttribute("action","loading");
//        req.setAttribute("dayOfWeek",0);
//        req.setAttribute("startTime",0);

        // 查找先修课
        Course preCourse = new CourseService().findPreCourseBysNoAndCno(sno, cno);
        //如果没有先修课
        if(preCourse == null){
            System.out.println("插入成功");
            req.setAttribute("Title","success");
            int i = new SelectionService().insertSelection(sno,cno);
            resp.sendRedirect(req.getContextPath() + "/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0?title=success&title=success");
//            req.getRequestDispatcher("/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0").forward(req,resp);
        }
        //如果有先修课
        //查找该学生是否选择了该先修课
        Course SelCourse = new CourseService().findCourseBySnoAndCno(sno, cno);
        //查出来有数据
        if(SelCourse != null) {
            int i = new SelectionService().insertSelection(sno,cno);
            if(i > 0){
                System.out.println("插入成功");
                req.setAttribute("Title","success");
                resp.sendRedirect(req.getContextPath() + "/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0?title=success&title=success");
//                req.getRequestDispatcher("/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0").forward(req,resp);
            }
        }
        //都不符合
        System.out.println("未选修先修课或插入失败");
        req.setAttribute("Title","fail");
        resp.sendRedirect(req.getContextPath() + "/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0&title=fail");
//        req.getRequestDispatcher("/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0").forward(req,resp);

    }


    private void cancel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取消掉该选修课与学生的关系
        int cno = Integer.parseInt(req.getParameter("cno"));
        int sno = new ServletUtil().getSnoBySnameFromSeesion(req);

        int i = new SelectionService().deleteSelection(sno,cno);
        System.out.println(i);
//        if(i > 0){
            System.out.println("取消成功!");
            req.setAttribute("Title","success");
            resp.sendRedirect(req.getContextPath() + "/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0&title=success");
//            req.getRequestDispatcher("/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0").forward(req,resp);
//        }
//        System.out.println("取消失败!");
//        req.setAttribute("Title","fail");
//        resp.sendRedirect(req.getContextPath() + "/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0?title=fail");
//        req.getRequestDispatcher("/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0").forward(req,resp);

    }
}
