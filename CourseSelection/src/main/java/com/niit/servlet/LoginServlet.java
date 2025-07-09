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
        //这里可以是username也可以是otherId
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        //先对是不是username判断
        User user = new UserService().findUserByUsername(username);
        System.out.println(user);
        if(user == null){
            //不是username 判断otherId
            User user1 = new UserService().findUserByOtherId(username);
            System.out.println(user1);
            if(user1 == null){
                //还没有就没注册
                msg = "该用户尚未注册!";
                System.out.println(msg);
                req.getSession().setAttribute("registerMsg",msg);
                resp.sendRedirect("/register.jsp");
                return;
            }
            //otherId查询到了 继续执行判别密码
            if(!password.equals(user1.getPassword())){
                msg = "用户存在但密码错误!";
                System.out.println(msg);
                req.getSession().setAttribute("loginMsg",msg);
                req.getRequestDispatcher("/login.jsp?username="+username).forward(req, resp);
                return;
            }
            //密码也成功
            System.out.println("用户成功登录!");
            System.out.println("用户: " + user1);
            req.getSession().setAttribute("username", user1.getUsername());
            req.getSession().setAttribute("userId", user1.getUserId());
            req.getSession().setAttribute("userType",user1.getUserType());
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        //username查询到了 继续执行判别密码
        if(!password.equals(user.getPassword())){
            msg = "用户存在但密码错误!";
            System.out.println(msg);
            req.getSession().setAttribute("loginMsg",msg);
            req.getRequestDispatcher("/login.jsp?username="+username).forward(req, resp);
            return;
        }
        System.out.println("用户成功登录!");
        System.out.println("用户: " + user);
        req.getSession().setAttribute("username", user.getUsername());
        req.getSession().setAttribute("userId", user.getUserId());
        req.getSession().setAttribute("userType",user.getUserType());
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
        return;
    }
}
