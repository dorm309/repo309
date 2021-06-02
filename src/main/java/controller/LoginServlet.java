package controller;

import com.mysql.jdbc.StringUtils;
import dao.UserDAO;
import entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 处理登录逻辑
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //比对数据库中信息
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        UserDAO userDAO = new UserDAO();
        PrintWriter out = response.getWriter();
        if (!userDAO.isExist(username)) {
            out.write("<script>alert('用户名不能为空！'); window.location='login.jsp' </script>");
        }

        //验证登录信息
        User user = userDAO.get(username);
        String username_dao = user.getUsername();
        String password_dao = user.getPassword();

        if ((username.equals(username_dao) && (password.equals(password_dao)))) {
            out.write("<script>alert('登录成功'); window.location='index.jsp' </script>");
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", new User(username, password));
        } else if (username.equals(username_dao))
            out.write("<script>alert('登录名或密码错误，请重试'); window.location='login.jsp' </script>");
        else
            out.write("<script>alert('未注册，请先注册'); window.location='regist.jsp' </script>");

        out.flush();
        out.close();
    }
}
