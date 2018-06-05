<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/6/5
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品信息</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/product/save" >
    编号:<input type="text" name="id" value="${product.id}" readonly/><br/>
    类型:<input type="text" name="type" value="${product.type}"/><br/>
    名称:<input type="text" name="name" value="${product.name}"/><br/>
    价格:<input type="text" name="price" value="${product.price}"/><br/>
    库存量:<input type="text" name="inventory" value="${product.inventory}"/><br/>
    <input type="submit" value="提交">
</form>

</body>
</html>
