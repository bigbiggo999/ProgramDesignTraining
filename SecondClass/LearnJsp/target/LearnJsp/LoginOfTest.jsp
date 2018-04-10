<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginOfTest</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if(username!=null){
        if(username.equals("admin")&&password.equals("admin")){
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            out.print("<script>location.href='inputString.jsp';</script>");
        }else {
            out.print("<script>alert('输入用户名或密码错误,请重试');location.href='login.jsp';</script>");
        }
    }else {
        out.print("<script>alert('输入用户名或密码错误,请重试');location.href='login.jsp';</script>");
    }

%>

</body>
</html>
