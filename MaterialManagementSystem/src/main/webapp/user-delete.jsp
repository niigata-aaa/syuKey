<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ削除ページ</title>
<link rel="stylesheet" href="css/admin-each-start.css">
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="area">
		<div class="btn-area">
		    <form action="user-delete-confirm" method="POST">
		    	ユーザ名：<input type="text" size="12" name="user_id" class="text-box"><br>
		    	<input type="submit" value="削除" class="btn">
		    	<input type="reset" value="クリア" class="btn">
		    </form>
	    </div>
    </div>
</body>
</html>