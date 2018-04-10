<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/4/8
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>b</title>
</head>
<jsp:useBean id="rectangle" class="com.cong.entity.Rectangle"/>
<jsp:setProperty name="rectangle" property="*"/>
<body>
<p>面积为:<jsp:getProperty name="rectangle" property="area"/></p>
</body>
</html>
