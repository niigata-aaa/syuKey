<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規材料登録確認ページ</title>
<link rel="stylesheet" href="css/material-newregist-confirm.css">
</head>
<body>
<%@include file="header.jsp" %>

<div id ="box">
<%
request.setCharacterEncoding("UTF-8");

String materialName = (String)request.getAttribute("material_name");
String materialLimit = (String)request.getAttribute("material_limit");
String amount = (String)request.getAttribute("amount");
String unitName = (String)request.getAttribute("unit_name");
String unitId = (String)request.getAttribute("unit_id");
%>
<div id="big">
<div id="confirm-card">
以下の内容で登録します。<br>

<div id ="sample">
材料名：<%= materialName %><br>
数量：<%= amount %> <%= unitName %><br>
消費期限：<%= materialLimit %><br>
</div>
</div>
</div>
</div>
<div id ="btn-area">
<form action="material-newregist" method="post">
<input type="submit" value="戻る">
</form>
<form action="material-newregist-result" method="post">
<input type="hidden" name="material_name" value="<%= materialName %>">
<input type="hidden" name="material_limit" value="<%= materialLimit %>">
<input type="hidden" name="amount" value="<%= amount %>">
<input type="hidden" name="unit_name" value="<%= unitName %>">
<input type="hidden" name="unit_id" value="<%= unitId %>">
<input type="submit" value="OK">
</form>

</div>

<%@include file="footer.jsp" %>
</body>
</html>