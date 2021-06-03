<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 2021/5/24
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品详情</title>
    <script type="text/javascript" src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
    <link rel="stylesheet" href="../plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/css.css">
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
                src="https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1550480620.30111865.jpg" width="560"
                height="560" alt=""></div>
        <div class="info">
            <div class="title"><h2>高速无线充套装</h2></div>
            <div class="desc"> 一般描述里面都要贴一些宝贝的详细照片 然后就是写一些宝贝的的提示一般描述里面都要贴一些宝贝的详细照片 然一般描述里面都要贴一些宝贝的详细照片 然后就是写一些宝贝的的提示
                比如说如果你那个东后就是写一些宝贝的的提示 比如说如果你那个东 比如说如果你那个东西有色差 你可以写如果买家介意有色差的请不拍 因为有的刁难的买家买了东西觉得不好会给你差评 所以一定要把自己的东西介绍好
            </div>
            <div class="price"><span class="num">99</span><span>元</span></div>
            <div class="user"><span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span> 联系方式：<span
                    id="phonenum">110</span></div>
            <hr>
            <form class="want" action="#">
                <!-- 点击按钮会触发收藏事件，具体见底部js函数 -->
                <button type="button" class="btn btn-success" id="want">
                    <span class="glyphicon glyphicon-heart" aria-hidden="true"></span> 收藏
                </button>
            </form>
        </div>
    </div>
</div>
<!-- 底部 -->
<div class="footer">
    <jsp:include page="copyright.jsp"></jsp:include>
</div>
<script>

    //收藏事件
    $("#want").click(function () {
        console.log("收藏事件触发了")
        //需要获取商品主键并向服务器发起请求
    })
</script>
.
</body>
</html>
