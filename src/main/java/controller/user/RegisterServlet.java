package controller.user;

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

        //保存账密到数据库
        DBOperation<User> userDB = new UserDAO();
        PrintWriter out = response.getWriter();
        boolean isUsernameDuplicated = (userDB.get(username, request) == null);
        if (!isUsernameDuplicated)
            out.write("<script>alert('该用户名已被使用，请重试！'); window.location='regist.jsp' </script>");
        else {
            userDB.create(new User(username, password), request);
            out.write("<script>alert('注册成功，正在前往登录页面...'); window.location='login.jsp' </script>");
        }

        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
