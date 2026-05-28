<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録確認ページ</title>
</head>
<body>
<h2>ユーザ登録確認ページ</h2>
<%
		request.setCharacterEncoding("UTF-8");
	%>
	ユーザ情報を以下の内容で登録します。よろしいですか？<br>
    <jsp:useBean id="user" scope="session" class="model.entity.UserBean"/>
	<jsp:setProperty name="user" property="user_id" param="user_id"/>
	<jsp:setProperty name="user" property="user_pass" param="user_pass"/>
    
    ユーザID：<jsp:getProperty name="user" property="user_id"/><br>
	パスワード：<jsp:getProperty name="user" property="user_pass"/><br>
    
    <form action="user-regist-result" method="POST">
		<input type="submit" value="OK">
	</form>
	
	<form action="user-regist" method="POST">
	<input type="submit" value="戻る">
	</form>
	
</body>
</html>