<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ更新完了ページ</title>
<link rel="stylesheet" href="css/admin-confirm&result.css">
</head>
<body>
	<%@include file="header-admin.jsp" %>
	<div class="area">
		<%
		int processingNumber = (Integer) request.getAttribute("processingNumber");
		if (processingNumber > 0) {
		%>
		正常に更新しました。<br>
		<%
		} else {
		%>
		正常に更新できませんでした。<br>
		<%
		}
		%>
		<div class="btn-area">
			<form action="user-update" method="POST">
				<input type="submit" value="更新を続ける" class="btn">
			</form>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>