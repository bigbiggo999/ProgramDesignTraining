<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>inputString</title>
</head>
<body>
<%

    if(session.getAttribute("username")==null||session.getAttribute("password")==null){
        out.print("<script>location.href='login.jsp';</script>");
    }

%>

<form action="computer.jsp" method="post" name="form">
    <input type="text" name="string" size="50">
    <input type="submit" name="submit" value="提交">
    <input type="reset" name="reset" value="重置">
</form>

</body>
</html>
