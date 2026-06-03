<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, model.entity.MaterialBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>材料削除</title>
<link rel="stylesheet" href="css/main-style.css">
<link rel="stylesheet" href="css/material-delete.css">
</head>

<body>

<%@include file="header.jsp" %>

<%
	List<MaterialBean> materialNameList =
		(List<MaterialBean>)request.getAttribute("materialNameList");
%>

<div class="delete-container">

	<h2>材料削除</h2>

	<p class="count">
		登録材料数：<%= materialNameList.size() %>件
	</p>

	<%if(materialNameList.size() != 0){ %>

	<form action="material-delete-confirm" method="post">

		<div class="material-list">

		<%
		for(MaterialBean material : materialNameList){
		%>

			<label class="material-card">

				<input type="checkbox"
					   name="material_name"
					   value="<%= material.getMaterial_name() %>">

				<span class="material-name">
					<%= material.getMaterial_name() %>
				</span>

			</label>

		<%
		}
		%>

		</div>

		<div class="button-area">
			<input type="submit"
				   value="削除確認へ"
				   class="delete-btn">
		</div>

	</form>

	<%} else { %>

<div id="confirm-card">
	<p class="empty-message">
		削除できる材料はありません。
	</p>
</div>
	<%} %>

</div>

<%@include file="footer.jsp" %>

</body>
</html>