<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録完了ページ</title>
<link rel="stylesheet" href="css/admin-confirm&result.css">
</head>
<body>
	<%@include file="header-admin.jsp" %>
 	<div class="area">
		<%
		int processingNumber = (Integer) request.getAttribute("processingNumber");
		if (processingNumber > 0) {
		%>
		正常に登録しました。
		<br>
		<%
		} else {
		%>
		正常に登録できませんでした。
		<br>
		<%
		}
		%>
	 	<div class="btn-area">
		 	<form action="user-regist" method="POST">
				<input type="submit" value="登録を続ける" class="btn">
			</form>
		</div>
 	</div>
</body>
</html>