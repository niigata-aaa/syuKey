<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>材料削除確認</title>
<link rel="stylesheet" href="css/main-style.css">
</head>
<body>
<%@include file=“header.jsp” %>
	<%	
		String material_name = (String)request.getAttribute("material_name");
	%>
	以下の材料を削除します<br>
	材料名：<%=material_name %><br>
	<form action="material-delete-result" method="post">
		<input type="hidden" name="material_name" value="<%=material_name%>">
		<input type="submit" value="削除">
	</form>
	
	<form action="material-delete" method="post">
		<input type="submit" value="戻る">
	</form>
<%@include file=“footer.jsp” %>
</body>
</html>