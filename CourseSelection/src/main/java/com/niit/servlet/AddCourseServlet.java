package com.niit.servlet;

import com.niit.pojo.Course;
import com.niit.pojo.CourseLocation;
import com.niit.pojo.Teacher;
import com.niit.pojo.TeacherCourse;
import com.niit.service.CourseLocationService;
import com.niit.service.CourseService;
import com.niit.service.TeacherCourseService;
import com.niit.service.TeacherService;
import com.niit.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {
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
            case "update":
                update(req, resp);
                break;
            default:
                System.out.println("no action!be careful!!!");
                if (!resp.isCommitted()) {
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
        }
    }

    private void loading(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取老师名字 添加到授课人位置
        String tno = new ServletUtil().getTnoByUsernameFromSession(req);
        Teacher teacher = new TeacherService().findTeacherByTno(tno);
        System.out.println(teacher);
        req.setAttribute("tname",teacher.getTName());
        //获取所有地点
        List<CourseLocation> locations = new CourseLocationService().selectAllLocation();
        System.out.println(locations);
        req.setAttribute("locations",locations);

        String title = req.getParameter("title");
        req.setAttribute("title",title);
        req.getRequestDispatcher("/teacher/addCourse.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取表单数据
        String name = req.getParameter("name");
        String location = req.getParameter("location");
        int year = Integer.parseInt(req.getParameter("year"));
        int semester = Integer.parseInt(req.getParameter("semester"));
        int week = Integer.parseInt(req.getParameter("week"));
        int time = Integer.parseInt(req.getParameter("time"));
        int startWeek = Integer.parseInt(req.getParameter("startWeek"));
        int endWeek = Integer.parseInt(req.getParameter("endWeek"));
        String type = req.getParameter("type");
        int credit = Integer.parseInt(req.getParameter("credit"));
        String tname = req.getParameter("tname");
        int peopleNum = Integer.parseInt(req.getParameter("maxPeople"));
        String tno = new ServletUtil().getTnoByUsernameFromSession(req);
        //比对该教师的时间表
        List<TeacherCourse> teacherCourses = new TeacherCourseService().findTeacherCourseBySnoAndYear(tno, year);
        for(TeacherCourse c : teacherCourses){
            if(
                    c.getSemester() == semester
                    && c.getDayOfWeek() == week
                    && c.getTime() == time
            ){
                String msg = "该时间点已有课程";
                System.out.println(msg);
                req.getSession().setAttribute("msg", msg);
                resp.sendRedirect("/AddCourseServlet?action=loading&title=success");
                return;
            }
        }
        //比对其他教师所教的地点表
        List<TeacherCourse> courseNotInTno = new TeacherCourseService().findTeacherCourseNotInTno(tno, year);
        for(TeacherCourse c : courseNotInTno){
            String dnoBydName = new CourseLocationService().findDnoBydName(c.getDName());
            String dName = c.getDName();
            if(
                    c.getSemester() == semester
                    && c.getDayOfWeek() == week
                    && c.getTime() == time
                    && Objects.equals(dnoBydName, location)
            ){
                String msg = "该时间点该教室已被占用!";
                System.out.println(msg);
                req.getSession().setAttribute("msg", msg);
                resp.sendRedirect("/AddCourseServlet?action=loading&title=success");
                return;
            }

        }
        //添加课程表
        //主键增
        String maxCno = new CourseService().findMax_cno();
        // 提取数字部分（去掉前缀"C"）
        String numStr = maxCno.substring(1);  // 如"C005"→"005"
        // 转为整数并加1
        int num = Integer.parseInt(numStr) + 1;
        // 补全为3位数字，再拼接前缀"C"
        String cno = String.format("C%03d", num);// 如6→"C006"，10→"C010"
        Course course = new Course(cno, name, year, week, time, startWeek, endWeek, credit, type, semester, 0, peopleNum);
        System.out.println(course);
        int i = new CourseService().insertCourse(course);
        System.out.println(i);
        if (i > 0) {
            System.out.println("课程创建成功");

            int i1 = new TeacherService().insertTeaching(tno, cno);
            if(i1 > 0){
                System.out.println("教师关联成功");
                int i2 = new CourseLocationService().insertLocation(cno, location);
                if(i2 > 0){
                    System.out.println("位置关联成功");
                    // 此处直接 redirect，不使用 forward
                    String msg = "创建成功";
                    System.out.println(msg);
                    req.getSession().setAttribute("msg", msg);
                    resp.sendRedirect("/AddCourseServlet?action=loading&title=success");
                    // 跳转后立即 return，避免执行后续代码
                    return;
                }
            }
        }
        // 若上述分支未执行，最终执行一次 redirect
        String msg = "创建失败-未知原因";
        System.out.println(msg);
        req.getSession().setAttribute("msg", msg);
        resp.sendRedirect("/AddCourseServlet?action=loading&title=success");
    }
}
