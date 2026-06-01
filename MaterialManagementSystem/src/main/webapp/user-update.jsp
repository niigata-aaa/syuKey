<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ更新ページ</title>
<link rel="stylesheet" href="css/admin-each-start.css">
</head>
<body>
	<h2>ユーザ更新ページ</h2>
	<div class="area">
		<div class="btn-area">
		    <form action="user-update-confirm" method="POST">
		    	　ユーザ名：<input type="text" size="12" name="user_id" class="text-box"><br>
		    	パスワード：<input type="password" size="12" name="user_pass" class="text-box"><br>
		    	<input type="submit" value="更新" class="btn">
		    	<input type="reset" value="クリア" class="btn">
		    </form>
	    </div>
	</div>
</body>
</html>