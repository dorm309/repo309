<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 2021/5/24
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="header.jsp">
        <jsp:param name="header_info" value="登录"/>
    </jsp:include>
    <link rel="stylesheet" href="plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/css.css">
</head>
<body>
<div class="login-header">
    <div class="logo"></div>
    <div class="login-logo">用户登录</div>
</div>
<div class="bg" style="position: absolute; width: 100%;height: 600px; background-image:url(image/bg.png) ;"></div>
<div class="contain">
    <div class="login">
        <div class="title" style="margin-top: 15px; text-align: center; font-size: 30px;">登录</div>
        <form action="login" method="post" class="form-horizontal">
            <%--获取LoginServlet响应中的cookie值--%>
            <c:set var="remember_username" value="${cookie['rememberUsername']}"/>
            <c:set var="remember_password" value="${cookie['rememberPassword']}"/>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputEmail3" name="username" placeholder="请输入账号"
                           value="${remember_username.value}">
                </div>
            </div>
            <div class="form-group" style="margin-top: 20px;">
                <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword3" name="password" placeholder="请输入密码"
                           value="${remember_password.value}">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="remember" value="yes"
                            ${cookie==null?"":"checked"}> 记住密码
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10 ">
                    <button type="submit" class="btn btn-default login-btn">登录</button>
                </div>
            </div>
        </form>
        <span>
                <a href="#">忘记密码</a>
                  <a href="regist.jsp">免费注册</a>
              </span>
    </div>
</div>

<!-- 底部 -->
<jsp:include page="copyright.jsp">
    <jsp:param name="copyright" value="footer"/>
</jsp:include>

</body>
</html>

