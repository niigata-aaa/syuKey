<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ削除確認ページ</title>
</head>
<body>
	<h2>ユーザ削除確認ページ</h2>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	以下のユーザを削除します。よろしいですか？<br>
	<jsp:useBean id="user" scope="session" class="model.entity.UserBean"/>
	<jsp:setProperty name="user" property="user_id" param="user_id"/>
	
	
	ユーザID：<jsp:getProperty name="user" property="user_id"/><br>
	
	<form action="user-delete-result" method="POST">
		<input type="submit" value="OK">
	</form>
	
	<form action="user-delete" method="POST">
	<input type="submit" value="戻る">
	</form>
	
</body>
</html>