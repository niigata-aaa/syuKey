<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.MaterialBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認</title>
<link rel="stylesheet" href="css/main-style.css">
</head>
<body>
<%@include file="header.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
MaterialBean materialBean = (MaterialBean)request.getAttribute("materialBean");
%>
以下の内容で登録します。<br>
<%=materialBean.getMaterial_name()%><br>
<%=materialBean.getLimits()%><br>
<%=materialBean.getAmount()%><br>
<form action="material-regist-result" method="post">
<input type="hidden" name="material_name" value="<%=materialBean.getMaterial_name()%>">
<input type="hidden" name="material_limit" value="<%=materialBean.getLimits()%>">
<input type="hidden" name="material_amount" value="<%=materialBean.getAmount()%>">

<input type="submit" value="登録">
</form>
<%@include file="footer.jsp" %>
</body>
</html>