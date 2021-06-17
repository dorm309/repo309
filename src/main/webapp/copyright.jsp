<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 2021/6/3
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<body>
<div class="<%=request.getParameter("copyright")%>">
    <div class="w">
        <div class="copyright" style="float: left; margin-top: 15px; font-size: 12px ;color: #7b7b7b;">
            <h4>关于我们</h4> 西柚有余——倾力打造的校园二手信息共享平台<br/>
            师生将商品上传至本平台，用户可以选择自己需要的产品，平台免费使用。
            <c:set var="name" value="在线996大队 @ copyright 2021"/>
            <h6>${name}</h6>
        </div>
        <div class="links" style="float: right;margin-top: 15px; color: #7b7b7b; font-size: 12px;">
            <h4>友情链接</h4>
            <%--欢迎其他小组合作--%>
            <a href="https://www.swpu.edu.cn/">西南石油大学</a>
            <a href="http://xg.swpu.edu.cn/userhall/smart/student">学工系统</a>
            <a href="http://edu.sc.gov.cn/">四川省教育厅</a>
            <a href="https://www.swpu.edu.cn/dean/">教务处</a>
        </div>
    </div>
</div>
</body>
</html>
