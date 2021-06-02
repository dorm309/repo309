<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 2021/5/24
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<%
    //设置记住密码
    Cookie[] cookies = request.getCookies();
    Cookie remember_username = null;
    Cookie remember_password = null;

    if (cookies != null && cookies.length > 0) {
        for (Cookie c : cookies) {
            if (c.getName().equals("rememberUsername"))
                remember_username = c;
            if (c.getName().equals("rememberPassword"))
                remember_password = c;
        }
    }
%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>西柚有余|登录</title>
    <link rel="stylesheet" href="../plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/css.css">

</head>
<body>
<div class="login-header">
    <div class="logo"></div>
    <div class="login-logo">用户登录</div>
</div>
<div class="bg" style="position: absolute; width: 100%;height: 600px; background-image:url(../image/bg.png) ;"></div>
<div class="contain">
    <div class="login">
        <div class="title" style="margin-top: 15px; text-align: center; font-size: 30px;">登录</div>
        <form action="login.servlet" method="post" class="form-horizontal">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputEmail3" name="username" placeholder="请输入账号"
                           value="<%=remember_username==null?"":remember_username.getValue()%>">
                </div>
            </div>
            <div class="form-group" style="margin-top: 20px;">
                <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword3" name="password" placeholder="请输入密码"
                           value="<%=remember_password==null?"":remember_password.getValue()%>">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="remember" value="yes"
                                <%=cookies==null?"":"checked"%>> 记住密码
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
<div class="footer">
    <div class="w">
        <div class="copyright" style="float: left; margin-top: 15px; font-size: 12px ;color: #7b7b7b;">
            <h4>关于我们</h4> 西柚有余倾力打造的校园二手信息共享台。<br/>
            师生将商品上传到 该 平台，用户可以选择自己需要的产品，平台免费使用。
        </div>
        <div class="links" style="float: right;margin-top: 15px; color: #7b7b7b; font-size: 12px;">
            <h4>友情链接</h4>
            <a href="#">西南石油大学</a>
            <a href="#">学工系统</a>
            <a href="#">四川省教育厅</a>
            <a href="#">教务处</a>

        </div>
    </div>
</div>

</body>
</html>

