<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/4/17
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h2>登录</h2>
<form action="login.do?op=login" method="post">
    用户名:<input type="text" name="username" >
    密码:<input type="password" name="password">
    <input type="submit" value="提交">
</form>
</body>
</html>
