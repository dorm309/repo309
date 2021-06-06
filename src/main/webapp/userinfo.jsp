<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 2021/5/24
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" import="entity.User" %>
<%@ page import="dao.DBOperation" %>
<%@ page import="entity.Commodity" %>
<%@ page import="dao.CommodityDAO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人中心</title>
    <link rel="stylesheet" href="./plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/css.css">
</head>
<body style="background-color: #f7f7f7;">
<!-- 导航栏 -->
<div class="userinfo-nav">
    <div class="regist-layout">
        <span><a href="index.jsp" style="line-height: 35px;">返回首页</a></span>
    </div>
</div>

<div class=" userinfo-box w clearfix">
    <!-- 左侧导航栏 -->
    <div class="userinfo-left">
        <ul style="list-style: none outside none; margin: 0; padding: 0;">
            <li><a id="info" class="active" href="#">个人信息</a></li>
            <li><a id="my-product" href="#">我的发布</a></li>
            <li><a id="modify" href="#">修改信息</a></li>
            <li><a id="my-purchase" href="#">我的订单</a></li>
        </ul>
    </div>
    <!-- 中间内容 -->
    <div style=" float:left ;margin-left:15px; ">
        <h2>个人中心</h2>
    </div>
    <div class="main" style="background-color: #fff;  border-radius: 8px;
        width:785px;
        float: right; margin-top: 15px; margin-left: 15px;">

        <!-- 展示个人信息 -->
        <div class="info" style="padding: 20px;">
            <%
                User user = (User) session.getAttribute("loginUser");
            %>
            <h2>账号</h2>
            <div class="name-detail" style=" border-bottom:1px solid #ddd;;padding-bottom: 20px;font-size: 20px;">
                <span><%=user.getUsername()%></span>
            </div>
            <h2>密码</h2>
            <div class="password-detail" style=" border-bottom:1px solid #ddd;;padding-bottom: 20px;font-size: 20px;">
                <span><%=user.getPassword()%></span></div>
        </div>

        <!-- 展示修改密码 -->
        <div class="modify-info" style="padding: 20px;display: none; ">
            <!-- 验证不通过则阻止向服务器提交数据 -->
            <form action="updatePassword" method="post" onsubmit="return verify()">
                <h3>输入新密码</h3>
                <div class="name-detail" style=" border-bottom:1px solid #ddd;;padding-bottom: 20px;font-size: 20px;">
                    <input class="password1" name="newPassword" type="password">
                </div>
                <h3>再次输入</h3>
                <div class="password-detail"
                     style=" border-bottom:1px solid #ddd;;padding-bottom: 20px;font-size: 20px;">
                    <input class="password2" type="password">
                </div>
                <div class="submit" style=" padding-top: 20px;font-size: 20px;">
                    <input class="btn btn-default" type="submit" value="提交">
                </div>
            </form>
        </div>

        <!-- 展示我发布的商品 -->
        <div class="my-product" style="padding: 20px;display: none; ">
            <table class="tb">
                <thead>
                <tr>
                    <th style="width: 60%;">商品名</th>
                    <th style="width: 20%;">价格</th>
                    <th style="width: 20%;">操作</th>
                </tr>
                </thead>
                <tbody>
                <%
                    //个人中心-我的发布
                    DBOperation<Commodity> commodityDB = new CommodityDAO();
                    List<Commodity> launched_commodities_list = commodityDB.retrieve(request);
                    user = (User) session.getAttribute("loginUser");
                    for (Commodity c : launched_commodities_list) {
                        if (c.getUid() == user.getUid()) {
                %>
                <tr>
                    <td><h4 class="commodityName" id="<%=c.getCid()%>"><%=c.getName()%>
                    </h4></td>
                    <td><span class="num"> <%=c.getPrice()%> </span></td>
                    <td><span class="linkdel" id="<%=-c.getCid()%>">删除</span></td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>

            </table>

        </div>

        <!-- 展示我购买的商品 -->
        <div class="my-purchase" style="padding: 20px;display: none; ">
            <table class="tb">
                <thead>
                <tr>
                    <th style="width: 60%;">订单名</th>
                    <th style="width: 20%;">价格</th>
                    <th style="width: 20%;">操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><h4 class="title">自行车</h4></td>
                    <td><span class="num">300元</span></td>
                    <td><span class="linkdel">删除</span></td>   <!--点击会触发删除事件，具体行为见底部js函数-->
                </tr>
                <tr>
                    <td><h4 class="title">二手教材</h4></td>
                    <td><span class="num">10元</span></td>
                    <td><span class="linkdel">删除</span></td>   <!--点击会触发删除事件，具体行为见底部js函数-->
                </tr>

                <tr>
                    <td><h4 class="title">台灯</h4></td>
                    <td><span class="num">50元</span></td>
                    <td><span class="linkdel">删除</span></td>   <!--点击会触发删除事件，具体行为见底部js函数-->
                </tr>

                </tbody>
            </table>
        </div>

    </div>
</div>

<!-- 底部 -->
<jsp:include page="copyright.jsp">
    <jsp:param name="copyright" value="footer"/>
</jsp:include>

</body>
<script type="text/javascript" src="./plugins/jQuery/jquery-2.2.3.min.js"></script>
<script>
    //删除发布事件
    $(".linkdel").click(function () {
        console.log("删除该商品")
        var cid = document.getElementById(Math.abs($(this).attr("id"))).id
        //发送ajax请求
        $.ajax({
            url: "DeleteCommodityServlet",
            type: "get",
            data: {"cid": cid},
            dataType: "text",
            error: function () {
                alert("删除失败，请重试！")
            },
            success: function () {
                alert("此商品发布记录删除成功")
                parent.location.reload()
            },
        });
    });

    //页面切换
    $("#info").click(
        function () {
            console.log("info");
            $("#modify").removeClass("pactive")
            $("#my-product").removeClass("pactive")
            $(".modify-info").css('display', 'none')
            $(".my-product").css('display', 'none')
            $(".info").css('display', 'block')
            $("#info").addClass("pactive")
            $("#my-purchase").removeClass("pactive")
            $(".my-purchase").css('display', 'none')
        }
    );
    $("#modify").click(
        function () {
            console.log("modify");
            $("#info").removeClass("pactive")
            $("#my-product").removeClass("pactive")
            $(".info").css('display', 'none')
            $(".my-product").css('display', 'none')
            $(".modify-info").css('display', 'block')
            $("#modify").addClass("pactive")
            $("#my-purchase").removeClass("pactive")
            $(".my-purchase").css('display', 'none')
        });
    $("#my-product").click(
        function () {
            console.log("my-product");
            $("#info").removeClass("pactive")
            $("#modify").removeClass("pactive")
            $(".info").css('display', 'none')
            $(".modify-info").css('display', 'none')
            $(".my-product").css('display', 'block')
            $("#my-product").addClass("pactive")
            $("#my-purchase").removeClass("pactive")
            $(".my-purchase").css('display', 'none')
        });
    $("#my-purchase").click(
        function () {
            console.log("my-purchase");
            $("#info").removeClass("pactive")
            $("#modify").removeClass("pactive")
            $("#my-product").removeClass("pactive")
            $(".info").css('display', 'none')
            $(".modify-info").css('display', 'none')
            $(".my-product").css('display', 'none')
            $("#my-purchase").addClass("pactive")
            $(".my-purchase").css('display', 'block')
        });

    //验证密码
    function verify() {
        var a = $(".password1").val();
        //console.log(a=='')
        var b = $(".password2").val();
        //console.log(b)
        if (a == '' || a != b) {
            alert("输入有误，请重试！")
            return false;
        }
    }
</script>
</html>
