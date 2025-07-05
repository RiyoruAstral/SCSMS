package com.niit.servlet;

import com.niit.pojo.Student;
import com.niit.pojo.User;
import com.niit.service.StudentService;
import com.niit.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
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
        int sno = Integer.parseInt(req.getParameter("studentId"));
        String password = req.getParameter("password");
        int department = Integer.parseInt(req.getParameter("department"));
        System.out.println(username);
        System.out.println(password);
        System.out.println(sno);
        System.out.println(department);

        Student studentBySnoAndDepartment = new StudentService().findStudentBySnoAndDepartment(sno, department);
        if (studentBySnoAndDepartment == null) {
            System.out.println("不存在该学生!");
            resp.sendRedirect("/register.jsp");
            return;
        }
        if(studentBySnoAndDepartment.getUserId() != 0){
            System.out.println("该学生号已经有用户注册了!");
            resp.sendRedirect("/register.jsp");
            return;
        }

        if(new UserService().createUser(username,password,"student")){
            User user = new UserService().findUserByUsername(username);
            new StudentService().updateStudentUserId(sno,user.getUserId());
            System.out.println("注册成功!用户"+user);
            resp.sendRedirect("/login.jsp?username="+username+"&password="+password);
        }else {
            System.out.println("注册失败!");
            resp.sendRedirect("/register.jsp");
        }
    }
}
