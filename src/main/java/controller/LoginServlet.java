package controller;

import dao.UserDAO;
import entity.User;
import util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        DBUtil database = new DBUtil();

        //比对数据库中信息
        int uid = 1;

        User user = new UserDAO().retrieve(uid).get(0);
        String userName_dao = user.getUsername();
        String password_dao = user.getPassword();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();
        if ((userName.equals(userName_dao) && (password.equals(password_dao))))
            out.write("<script>alert('登录成功'); window.location='index.jsp' </script>");
        else if (userName.equals(userName_dao))
            out.write("<script>alert('登录名或密码错误'); window.location='login.jsp' </script>");
        else
            out.write("<script>alert('未注册，请先注册'); window.location='regist.jsp' </script>");
        out.flush();
        out.close();
    }
}
