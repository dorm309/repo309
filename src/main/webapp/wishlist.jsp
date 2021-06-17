<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 2021/5/24
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.WishlistDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="header.jsp">
        <jsp:param name="header_info" value="愿望单"/>
    </jsp:include>

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
        <h2>${sessionScope.loginUser.username}的收藏夹</h2>
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
        <c:forEach items="<%=new WishlistDAO().retrieve(request)%>" var="item">
            <c:if test="${item.id == sessionScope.loginUser.uid}">
                <tr>
                    <td>
                        <a style="display: block;" href="item.jsp" id="${item.products.cid}" class="getCommodityInfo">
                            <h3 class="title">${item.products.name}</h3>
                            <div style="color:  #b0b0b0;" class="desc">${item.products.description}</div>
                        </a>
                    </td>
                    <td><span class="num">${item.products.price}</span></td>
                    <td><span class="linkdel_wishlist" id="${item.products.cid}">取消收藏</span></td>
                    <!--点击会触发取消收藏事件，具体行为见底部js函数-->
                </tr>
            </c:if>
        </c:forEach>
        </tbody>

    </table>

</div>

<!-- 底部 -->
<jsp:include page="copyright.jsp">
    <jsp:param name="copyright" value="footer"/>
</jsp:include>

<script>
    //取消收藏事件
    $(".linkdel_wishlist").click(function () {
        console.log("取消收藏该商品")
        var cid = document.getElementById($(this).attr("id")).id
        //发送ajax请求
        $.ajax({
            url: "DeleteWishlistServlet",
            type: "get",
            data: {"cid": cid},
            dataType: "text",
            error: function () {
                alert("取消收藏失败，请重试！")
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
