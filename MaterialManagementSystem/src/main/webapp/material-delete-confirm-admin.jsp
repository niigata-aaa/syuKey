<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者材料マスタ削除確認ページ</title>
<link rel="stylesheet" href="css/admin-confirm&result.css">
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="main-content">
	<%	
		String material_name = (String)request.getAttribute("material_name");
	%>
	<div class="area">
		以下の材料を削除します<br>
		材料名：<%=material_name %><br>
		<div class="btn-area">
		<form action="material-delete-admin" method="post">
				<input type="submit" value="戻る" class="btn">
			</form>
			
			<form action="material-delete-result-admin" method="post">
				<input type="hidden" name="material_name" value="<%=material_name%>">
				<input type="submit" value="OK" class="btn">
			</form>
		</div>
	</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>