<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>材料削除確認</title>

<link rel="stylesheet" href="css/main-style.css">
<link rel="stylesheet" href="css/material-delete-confirm.css">

</head>
<body>

<%@include file="header.jsp" %>

<%
	String[] material_name =
		(String[])request.getAttribute("material_name");
%>

<div class="confirm-container">

	<div class="confirm-card">

		<h2>以下の材料を削除します。</h2>

		<div class="material-list">

		<%
		for(String name : material_name){
		%>

			<p><%= name %></p>

		<%
		}
		%>

		</div>

	</div>

	<div class="button-area">

		<form action="material-delete" method="post">
			<input type="submit" value="戻る" class="back-btn">
		</form>

		<form action="material-delete-result" method="post">

		<%
		for(String name : material_name){
		%>

			<input type="hidden"
				   name="material_name"
				   value="<%= name %>">

		<%
		}
		%>

			<input type="submit"
				   value="削除"
				   class="delete-btn">

		</form>

	</div>

</div>

<%@include file="footer.jsp" %>

</body>
</html>