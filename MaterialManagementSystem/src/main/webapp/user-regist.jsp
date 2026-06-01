<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録ページ</title>
<link rel="stylesheet" href="css/admin-each-start.css">
</head>
<body>
	<h2>ユーザ登録ページ</h2>
	<div class="area">
		<div class="btn-area">
		    <form action="user-regist-confirm" method="POST">
		    	　　ユーザ名：<input type="text" size="12" name="user_id" class="text-box"><br>
		    	　パスワード：<input type="password" size="12" name="user_pass" class="text-box"><br>
		    	管理者フラグ：<input type="flg" size="12" name="admin_flg" class="text-box"><br>
		    	<input type="submit" value="登録" class="btn">
		    	<input type="reset" value="クリア" class="btn">
		    </form>
	    </div>
	</div>
</body>
</html>