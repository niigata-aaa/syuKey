<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.HistoryBean"%>
<!DOCTYPE html>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
HistoryBean historyBean = (HistoryBean) request.getAttribute("historyDetail");
%>
<meta charset="UTF-8">
<title><%=historyBean.getSweets_name()%></title>
<style>
div {
	border: 1px solid;
}
</style>
<link rel="stylesheet" href="css/main-style.css">
</head>
<body>
<%@include file="header.jsp" %>
	<div id="main-content">

		<div id="image">

			<img src="show-image?date=<%=historyBean.getDate()%>&name=<%=historyBean.getSweets_name()%>">
		</div>
		<div id="title">
			<%=historyBean.getSweets_name()%>、<%=historyBean.getDate()%>
		</div>
		<div id="comment">
			<%=historyBean.getComment()%>
		</div>
		<div id="url">
			<%=historyBean.getRecipe_url()%>
		</div>
	</div>
	<form action="history-list" method="post">
		<input type="submit" value="戻る">
	</form>
<%@include file="footer.jsp" %>
</body>
</html>