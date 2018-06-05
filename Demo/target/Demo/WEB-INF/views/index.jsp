<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/WEB-INF/statics/css/test.css"/> "/>
</head>
<body>

<h1>hello <%out.print(session.getAttribute("username"));%></h1>
<h4><a href="${pageContext.request.contextPath}/exit">注销</a></h4>
<table width="100%" height="700" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="15%" height="100%" valign="top">
            <a href="/type/list" target="mainFrame">商品类型管理页面</a><br/>
            <a href="/product/list" target="mainFrame">商品页面</a>
        </td>
        <td width="80%" valign="top">
            <iframe src="${pageContext.request.contextPath}/type/list" name="mainFrame" frameborder="2" height="800" width="1000" ></iframe>
        </td>
    </tr>
</table>


</body>
</html>
