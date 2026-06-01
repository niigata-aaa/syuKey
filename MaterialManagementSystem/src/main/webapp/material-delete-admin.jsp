<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, model.entity.MaterialBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者材料マスタ削除ページ</title>
<link rel="stylesheet" href="css/material-delete-admin.css">
</head>
<body>
	<%
		List<MaterialBean> materialNameList = (List<MaterialBean>)request.getAttribute("materialNameList");
	%>
	<div class="area">
		<div class="btn-area">
			<form action="material-delete-confirm-admin" method="post">
				<div class="radio-grid">
					<%
						for(MaterialBean material : materialNameList){
					%>
					<div class="radio">
						<input type="radio" name="material_name" value="<%= material.getMaterial_name() %>"> 
						<span><%= material.getMaterial_name() %></span><br>
					</div>
					<%
						}
					%>
				</div>
				<input type="submit" value="削除確認へ" class="btn">
			</form>
		</div>
	</div>
</body>
</html>