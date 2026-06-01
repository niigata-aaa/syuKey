<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<%
String user_id = (String) session.getAttribute("user_id");
%>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/admin-menu-style.css">
<title>管理者メインページ</title>
</head>
<body>
	<%@include file="header.jsp" %>
<div class="d1">
	<h2><%=user_id%>さん、こんにちは</h2>
</div>
<div class="parent">
<div class="d2">
	<%
     List<UserBean> userList = (List<UserBean>)request.getAttribute("userList");
     if(userList.size()!=0){
    %>
	<h2>ユーザ一覧</h2>
	<%for(UserBean user : userList){ %>
		<%=user.getUser_id()%>さん（最終ログイン：<%=user.getLast_login_date() %>）<br>
	<%} %>
	<% 
     } else { %>
		aaaaaaaa
	<% }%>
</div>

<div class="d3">
	<h2>管理メニュー</h2>
	<form action="user-regist" method="POST">
		<input type="submit" value="ユーザ登録" class="btn">
	</form>

	<form action="user-update" method="POST">
		<input type="submit" value="ユーザのパスワード更新" class="btn">
	</form>

	<form action="user-delete" method="POST">
		<input type="submit" value="ユーザ削除" class="btn">
	</form>

	<form action="material-regist" method="POST">
		<input type="submit" value="材料マスタ登録" class="btn">
	</form>

	<form action="material-delete-admin" method="POST">
		<input type="submit" value="材料マスタ削除" class="btn">
	</form>
</div>
</div>
</body>
</html>