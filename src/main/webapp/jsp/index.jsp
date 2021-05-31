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
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>西柚有余</title>
    <link rel="stylesheet" href="../plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="../plugins/jQuery/jquery-2.2.3.min.js" type="text/javascript"></script>
    <script src="../plugins/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="../plugins/layui-v2.6.7/layui/css/layui.css">
    <script src="../plugins/layui-v2.6.7/layui/layui.js"></script>

    <link rel="stylesheet" href="../css/css.css"


</head>
<body style="background-color: #f5f5f5;">
<!-- header部分 -->
<div class="index-header index-w">
    <div class="index-logo">
    </div>
    <div class="index-nav">
        <ul>
            <li><a href="javascript:add()">发布</a></li>
            <li><a href="wishlist.jsp">收藏夹</a></li>
            <li><a href="#">待定功能</a></li>
        </ul>
    </div>
    <div class="search">
        <input type="text" placeholder="输入关键词" id="keyword">
        <!-- 点击搜索按钮触发事件，详细内容见底部js函数 -->
        <button type="button" id="search-btn"></button>
    </div>
    <div class="user" style="float: right;margin-right: 5px; height: 42px;font-size: 18px; ">
        <a style="display: block ;line-height: 42px;" href="userinfo.jsp">个人中心</a>
    </div>
</div>
<!-- banner部分 -->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="../image/ban1.png" alt="...">
            <div class="carousel-caption">
                ...
            </div>
        </div>
        <div class="item">
            <img src="../image/ban2.png" alt="...">
            <div class="carousel-caption">
                ...
            </div>
        </div>
        ...
        <div class="item">
            <img src="../image/ban3.png" alt="...">
            <div class="carousel-caption">
                ...
            </div>
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<!-- 商品展示 -->
<div class="box index-w ">
    <div class="bhd">
        <h3>精品推荐</h3>
        <a href="#">查看更多</a>
    </div>
    <div class="bbd ">
        <ul class="clearfix">
            <li class="item">
                <a href="item.jsp">
                    <img src="https://img.alicdn.com/imgextra/i2/14219353/O1CN01PuAfdi2Ixj0eYycBd_!!0-saturn_solar.jpg_468x468q75.jpg_.webp"
                         width="228" height="151" alt="">
                    <h3 class="title">女装</h3>
                    <p class="desc">全新女装，仅仅试穿</p>
                    <p class="price"><span class="num">100</span> <span>元</span></p>
                </a>
            </li>
            <li class="item">
                <a href="#">
                    <img src="//cdn.cnbj0.fds.api.mi-img.com/b2c-miapp-a1/T1r_x_BgLT1RXrhCrK.jpg?thumb=1&w=250&h=250"
                         width="228" height="151" alt="">
                    <h3 class="title">小米平衡车</h3>
                    <p class="desc">九成新，充电二十次</p>
                    <p class="price"><span class="num">900</span> <span>元</span></p>
                </a>
            </li>
            <li class="item">
                <a href="#">
                    <img src="//cdn.cnbj1.fds.api.mi-img.com/mi-mall/9eb0178e3bfeb7d170edd641fb4be4bc.jpg?thumb=1&w=250&h=250&f=webp&q=90"
                         width="228" height="151" alt="">
                    <h3 class="title">女装</h3>
                    <p class="desc">全新女装，仅仅试穿</p>
                    <p class="price"><span class="num">100</span> <span>元</span></p>
                </a>
            </li>
            <li class="item">
                <a href="#">
                    <img src="//cdn.cnbj1.fds.api.mi-img.com/mi-mall/f8fde8a877fd4b12ad88119d9b6bc061.jpg?thumb=1&w=250&h=250&f=webp&q=90"
                         width="228" height="151" alt="">
                    <h3 class="title">女装</h3>
                    <p class="desc">全新女装，仅仅试穿</p>
                    <p class="price"><span class="num">100</span> <span>元</span></p>
                </a>
            </li>
            <li class="item">
                <a href="#">
                    <img src="../image/product.png" width="228" height="151" alt="">
                    <h3 class="title">女装</h3>
                    <p class="desc">全新女装，仅仅试穿</p>
                    <p class="price"><span class="num">100</span> <span>元</span></p>
                </a>
            </li>
            <li class="item">
                <a href="#">
                    <img src="//gw.alicdn.com/bao/uploaded/i1/751688154/TB1s58pfoOWBKNjSZKzXXXfWFXa_!!751688154-0-item_pic.jpg"
                         width="228" height="151" alt="">
                    <h3 class="title">女装</h3>
                    <p class="desc">全新女装，仅仅试穿</p>
                    <p class="price"><span class="num">100</span> <span>元</span></p>
                </a>
            </li>
            <li class="item">
                <a href="#">
                    <img src="//cdn.cnbj1.fds.api.mi-img.com/mi-mall/f8fde8a877fd4b12ad88119d9b6bc061.jpg?thumb=1&w=250&h=250&f=webp&q=90"
                         width="228" height="151" alt="">
                    <h3 class="title">女装</h3>
                    <p class="desc">全新女装，仅仅试穿</p>
                    <p class="price"><span class="num">100</span> <span>元</span></p>
                </a>
            </li>
            <li class="item">
                <a href="#">
                    <img src="//gw.alicdn.com/bao/uploaded/i1/757548275/TB1CfGRekfb_uJkSne1XXbE4XXa_!!0-item_pic.jpg"
                         width="228" height="151" alt="">
                    <h3 class="title">女装</h3>
                    <p class="desc">全新女装，仅仅试穿</p>
                    <p class="price"><span class="num">100</span> <span>元</span></p>
                </a>
            </li>
            <li class="item">
                <a href="#">
                    <img src="//gw.alicdn.com/bao/uploaded/i1/757548275/TB1CfGRekfb_uJkSne1XXbE4XXa_!!0-item_pic.jpg"
                         width="228" height="151" alt="">
                    <h3 class="title">女装</h3>
                    <p class="desc">全新女装，仅仅试穿</p>
                    <p class="price"><span class="num">100</span> <span>元</span></p>
                </a>
            </li>
            <li class="item">
                <a href="#">
                    <img src="//gw.alicdn.com/bao/uploaded/i1/751688154/TB1s58pfoOWBKNjSZKzXXXfWFXa_!!751688154-0-item_pic.jpg"
                         width="228" height="151" alt="">
                    <h3 class="title">女装</h3>
                    <p class="desc">全新女装，仅仅试穿</p>
                    <p class="price"><span class="num">100</span> <span>元</span></p>
                </a>
            </li>
        </ul>
    </div>
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

