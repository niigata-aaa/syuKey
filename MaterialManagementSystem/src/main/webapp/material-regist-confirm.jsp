<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.MaterialBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認</title>
<link rel="stylesheet" href="css/main-style.css">
<link rel="stylesheet" href="css/material-regist-confirm.css">
</head>
<body>

<%@include file="header.jsp" %>
<div id ="box">
<%
request.setCharacterEncoding("UTF-8");
MaterialBean materialBean = (MaterialBean)request.getAttribute("materialBean");
%>
<div id ="big">
以下の内容で登録します。<br>
</div>
<div id="sample">
材料名：<%=materialBean.getMaterial_name()%><br>
消費期限：<%=materialBean.getLimits()%><br>
数量：<%=materialBean.getAmount()%><%=materialBean.getMaterial_unit()%><br>
</div>
</div>



<div id ="btn-area">
<form action="material-regist" method="post">
<input type="submit" value="戻る">
</form>

<form action="material-regist-result" method="post">
<input type="hidden" name="material_name" value="<%=materialBean.getMaterial_name()%>">
<input type="hidden" name="material_limit" value="<%=materialBean.getLimits()%>">
<input type="hidden" name="material_amount" value="<%=materialBean.getAmount()%>">

<input type="submit" value="登録">
</form>

</div>

<%@include file="footer.jsp" %>
</body>
</html>