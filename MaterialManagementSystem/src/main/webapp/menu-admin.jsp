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
	<div class="parent">
		<div class="d2">
			<%
		     List<UserBean> userList = (List<UserBean>)request.getAttribute("userList");
		     if(userList.size()!=0){
		    %>
			<h2>ユーザ一覧</h2>
			<div class="userList">
				<table border="1">
				<tr>
				<th>ユーザID</th>
				<th>最終ログイン</th>
				</tr>
					<%for(UserBean user : userList){ %>
						<tr>
							<td><%=user.getUser_id()%>さん</td>
							<%if(user.getLast_login_date() == null){ %>
							<td>ログイン履歴がありません</td>
							<%} else { %>
							<td>（<%=user.getLast_login_date() %>）<br></td>
							<%} %>
						</tr>
					<%} %>
					<% 
				     } else { %>
						登録されているユーザはいません。
					<% }%>
				</table>
			</div>
		</div>
		
		<div class="d3">
			<h2>管理メニュー</h2>
			<form action="user-regist.jsp" method="POST">
				<input type="submit" value="ユーザ登録" class="btn">
			</form>
		
			<form action="user-update.jsp" method="POST">
				<input type="submit" value="ユーザのパスワード更新" class="btn">
			</form>
		
			<form action="user-delete.jsp" method="POST">
				<input type="submit" value="ユーザ削除" class="btn">
			</form>
		
			<form action="material-newregist" method="POST">
				<input type="submit" value="材料マスタ登録" class="btn">
			</form>
		
			<form action="material-delete-admin" method="POST">
				<input type="submit" value="材料マスタ削除" class="btn">
			</form>
		</div>
	</div>
</body>
</html>