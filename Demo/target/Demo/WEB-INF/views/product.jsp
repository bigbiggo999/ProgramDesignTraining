<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.cong.model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/6/5
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品管理页面</title>
</head>
<body>
<table border="2">
    <tr>
        <td>序号</td>
        <td>商品名称</td>
        <td>商品类型</td>
        <td>价格</td>
        <td>库存量</td>
    </tr>
    <c:forEach var="item" items="${productList}">
    <tr>
        <td>${item.id}</td>
        <td>${item.name}</td>
        <td>${item.type}</td>
        <td>${item.price}</td>
        <td>${item.inventory}</td>
    </tr>
    </c:forEach>
</table>
<<a href="${pageContext.request.contextPath}/product/add">新增商品信息</a>
</body>
</html>
