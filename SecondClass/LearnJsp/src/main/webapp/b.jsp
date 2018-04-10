<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>b</title>
</head>
<jsp:useBean id="rectangle" class="com.cong.entity.Rectangle"/>
<jsp:setProperty name="rectangle" property="width"/>
<jsp:setProperty name="rectangle" property="length"/>
<body>
<p>面积为:<jsp:getProperty name="rectangle" property="area"/></p>
</body>
</html>
