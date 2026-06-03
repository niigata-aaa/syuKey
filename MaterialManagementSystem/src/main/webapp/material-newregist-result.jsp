<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規材料登録完了</title>
<link rel="stylesheet" href="css/material-newregist-result.css">
</head>
<body>
<%@include file="header.jsp" %>

<div id="box">
<div id ="big">
<div id ="result-card">
<%
request.setCharacterEncoding("UTF-8");
int cnt = (Integer)request.getAttribute("cnt");
if(cnt == 2){
%>

正常に完了しました。<br>
<%} else { %>
<p id="fail">登録が完了できませんでした。<br>
または、同じ材料が登録されています。<br></p>
<%} %>
</div>
</div>
</div>
<div id="btn-area">
<form action="material-newregist" method="post">
<input type="submit" value="続けて登録する">
</form>

<%@include file="footer.jsp" %>
</body>
</html>