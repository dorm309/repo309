package controller;

import dao.UserDAO;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //保存账密到数据库
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        UserDAO userDAO = new UserDAO();
        PrintWriter out = response.getWriter();
        if (userDAO.isExist(username)) {
            out.write("<script>alert('用户名已被使用，请重试！'); window.location='regist.jsp' </script>");
        }

        userDAO.create(new User(username, password));
        out.write("<script>alert('注册成功，正在前往登录页面..'); window.location='login.jsp' </script>");

        out.flush();
        out.close();
    }
}
