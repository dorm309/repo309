<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 2021/5/24
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="dao.WishlistDAO" %>
<%@ page import="entity.Wishlist" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.User" %>
<%@ page import="entity.Commodity" %>
<%@ page import="dao.CommodityDAO" %>
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
        <%
            User user = (User) session.getAttribute("loginUser");
        %>
        <h2><%=user.getUsername()%>的收藏夹</h2>
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
        <%
            //愿望单-收藏夹
            WishlistDAO wishlistDB = new WishlistDAO();
            List<Wishlist> wishlist = wishlistDB.retrieve(request);
            for (Wishlist w : wishlist) {
                if (w.getId() == user.getUid()) {
                    Commodity commodity = new CommodityDAO().get(w.getCid(), request);
        %>
        <tr>
            <td>
                <a style="display: block;" href="item.jsp" id="<%=commodity.getCid()%>" class="getCommodityInfo">
                    <h3 class="title" id="<%=commodity.getCid()%>"><%=commodity.getName()%>
                    </h3>
                    <div style="color:  #b0b0b0;" class="desc"><%=commodity.getDescription()%>
                    </div>
                </a>
            </td>
            <td><span class="num"><%=commodity.getPrice()%></span></td>
            <td><span class="linkdel_wishlist" id="<%=-commodity.getCid()%>">取消收藏</span></td>
            <!--点击会触发取消收藏事件，具体行为见底部js函数-->
        </tr>
        <%
                }
            }
        %>
        </tbody>

    </table>

</div>
<!-- 底部 -->
<div class="footer">
    <jsp:include page="copyright.jsp"></jsp:include>
</div>

<script>
    //取消收藏事件
    $(".linkdel_wishlist").click(function () {
        console.log("取消收藏该商品")
        var cid = document.getElementById(Math.abs($(this).attr("id"))).id
        //发送ajax请求
        $.ajax({
            url: "DeleteWishlistServlet",
            type: "get",
            data: {"cid": cid},
            dataType: "text",
            error: function () {
                alert(cid + "取消收藏失败，请重试！")
            },
            success: function () {
                alert("此商品取消收藏成功")
                parent.location.reload()
            },
        });
    });

    //获取商品信息页面
    $(".getCommodityInfo").click(function () {
        console.log("获取该商品信息页面")
        var cid = document.getElementById($(this).attr("id")).id
        //发送ajax请求
        $.ajax({
            url: "GetCommodityServlet",
            type: "get",
            data: {"cid": cid},
            dataType: "text",
        });
    });
</script>

</body>
</html>
