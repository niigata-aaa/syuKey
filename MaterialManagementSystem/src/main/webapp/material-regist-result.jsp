<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>材料登録完了ページ</title>
<link rel="stylesheet" href="css/main-style.css">
<link rel="stylesheet" href="css/material-regist-result.css">
</head>
<body>

<%@include file="header.jsp" %>
<div id="result-card">
<div id="box">
<div id="big">
正常に登録しました。
<div class="check-mark success-mark">
				✔
			</div>
</div>
</div>
</div>
<div class="btn-area">
<form action="material-regist" method="post">
<input type="submit" value="続けて登録" class="btn">
</form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>