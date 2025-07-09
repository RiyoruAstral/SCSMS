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
import java.io.IOException;
import java.util.Objects;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
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
        System.out.println(action);
        if (action == null) {
            System.out.println("no action!be careful!!!");
            // 重定向前确保响应未提交
            if (!resp.isCommitted()) {
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
            return;
        }

        switch (action) {
            case "loading":
//                System.out.println("loading");
                loading(req, resp);
                break;
            case "update":
                update(req, resp);
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

    private void loading(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new ServletUtil().findUserFromSession(req);
        System.out.println(user);
        req.setAttribute("user",user);

        req.getRequestDispatcher("/user.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String password = req.getParameter("Password");
        String rePassword = req.getParameter("rePassword");
        System.out.println(password + "  " + rePassword);
        if(Objects.equals(password, rePassword)){
            User user = new ServletUtil().findUserFromSession(req);
            int userId = user.getUserId();
            int i = new UserService().updateUserPassword(userId, password);
//            if(i > 0){
                String msg = "更改密码成功";
                System.out.println(msg);
                req.getSession().setAttribute("msg", msg);
                resp.sendRedirect("/UserServlet?action=loading");
                return;
//            }
        }
        String msg = "更改密码失败";
        System.out.println(msg);
        req.getSession().setAttribute("msg", msg);
        resp.sendRedirect("/UserServlet?action=loading");
    }
}