<script>
    // 搜索事件
    $("#search-btn").click(function () {
        var keyword = $("#keyword").val();
        console.log(keyword)
        //向服务器发送请求并携带参数keyword
//       $.ajax({
//                 //请求路径(服务器提供)
//                 url: "ajaxServ1et" ,
//                 type:"POST" , //请求方式.
// //请求参数
//                 //data: "username=jack&age=23" ,
//                 data: { "username" :"jack", "age" :23},//JSON形式
// //响应成功后的回调函数
//                 success:function (data){
//                 alert(data);
//                 }
//             });

    })


    function add() {
        var that = this;

        //多窗口模式，层叠置顶
        layer.open({
            type: 1 //此处以iframe举例
            , title: '发布信息'
            , area: ['800px', '500px']
            , shade: 0
            , maxmin: true
            , offset: 'auto' //居中
            , content: $('.content')
            , btn: '取消' //
            , yes: function () {
                layer.closeAll();
            }

        });
        //   $(".content").css('display',"block")
    }

</script>


</body>

<!-- 弹框内容 -->
<div class="content" style="display: none;">
    <!-- 表单 -->
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">商品名</label>
            <div class="layui-input-block">
                <input type="text" name="title" required lay-verify="required" placeholder="请输入商品名" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">价格</label>
            <div class="layui-input-block">
                <input type="text" name="price" required lay-verify="required" placeholder="请输入价格" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-block">
                <textarea name="desc" placeholder="请输入描述内容" class="layui-textarea"></textarea>
            </div>
        </div>
        <!-- 图片上传 -->
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" id="test1">
                    <i class="layui-icon">&#xe67c;</i>上传图片
                </button>
            </div>
        </div>
        <!-- 提交表单 -->
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>


<script>
    layui.use('upload', function () {
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            , url: '/upload/' //上传接口
            , done: function (res) {
                //上传完毕回调
            }
            , error: function () {
                //请求异常回调
            }
        });
    });
</script>

<script>
    //Demo
    layui.use('form', function () {
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</html>
