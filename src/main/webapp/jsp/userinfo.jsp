<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 2021/5/24
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人中心</title>
    <link rel="stylesheet" href="../plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/css.css"
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
        </ul>
    </div>
    <!-- 中间内容 -->
    <div style=" float:left ;margin-left:15px; ">
        <h2>个人中心</h2>
    </div>

    <div class="main" style="background-color: #fff;  border-radius: 8px;
        box-shadow: 0px 1px 2px rgba(var(--dsw-base-rgb), 0.1);width:785px;
        float: right; margin-top: 15px; margin-left: 15px;">
        <!-- 展示个人信息 -->
        <div class="info" style="padding: 20px;">
            <h2>账号</h2>
            <div class="name-detail" style=" border-bottom:1px solid #ddd;;padding-bottom: 20px;font-size: 20px;"><span>三网通</span>
            </div>
            <h2>密码</h2>
            <div class="password-detail" style=" border-bottom:1px solid #ddd;;padding-bottom: 20px;font-size: 20px;">
                <span>123456</span></div>
        </div>
        <!-- 展示修改密码 -->
        <div class="modify-info" style="padding: 20px;display: none; ">
            <!-- 验证不通过则阻止向服务器提交数据 -->
            <form action="#" onsubmit="return verify()">
                <h2>输入新密码</h2>
                <div class="name-detail" style=" border-bottom:1px solid #ddd;;padding-bottom: 20px;font-size: 20px;">
                    <input class="password1" type="password">
                </div>
                <h2>再次输入</h2>
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
        <div class="my-product" style="padding: 20px;display: none ; ">
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
                    <td><h4 class="title">全新女装</h4></td>
                    <td><span class="num">99元</span></td>
                    <td><span class="linkdel">删除</span></td>   <!--点击会触发删除事件，具体行为见底部js函数-->
                </tr>
                <tr>
                    <td><h4 class="title">全新女装</h4></td>
                    <td><span class="num">99元</span></td>
                    <td><span class="linkdel">删除</span></td>   <!--点击会触发删除事件，具体行为见底部js函数-->
                </tr>

                </tbody>

            </table>

        </div>

    </div>
    <!-- 底部 -->
</div>
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
<script type="text/javascript" src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
<script>
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
            //向服务器发送ajax请求获取该页数据！！


        }
    );
    $("#modify").click(function () {
        console.log("modify");
        $("#info").removeClass("pactive")
        $("#my-product").removeClass("pactive")
        $(".info").css('display', 'none')
        $(".my-product").css('display', 'none')
        $(".modify-info").css('display', 'block')
        $("#modify").addClass("pactive")
        //向服务器发送ajax请求获取该页数据！！

    });
    $("#my-product").click(function () {
        console.log("my-product");
        $("#info").removeClass("pactive")
        $("#modify").removeClass("pactive")
        $(".info").css('display', 'none')
        $(".modify-info").css('display', 'none')
        $(".my-product").css('display', 'block')
        $("#my-product").addClass("pactive")
        //向服务器发送ajax请求获取该页数据！！

    })

    //  //验证密码
    function verify() {
        var a = $(".password1").val();
        //console.log(a=='')
        var b = $(".password2").val();
        //console.log(b)
        if (a == '' || a != b) {
            alert("输入有误！")
            return false;
        }
    }

    //  删除发布事件
    $(".linkdel").click(function () {
        console.log("删除该商品")
        //获取删除商品需要的主键


        //发送ajax请求
    });


</script>
</html>
