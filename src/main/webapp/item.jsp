<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 2021/5/24
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品详情</title>
    <script type="text/javascript" src="plugins/jQuery/jquery-2.2.3.min.js"></script>
    <link rel="stylesheet" href="plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/css.css">
</head>
<body>
<!-- 顶部导航栏 -->
<div class="regist-nav">
    <div class="regist-layout">
        <span><a href="index.jsp" style="line-height: 35px;">返回首页</a></span>
    </div>
</div>
<!-- 中间内容 -->
<div class="item-box item-w clearfix">
    <div class="review">
        <div class="pic-left"><img
                src="image/commodity/${sessionScope.commodity.commodityImages}.jpg" width="560"
                height="560" alt=""></div>
        <div class="info">
            <div class="title"><h2>${sessionScope.commodity.name}</h2></div>
            <div class="desc">${sessionScope.commodity.description}</div>
            <div class="price"><span class="num">${sessionScope.commodity.price}</span><span>元</span></div>
            <div class="user"><span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span> 联系方式：<span
                    id="phonenum">${sessionScope.commodity.contact}</span></div>
            <hr>
            <form class="want">
                <!-- 点击按钮会触发收藏事件，具体见底部js函数 -->
                <button type="button" class="btn btn-success" id="${sessionScope.commodity.cid}">
                    <span class="glyphicon glyphicon-heart" aria-hidden="true"></span> 收藏
                </button>
            </form>
        </div>
    </div>
</div>

<!-- 底部 -->
<jsp:include page="copyright.jsp">
    <jsp:param name="copyright" value="footer"/>
</jsp:include>

<script>
    //收藏事件
    $(".btn-success").click(function () {
        console.log("收藏事件触发了")
        var cid = document.getElementById($(this).attr("id")).id
        //发送ajax请求
        $.ajax({
            url: "AddWishlistServlet",
            type: "get",
            data: {"cid": cid},
            dataType: "text",
            success: function (data) {
                if (data == "true")
                    alert("该商品已在愿望单中")
                else
                    alert("加入愿望单成功")
            }
        });
    });
</script>
</body>
</html>
