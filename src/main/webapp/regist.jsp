<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 2021/5/24
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="header.jsp">
        <jsp:param name="header_info" value="注册"/>
    </jsp:include>
    <script type="text/javascript" src="plugins/jQuery/jquery-2.2.3.min.js"></script>
</head>
<body>
<!-- 顶部导航栏 -->
<div class="regist-nav">
    <div class="regist-layout">
        <span><a href="login.jsp" style="line-height: 35px;">返回登录</a></span>
    </div>
</div>
<!-- 主页面 -->
<div class="regist-layout">
    <div class="header">
        <div class="logo">
        </div>
        <div class="regist-logo">用户注册</div>
    </div>
    <div class="regist">
        <script type="text/javascript" src="scripts/verify.js"></script>
        <form action="register" method="post" class="form-horizontal"
              style="padding-right:145px;padding-left: 145px;" onsubmit="return verify()">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputEmail3" name="username" style="width: 300px;"
                           placeholder="请输入账号">
                </div>
            </div>
            <div class="form-group" style="margin-top: 20px;">
                <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword3" name="password"
                           style="width: 300px;" placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group" style="margin-top: 20px;">
                <label for="inputPassword4" class="col-sm-2 control-label">确认密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword4" style="width: 300px; "
                           placeholder="请再次输入密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10 ">
                    <button type="submit" class="btn btn-default regist-btn">注册</button>
                </div>
            </div>
        </form>
    </div>
</div>

<!-- 底部 -->
<jsp:include page="copyright.jsp">
    <jsp:param name="copyright" value="footer"/>
</jsp:include>

</body>
</html>
