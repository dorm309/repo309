package controller;

import com.mysql.jdbc.StringUtils;
import dao.UserDAO;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");


//        //记住密码
//        String rememberMe = request.getParameter("rememberMe");
//        if (!StringUtils.isNullOrEmpty(rememberMe)) {
//            //将用户信息保存到Cookie中
//            Cookie nameCookie = new Cookie("name", name);
//            nameCookie.setPath("/");
//            nameCookie.setMaxAge(60 * 60 * 24);
//
//            Cookie rememberMeCookie = new Cookie("rememberMe", rememberMe);
//            rememberMeCookie.setMaxAge(60 * 60 * 24);
//            response.addCookie(nameCookie);
//            response.addCookie(rememberMeCookie);
//        } else {
//            //将用户信息从Cookie中移除
//            Cookie[] cookies = request.getCookies();
//            for (Cookie cookie : cookies) {
//                if ("name".equals(cookie.getName())  || "rememberMe".equals(cookie.getName())) {
//                    cookie.setMaxAge(0);
//                    response.addCookie(cookie);
//                }
//            }
//        }

        //比对数据库中信息
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        UserDAO userDAO = new UserDAO();
        PrintWriter out = response.getWriter();
        if (!userDAO.isExist(username)) {
            out.write("<script>alert('用户名不能为空！'); window.location='login.jsp' </script>");
        }

        User user = userDAO.get(username);
        String username_dao = user.getUsername();
        System.out.println(username_dao);
        String password_dao = user.getPassword();

        if ((username.equals(username_dao) && (password.equals(password_dao))))
            out.write("<script>alert('登录成功'); window.location='index.jsp' </script>");
        else if (username.equals(username_dao))
            out.write("<script>alert('登录名或密码错误，请重试'); window.location='login.jsp' </script>");
        else
            out.write("<script>alert('未注册，请先注册'); window.location='regist.jsp' </script>");

        out.flush();
        out.close();
    }
}
