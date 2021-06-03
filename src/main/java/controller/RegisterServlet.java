package controller;

import dao.DBOperation;
import dao.UserDAO;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理注册逻辑
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setCharacterEncoding("utf-8");

        //保存账密到数据库
        DBOperation<User> userDB = new UserDAO();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();
        boolean isUsernameDuplicated = userDB.get(username) == null;
        if (!isUsernameDuplicated)
            out.write("<script>alert('用户名已被使用，请重试！'); window.location='regist.jsp' </script>");

        userDB.create(new User(username, password));
        out.write("<script>alert('注册成功，正在前往登录页面..'); window.location='login.jsp' </script>");

        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
