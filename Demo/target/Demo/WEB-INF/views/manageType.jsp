<%@ page import="com.cong.model.Type" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品类别管理</title>
</head>
<body>
<table border="2px">
    <tr>
        <th>类别编号</th>
        <th>类别名称</th>
        <th>操作</th>
    </tr>
    <%
        List<Type> typeList = (List<Type>) request.getAttribute("typeList");
        for(Type type:typeList){
            out.print("<tr>");
            out.print("<td>");
            out.print(type.getId());
            out.print("</td>");
            out.print("<td>");
            out.print(type.getName());
            out.print("</td>");
            %>
    <td>
        <a href="http://localhost:8080/type/modify?typeName=<%=type.getName()%>">修改</a>
        <a href="http://localhost:8080/type/delete?id=<%=type.getId()%>">删除</a>
    </td>
    <%
            out.print("</tr>");
        }
    %>

</table>
<a href="/type/addType">增加商品类型</a>
</body>
</html>
