<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,model.entity.HistoryBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スウィートメモリー</title>
<link rel="stylesheet" href="css/main-style.css">
<link rel="stylesheet" href="css/history-list.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<div id="main-wrapper">
		<%
		request.setCharacterEncoding("UTF-8");
		List<HistoryBean> historyList = (List<HistoryBean>) request.getAttribute("historyList");

		if (!(historyList == null || historyList.isEmpty())) {
		%>
		<div id="filter">
		<input type="text" id="searchInput" placeholder="名前か日付で検索">
		</div>
		<div id="myTable2">
			<div id="table-wrapper">
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
								type="submit" value="詳細" class="button">
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</table>
			</div>
		</div>
		<%
} else {
%>
		<div id="none-history">履歴がないよ。<br>Let's cooking！</div>
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
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>