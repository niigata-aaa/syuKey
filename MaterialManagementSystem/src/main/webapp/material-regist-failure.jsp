<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録エラー</title>
<link rel="stylesheet" href="css/main-style.css">
<link rel="stylesheet" href="css/material-regist-failure.css">
</head>
<body>
<%@include file="header.jsp" %>
<div id="box">
<div id="big">
登録失敗
</div>
<div id="A">
同じものを3つ以上は<br>登録できません。
</div>
</div>
<form action="material-regist" method="post">
<input type="submit" value="続けて登録" class="btn">
</form>
<%@include file="footer.jsp" %>
</body>
</html>