package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        //保存账密到数据库
//        System.out.println("用户名 " + userName + " 密码 " + password);

        String result = "login.html";
        response.sendRedirect(result);
    }
}
