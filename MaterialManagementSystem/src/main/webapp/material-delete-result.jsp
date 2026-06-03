<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>材料削除結果</title>

<link rel="stylesheet" href="css/main-style.css">
<link rel="stylesheet" href="css/material-delete-result.css">

</head>
<body>

<%@include file="header.jsp" %>

<%
	Integer cntObj = (Integer)request.getAttribute("cnt");
	int cnt = (cntObj != null) ? cntObj : 0;
%>

<div class="result-container">

	<div class="result-card">

		<% if(cnt > 0){ %>

			<div class="check-mark success-mark">
				✔
			</div>

			<h2>削除が完了しました</h2>

			<p>
				<%= cnt %>件の材料を削除しました。
			</p>

		<% }else{ %>

			<div class="check-mark error-mark">
				✖
			</div>

			<h2>削除に失敗しました</h2>

			<p>
				材料を削除できませんでした。
			</p>

		<% } %>

	</div>

	<div class="button-area">

		<% if(cnt > 0){ %>

			<form action="material-delete" method="post">

				<input type="submit"
					   value="削除を続ける"
					   class="menu-btn">

			</form>

		<% }else{ %>

			<form action="material-delete" method="post">

				<input type="submit"
					   value="削除画面へ戻る"
					   class="menu-btn">

			</form>

		<% } %>

	</div>

</div>

<%@include file="footer.jsp" %>

</body>
</html>