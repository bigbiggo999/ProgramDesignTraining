<%@page import="java.sql.Connection"%>
<%@page import="com.cong.Util.DBUtil"%>
<%@ page language="java" import="java.util.*,com.cong.entity.User,com.cong.Dao.UserDao" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dodelete.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    Connection conn = DBUtil.getConn();
    	User user = new User();
    	user.setUsername(request.getParameter("username"));
    	UserDao userdao = new UserDao();
    	userdao.deleteUser(conn, user);
    	out.print("删除成功");
     %>
     <a href="index.jsp"> 返回所有联系人页面</a>
  </body>
</html>
