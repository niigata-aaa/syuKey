<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者材料マスタ削除完了ページ</title>
<link rel="stylesheet" href="css/admin-confirm&result.css">
</head>
<body>
	<%@include file="header.jsp" %>
	
	<div class="main-content">
	<div class="area">
		<%
			int cnt = (Integer)request.getAttribute("cnt");
		%>
		<%
			if(cnt == 0) {
		%>
				削除できませんでした。<br>
		<%
			} else {
		%>
				正常に削除しました。<br>
		<%
			}
		%>
		
		<form action="material-delete-admin" method="POST">
			<input type="submit" value="材料削除を続ける" class="btn">
		</form>
	</div>
	</div>
	
	
	
	<%@include file="footer.jsp" %>
</body>
</html>