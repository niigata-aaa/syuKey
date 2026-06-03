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
	<div class="main-content">
	<div class="area">
		<div class="btn-area">
		    <form action="user-delete-confirm" method="POST">
		    	ユーザ名：<input type="text" size="12" name="user_id" class="text-box" required><br>
		    	<input type="reset" value="クリア" class="btn">
		    	<input type="submit" value="削除確認へ" class="btn">
		    </form>
	    </div>
    </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>