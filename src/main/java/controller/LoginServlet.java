package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        //比对数据库中信息
//        System.out.println("用户名 " + userName + " 密码 " + password);

        String result = "index.html";
        response.sendRedirect(result);
    }
}
