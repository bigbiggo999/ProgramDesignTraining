<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/6/5
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加商品类型</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/type/add" >
    编号:<input type="text" name="id" /><br/>
    类型:<input type="text" name="name"/><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
