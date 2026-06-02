<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.entity.MaterialBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>材料新規登録ページ</title>
<link rel="stylesheet" href="css/main-style.css">
<link rel="stylesheet" href="css/material-newregist.css">
</head>
<body>
<%@include file="header.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
List<MaterialBean> unitList = (List<MaterialBean>) request.getAttribute("unitList");
%>
<div id="main-content">
<div id="newregist">
<p id="info">材料の情報を入力してください♡</p>

<form action="material-newregist-confirm" method="post">
<div id="form">
名前：<input type="text" name="material_name"><br></div>
<div id="form">
消費期限：<input type="date" name="material_limit"><br></div>
<div id="form">
数量：<input type="number" name="amount">
<select name="unit">
<%
for(int i=0;i<unitList.size();i++){
%>
<option value=<%=unitList.get(i).getUnit_id() %>><%=unitList.get(i).getMaterial_unit() %></option>
<%
}
%>
</select>
</div>

<input type="submit" value="決定">
</div>
</form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>