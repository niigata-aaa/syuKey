<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, model.entity.MaterialBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>材料削除</title>
<link rel="stylesheet" href="css/main-style.css">
</head>

<body>
<%@include file="header.jsp" %>
	<%
		List<MaterialBean> materialNameList = (List<MaterialBean>)request.getAttribute("materialNameList");
	%>
	<%if(materialNameList.size() != 0){ %>
	<form action="material-delete-confirm" method="post">
		<%
			for(MaterialBean material : materialNameList){
		%>
		<input type="radio" name="material_name" value="<%= material.getMaterial_name() %>"> 
		<span><%= material.getMaterial_name() %></span><br>
		<%
			}
		%>
		<input type="submit" value="削除確認へ">
	</form>
	<%} else { %>
	削除できる材料はありません。
	<%} %>
<%@include file="footer.jsp" %>
</body>
</html>