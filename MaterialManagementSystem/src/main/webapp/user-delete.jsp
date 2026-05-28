<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ削除</title>
</head>
<body>
	<h2>ユーザ削除ページ</h2>
    <form action="UserDeleteConfirmServlet" method="POST">
    	ユーザ名：<input type="text" size="12" name="user_id"><br>
    	最終ログイン：<br>
    	<input type="submit" value="削除">
    	<input type="reset" value="クリア">
    	
    </form>
    <a href="admin-menu.html">戻る</a>
	</table>
</body>
</html>