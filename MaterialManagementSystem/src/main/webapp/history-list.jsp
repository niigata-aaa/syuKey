<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,model.entity.HistoryBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スウィートメモリー</title>
<style>
div {
	border: 1px solid;
}
</style>
<link rel="stylesheet" href="css/main-style.css">
</head>
<body>
<%@include file=“header.jsp” %>
	<%
	request.setCharacterEncoding("UTF-8");
	List<HistoryBean> historyList = (List<HistoryBean>) request.getAttribute("historyList");

	if (!(historyList == null || historyList.isEmpty())) {
	%>
	<input type="text" id="searchInput" placeholder="キーワードで検索">
	<table id="myTable">
		<tr>
			<th>名前</th>
			<th>作成日</th>
			<th></th>
		</tr>
		<%
		for (int i = 0; i < historyList.size(); i++) {
		%>
		<tr>
			<td><%=historyList.get(i).getSweets_name()%></td>
			<td><%=historyList.get(i).getDate()%></td>
			<td>
				<form action="history-detail" method="post">
					<input type="hidden" name="sweets_name"
						value="<%=historyList.get(i).getSweets_name()%>"> <input
						type="hidden" name="date"
						value="<%=historyList.get(i).getDate()%>"> <input
						type="submit" value="詳細">
				</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	<%
} else {
%>
	<div id="none-history">履歴がないよ。Let's cooking！</div>
	<%
}
%>
	<script>
		document.getElementById('searchInput').addEventListener(
				'keyup',
				function() {
					let searchValue = this.value.toLowerCase();
					let tableRows = document.getElementById('myTable')
							.getElementsByTagName('tr');

					for (let i = 1; i < tableRows.length; i++) {
						let rowText = tableRows[i].textContent.toLowerCase();
						if (rowText.indexOf(searchValue) > -1) {
							tableRows[i].style.display = '';
						} else {
							tableRows[i].style.display = 'none';
						}
					}
				});
	</script>
<%@include file=“footer.jsp” %>
</body>
</html>