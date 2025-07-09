package com.niit.servlet;

import com.niit.pojo.Student;
import com.niit.pojo.Teacher;
import com.niit.pojo.User;
import com.niit.service.StudentService;
import com.niit.service.TeacherService;
import com.niit.service.UserService;
import com.niit.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    String msg;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String otherId = req.getParameter("userId");
        String password = req.getParameter("password");
        String userType = req.getParameter("userType");
        System.out.println(username);
        System.out.println(password);
        System.out.println(otherId);
        System.out.println(userType);

        int maxUserId = new UserService().findMaxUserId();
        maxUserId += 1;
        //不存在问题
        if(Objects.equals(userType, "student")){
            Student student = new StudentService().findStudentBySno(otherId);
            System.out.println(student);
            if(student == null){
                msg = "该学生不存在";
                System.out.println(msg);
                req.getSession().setAttribute("registerMsg",msg);
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
                return;
            }
        } else if (Objects.equals(userType, "teacher")) {
            Teacher teacher = new TeacherService().findTeacherByTno(otherId);
            System.out.println(teacher);
            if(teacher == null){
                msg = "该老师不存在";
                System.out.println(msg);
                req.getSession().setAttribute("registerMsg",msg);
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
                return;
            }
        }
        //存在相同的
        User user2 = new UserService().findUserByOtherId(otherId);
        System.out.println(user2);
        if(user2 != null){
            msg = "已被注册";
            System.out.println(msg);
            req.getSession().setAttribute("registerMsg",msg);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        User user = new UserService().findUserByUsername(username);
        System.out.println(user);
        if(user != null){
            msg = "用户名重复";
            System.out.println(msg);
            req.getSession().setAttribute("registerMsg",msg);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        new UserService().insertUser(maxUserId,username,password,userType,otherId);
        User user1 = new UserService().findUserByUserId(maxUserId);
        System.out.println(user1);
        if(user1 == null){
            msg="注册失败";
            System.out.println(msg);
            req.getSession().setAttribute("registerMsg",msg);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        msg="注册成功";
        System.out.println(msg);
        req.getSession().setAttribute("loginMsg",msg);
        resp.sendRedirect("/login.jsp?username="+user1.getUsername()+"&password="+user1.getPassword());
        System.out.println("注册成功!用户"+user1);
        return;
    }
}
