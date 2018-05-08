<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UpdateProduct.jsp' starting page</title>
    
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
    <form action="doupdate.jsp" method="get">
    	请输入需要修改的联系人的姓名：<input type="text" name="oldusername">
    	<hr>
    	<h2>请输入需要修改项的信息</h2>
    	姓名:<input type="text" name="username"> <br/>
    工作地址：<input type="text" name="work"> <br/>
    手机：<input type="text" name="phone"><br/>
    家庭电话：<input type="text" name="homephone"><br/>
    邮箱：<input type="text" name="mail"><br/>
    分组：<input type="text" name="group"><br/>
    备注：<input type="text" name="remark"><br/>
    <input type="submit" value="修改">
    </form>
  </body>
</html>














