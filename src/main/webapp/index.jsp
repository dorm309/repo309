<%@ page import="util.DBUtil" %>
<html>
<body>
<%
    // 初始化数据库
    new DBUtil();
    // 跳转登录页面
    response.sendRedirect("jsp/login.jsp");
%>
</body>
</html>
完成登录和注册servlet，