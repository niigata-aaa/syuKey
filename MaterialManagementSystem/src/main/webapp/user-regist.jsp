<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録</title>
</head>
<body>
<h2>ユーザ登録ページ</h2>
    <form action="UserRegistConfirmServlet" method="POST">
    	ユーザ名：<input type="text" size="12" name="user_id"><br>
    	パスワード：<input type="password" size="12" name="user_pass"><br>
    	<input type="submit" value="登録">
    	<input type="reset" value="クリア">
    	
    </form>
    <a href="admin-menu.jsp">戻る</a>
	</table>
</body>
</html>