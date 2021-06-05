package controller.user;

import dao.DBOperation;
import dao.UserDAO;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理修改密码逻辑
 */
public class UpdatePasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user_update = (User) session.getAttribute("loginUser");
        user_update.setPassword(request.getParameter("newPassword"));

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();

        DBOperation<User> userDB = new UserDAO();
        boolean flag = userDB.update(user_update, request);
        if (!flag)
            out.write("<script>alert('密码修改失败，请重试！'); window.location='login.jsp' </script>");

        out.write("<script>alert('密码修改成功，请重新登录'); window.location='login.jsp' </script>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
