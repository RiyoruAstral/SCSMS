package com.niit.servlet;

import com.niit.pojo.User;
import com.niit.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
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
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        User user = new UserService().findUserByUsername(username);
        if(user == null){
            System.out.println("该用户尚未注册!");
            HttpSession session = req.getSession();
            resp.sendRedirect("/register.jsp?username="+username+"&password="+password);
            return;
        }
        if(!password.equals(user.getPassword())){
            System.out.println("用户存在但密码错误!");
            resp.sendRedirect("/login.jsp");
            return;
        }else {
            System.out.println("用户成功登录!");
            System.out.println("用户: " + user);
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("userType",user.getUserType());
            resp.sendRedirect("/index.jsp");
            return;
        }
    }
}
