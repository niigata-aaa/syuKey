<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新失敗</title>
<link rel="stylesheet" href="css/material-update-failure.css">
</head>
<body>
<%@include file="header.jsp" %>
<div id= "box">
<div id="big">
更新に失敗しました。<br>
<%
request.setCharacterEncoding("UTF-8");
List<String> msg = (List<String>)request.getAttribute("errmsg");
if(!(msg == null || msg.isEmpty())){
%>
<% for(int i=0;i<msg.size();i++){ %>
<%=msg.get(i) %><br>
<%
}
}
%>
<form action ="material-update" method="POST">
<input type="submit" value = "続けて登録する">
</form>
</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>