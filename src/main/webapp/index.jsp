<%@ page import="util.DBUtil" %>
<%
    // 初始化数据库
    if (DBUtil.getCon() == null)
        new DBUtil();
    // 跳转登录页面
    response.sendRedirect("jsp/login.jsp");
%>
