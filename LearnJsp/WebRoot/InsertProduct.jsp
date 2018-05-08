<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'InsertProduct.jsp' starting page</title>
    
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
  
    <form action="doinsert" method="get">
    姓名:<input type="text" name="username"> <br/>
    工作地址：<input type="text" name="work"> <br/>
    手机：<input type="text" name="phone"><br/>
    家庭电话：<input type="text" name="homephone"><br/>
    邮箱：<input type="text" name="mail"><br/>
    分组：<input type="text" name="group"><br/>
    备注：<input type="text" name="remark"><br/>
    <input type="submit" value="保存">
    </form>
  </body>
</html>
