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
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>收藏夹</title>
    <script type="text/javascript" src="plugins/jQuery/jquery-2.2.3.min.js"></script>
    <link rel="stylesheet" href="plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/css.css">
</head>

<body style="background-color: #f7f7f7;">
<!-- 顶部导航栏 -->
<div class="regist-nav">
    <div class="regist-layout">
        <span><a href="index.jsp" style="line-height: 35px;">返回首页</a></span>
    </div>
</div>

<!-- 收藏夹列表 -->
<div class="container item-w">
    <div style="margin-left:30px; ">
        <h2>收藏夹</h2>
    </div>
        <table class="tb">
            <thead>
            <tr>
                <th style="width: 60%;">商品名</th>
                <th style="width: 20%;">价格</th>
                <th style="width: 20%;">操作</th>

            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <a style="display: block;" href="item.jsp">
                        <h3 class="title">这是商品名称</h3>
                        <div style="color:  #b0b0b0;" class="desc">这是商品的描述</div>
                    </a>
                </td>
                <td><span class="num">99元</span></td>
                <td><span class="linkdel">取消收藏</span></td>   <!--点击会触发取消收藏事件，具体行为见底部js函数-->
            </tr>
            <tr>
                <td>
                    <a style="display: block;" href="item.jsp">
                        <h3 class="title">这是商品名称</h3>
                        <div style="color:  #b0b0b0;" class="desc">这是商品的描述</div>
                    </a>
                </td>
                <td><span class="num">99元</span></td>
                <td><span class="linkdel">取消收藏</span></td>   <!--点击会触发取消收藏事件，具体行为见底部js函数-->
            </tr>

            </tbody>

        </table>


</div>
<!-- 底部 -->
<div class="footer">
    <jsp:include page="copyright.jsp"></jsp:include>
</div>

<script>
    $(".linkdel").click(function () {
        console.log("取消收藏该商品")
        //获取取消商品需要的主键


        //发送ajax请求
        //需要后端提供接口
    });
</script>

</body>
</html>
