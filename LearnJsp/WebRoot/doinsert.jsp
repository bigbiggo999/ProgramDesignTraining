<%@page import="com.cong.Util.DBUtil,java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.cong.entity.User,com.cong.Dao.UserDao" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doinsert.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
  <body>
    
    <%
    	Connection conn = DBUtil.getConn();
    	String username = request.getParameter("username");
    	String work = request.getParameter("work");
    	String phone = request.getParameter("phone");
    	String group = request.getParameter("group");
    	User user = new User();
    	user.setUsername(username);
    	user.setWork(work);
    	user.setPhone(phone);
    	user.setGroup(group);
    	UserDao userdao = new UserDao();
    	userdao.insertUser(conn, user);
    	out.print("增加成功");
     %>
     <a href="index.jsp">返回所有联系人页面</a>
  </body>
</html>
