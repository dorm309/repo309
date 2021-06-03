package controller;

import dao.DBOperation;
import dao.UserDAO;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理登录逻辑
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取用户输入信息
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //比对数据库信息
        DBOperation<User> userDB = new UserDAO();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();

        //处理异常输入
        if (username.equals(""))
            out.write("<script>alert('用户名不能为空！'); window.location='login.jsp' </script>");
        if (userDB.get(username) == null)
            out.write("<script>alert('未注册，请先注册'); window.location='regist.jsp' </script>");

        User user = userDB.get(username);
        String username_dao = user.getUsername();
        String password_dao = user.getPassword();

        /*
            记住密码功能:
            1）默认勾选记住密码复选框
            2）仅当登录成功时，才记住密码，自登录起为期14天
            3）用户取消选中记住密码后，忘记密码
         */
        String remember = request.getParameter("remember");
        Cookie cookie_username = new Cookie("rememberUsername", username);
        Cookie cookie_password = new Cookie("rememberPassword", password);

        int maxAge = 60 * 60 * 24 * 14;
        cookie_username.setPath("/");
        cookie_password.setPath("/");

        if (remember != null && remember.equals("yes")) { //前一条件解决复选框不选中时，remember为空的异常
            cookie_username.setMaxAge(maxAge);
            cookie_password.setMaxAge(maxAge);
        } else {
            cookie_username.setMaxAge(0);
            cookie_password.setMaxAge(0);
        }

        //根据匹配结果跳转对应页面
        if ((username.equals(username_dao) && (password.equals(password_dao)))) {
            response.addCookie(cookie_username);
            response.addCookie(cookie_password);

            //配置登录用户个人信息
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user);

            out.write("<script>alert('登录成功'); window.location='index.jsp' </script>");
        } else
            out.write("<script>alert('登录名或密码错误，请重试'); window.location='login.jsp' </script>");

        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
