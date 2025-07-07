package com.niit.servlet;

import com.niit.pojo.Course;
import com.niit.pojo.CourseSchedule;
import com.niit.pojo.StudentCourse;
import com.niit.service.StudentCourseService;
import com.niit.service.StudentService;
import com.niit.service.UserService;
import com.niit.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

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
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
        }
    }

    private void loading(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int sno = new ServletUtil().getSnoBySnameFromSeesion(req);
        String userType = new ServletUtil().getUserTypeFromSeesion(req);

        int year = Integer.parseInt(req.getParameter("year"));
        int semester = Integer.parseInt(req.getParameter("semester"));
        int week = Integer.parseInt(req.getParameter("week"));

        // 初始化sendSC列表
        List<StudentCourse> sendSC = new ArrayList<>();

        if (Objects.equals(userType, "student")) {
            List<CourseSchedule> courseSchedules = new ArrayList<>();
            courseSchedules.add(new CourseSchedule("第一节 - 第二节",1));
            courseSchedules.add(new CourseSchedule("第三节 - 第四节",3));
            courseSchedules.add(new CourseSchedule("第五节 - 第六节",5));
            courseSchedules.add(new CourseSchedule("第七节 - 第八节",7));
            courseSchedules.add(new CourseSchedule("第九节 - 第十节",9));

            List<StudentCourse> studentCourses = new StudentCourseService().findStudentCourseBySnoAndAcademicYear(sno,year);
            if(studentCourses == null){
                resp.sendRedirect("/index.jsp");
                return;
            }

            for (StudentCourse sc : studentCourses) {
                // 修正学年格式匹配逻辑
                String expectedAcademicYear = year + "-" + (year + 1);
                boolean isAcademicYearMatch = sc.getAcademicYear().equals(expectedAcademicYear);
                boolean isSemesterMatch = sc.getSemester() == semester;
                boolean isWeekInRange = week >= sc.getStartWeek() && week <= sc.getEndWeek();

                // 基础条件：学年、学期、周次在范围内
                if (isAcademicYearMatch && isSemesterMatch && isWeekInRange) {
                    // 处理不同周次类型
                    if (sc.getWeekType().equals("双周") && week % 2 == 0) {
                        sendSC.add(sc);
                    } else if (sc.getWeekType().equals("单周") && week % 2 == 1) {
                        sendSC.add(sc);
                    } else if (sc.getWeekType().equals("全周")) {
                        // 全周课程直接添加
                        sendSC.add(sc);
                    }
                }
            }

            req.setAttribute("StudentCourses", sendSC);
            req.setAttribute("CourseSchedules",courseSchedules);

            System.out.println("添加到session的课程数量: " + sendSC.size()); // 调试用
            System.out.println(sendSC);
            req.getRequestDispatcher("/student/scheduleView.jsp").forward(req,resp);
            return;
        }
        resp.sendRedirect("/index.jsp");
    }
}