<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規材料登録完了</title>
<link rel="stylesheet" href="css/main-style.css">
</head>
<body>
<%@include file="header.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
int cnt = (Integer)request.getAttribute("cnt");
if(cnt == 2){
%>
正常に完了しました。<br>
<%} else { %>
登録が完了できませんでした。<br>
<%} %>
<form action="material-newregist" method="post">
<input type="submit" value="続けて登録する">
</form>
<%@include file="footer.jsp" %>
</body>
</html>