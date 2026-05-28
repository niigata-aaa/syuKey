<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ更新確認ページ</title>
</head>
<body>
	<h2>ユーザ更新確認ページ</h2>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	ユーザ情報を以下の内容で更新します。よろしいですか？<br>
	<jsp:userBean id="user" scope="session" class="model.entity.UserBean"/>
	<jsp:setProperty name="user" propaty="user_id" param="user_id"/>
	<jsp:setProperty name="user" propaty="user_pass" param="user_pass"/><
	
	ユーザID：<jsp:getProperty name="user" propaty="user_id"/><br>
	パスワード：<jsp:getProperty name="user" propaty="user_pass"/><br>
	
	<form action="user-update-result" method="POST">
		<input type="submit" value="OK">
	</form>
	<a href="user-update.jsp">戻る</a>
</body>
</html>