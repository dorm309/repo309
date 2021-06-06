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

        DBOperation<User> userDB = new UserDAO();
        PrintWriter out = response.getWriter();
        boolean flag = userDB.update(user_update, request);
        if (!flag)
            out.write("<script>alert('密码修改失败，请重试！'); window.location='login.jsp' </script>");

        //销毁本次用户登录令牌
        session.removeAttribute("loginUser");

        out.write("<script>alert('密码修改成功，正在前往登录页重新登录...'); window.location='login.jsp' </script>");

        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
