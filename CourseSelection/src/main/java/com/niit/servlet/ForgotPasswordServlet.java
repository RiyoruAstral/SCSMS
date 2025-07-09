package com.niit.servlet;

import com.niit.pojo.User;
import com.niit.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
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
        String otherId = req.getParameter("userId");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("rePassword");
        System.out.println(otherId);
        System.out.println(password);
        System.out.println(rePassword);
        User user = new UserService().findUserByOtherId(otherId);
        // 不存在用户
        if(user == null){
            msg = "该用户尚未注册!";
            System.out.println(msg);
            req.getSession().setAttribute("msg",msg);
            resp.sendRedirect("/register.jsp?otherId="+otherId+"&password="+password);
            return;
        }
        //存在用户 判别密码
        if(!Objects.equals(password, rePassword)){
            msg = "两次密码错误!";
            System.out.println(msg);
            req.getSession().setAttribute("forgotMsg",msg);
            req.getRequestDispatcher("/forgotPassword.jsp").forward(req, resp);
            return;
        }
        new UserService().updateUserPassword(user.getUserId(),password);
        System.out.println("成功更换密码!");
        req.getSession().setAttribute("userId",otherId);
        req.getSession().setAttribute("password",password);
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
        return;
    }
}
