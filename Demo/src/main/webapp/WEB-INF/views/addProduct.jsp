<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/6/5
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增商品信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/product/add" >
    编号:<input type="text" name="id" /><br/>
    类型:<input type="text" name="type"/><br/>
    名称:<input type="text" name="name"/><br/>
    价格:<input type="text" name="price"/><br/>
    库存量:<input type="text" name="inventory"/><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
