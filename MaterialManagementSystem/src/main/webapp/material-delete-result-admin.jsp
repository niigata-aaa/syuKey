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
				削除しました。<br>
		<%
			}
		%>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>