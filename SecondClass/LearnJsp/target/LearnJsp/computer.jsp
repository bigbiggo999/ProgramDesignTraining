<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>computer</title>
</head>
<body>

<%

    if(session.getAttribute("username")==null){
        out.print("<script>location.href='login.jsp';</script>");
        return;
    }

%>
<%

    String str = request.getParameter("string");
    if(str==null){
        out.print("<script>location.href='inputString.jsp';</script>");
        return;
    }
    out.println(str.length());
%>
</body>
</html>
