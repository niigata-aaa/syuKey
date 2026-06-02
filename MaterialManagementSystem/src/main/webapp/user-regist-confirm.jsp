<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録確認ページ</title>
<link rel="stylesheet" href="css/admin-confirm&result.css">
</head>
<body>
	<%@include file="header.jsp" %>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<div class="area">
		ユーザ情報を以下の内容で登録します。よろしいですか？<br>
	    <jsp:useBean id="user" scope="session" class="model.entity.UserBean"/>
		<jsp:setProperty name="user" property="user_id" param="user_id"/>
		<jsp:setProperty name="user" property="user_pass" param="user_pass"/>
		<jsp:setProperty name="user" property="admin_flg" param="admin_flg"/>
	    
	    ユーザID：<jsp:getProperty name="user" property="user_id"/><br>
		パスワード：<jsp:getProperty name="user" property="user_pass"/><br>
	    管理者フラグ：<jsp:getProperty name="user" property="admin_flg"/><br>
	    
	    <div class="btn-area">
	    	<form action="user-regist" method="POST">
				<input type="submit" value="戻る" class="btn">
			</form>
			
		    <form action="user-regist-result" method="POST">
				<input type="submit" value="OK" class="btn">
			</form>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>