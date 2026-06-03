<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新確認ページ</title>
<link rel="stylesheet" href="css/material-update-confirm.css">
</head>
<body>
<%@include file="header.jsp" %>
<div id="box">
<div id="big">
<div class="result-card">
<%
request.setCharacterEncoding("UTF-8");
List<String> names = (List<String>)request.getAttribute("material_names");
List<Integer> amounts = (List<Integer>)request.getAttribute("material_amounts");
String url = (String)request.getAttribute("recipe_url");
String sweets_name = (String)request.getAttribute("sweets_name");
String comment = (String)request.getAttribute("comment");
String image_name = (String)request.getAttribute("fileName");
String image_path = (String)request.getAttribute("filePath");
String contentType = (String)request.getAttribute("contentType");
%>
以下の内容で更新します。<br>

<div id="sample">

<%
for(int i=0;i<names.size();i++){
%>
材料名：<%=names.get(i) %><br>
消費量：<%=amounts.get(i) %><br>
<%
}
if(!(sweets_name == null || sweets_name.isEmpty())){
%>
作ったお菓子の名前：<%=sweets_name %><br>

<%
}
%>
</div>
</div>
<div id="btn-area">
<form action ="material-update" method="post">
<input type="submit" value="戻る">
</form>
<form action="material-update-result" method="post">
<%
for(int i = 0; i < names.size(); i++){
%>
    <input type="hidden" name="material_names" value="<%= names.get(i) %>">
<%
}
%>

<%
for(int i = 0; i < amounts.size(); i++){
%>
    <input type="hidden" name="material_amounts" value="<%= amounts.get(i) %>">
<%
}
%>
<% if(!(sweets_name == null || sweets_name.isEmpty())){ %>
    <input type="hidden" name="sweets_name" value="<%= sweets_name %>">
    <input type="hidden" name="comment" value="<%= comment %>">
    <input type="hidden" name="fileName" value="<%= image_name %>">
    <input type="hidden" name="recipe_url" value="<%= url %>">
    <input type="hidden" name="filePath" value="<%= image_path %>">
    <input type="hidden" name="contentType" value="<%= contentType %>">
<% } %>
<input type="submit" value="OK">
</form>
</div>
</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>