<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,java.util.ArrayList,model.entity.MaterialBean,java.util.Calendar,java.time.LocalDate,java.util.Date,java.time.LocalDateTime,java.time.format.DateTimeFormatter,java.time.temporal.ChronoUnit"%>
<!DOCTYPE html>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String user_id = (String) session.getAttribute("user_id");
%>
<meta charset="UTF-8">
<title><%=user_id%>さんのマイページ</title>
<link rel="stylesheet" href="css/menu-style.css">

<style>

#expired-material tr {
	color: red;
}

#nearlist1 {
	color: #ff4500;
}

#nearlist2 {
	color: #ffd700;
}

#nearlist3 {
	color: #ffff00;
}
body{
	color:#9C6455 ;
	
	margin:0px;
	padding:0px;
	
}
</style>

</head>
<body>
<%@include file="header.jsp" %>
	<%
	//request.setCharacterEncoding("UTF-8");
	List<MaterialBean> materialList = (List<MaterialBean>) request.getAttribute("materialList");
	List<MaterialBean> expiredList = (List<MaterialBean>) request.getAttribute("expiredList");
	List<String> amounts = (List<String>) request.getAttribute("amounts");
	%>
	
	<div id="main-content">
	<div id="material-list">
	<div id="buttons">
		<form action="material-regist" method="post" >
			<input type="submit" value="在庫登録">
		</form>

		<form action="material-update" method="post" >
			<input type="submit" value="在庫更新">
		</form>

		<form action="history-list" method="post" >
			<input type="submit" value="スウィートメモリー">
		</form>
	</div>
		<div class="regist-list">
		<div class="content-title">在庫一覧</div>
		<div class="tyu">※消費期限の違う材料が２つあると、数量も２つ表示されます</div>
		<input type="text" id="searchInput" placeholder="キーワードで検索" style="width: 150px; align-content: right;">
		<div class="tablewrapper">
		<table id="myTable">
			<tr>
				<th>名前</th>
				<th>数量</th>
				<th>単位</th>
				<th>消費期限</th>
			</tr>
			<%
			for (int i = 0; i < materialList.size(); i++) {
				
			%>
			<tr>
				<td><%=materialList.get(i).getMaterial_name()%></td>
				<td><%=amounts.get(i)%></td>
				<td><%=materialList.get(i).getMaterial_unit()%></td>

				<td><%=materialList.get(i).getLimits()%></td>

			</tr>
			<%
			
			}
			%>
		</table>
		</div>
	</div>
	</div>
	<div id="expired-list">
		<div class="content-title2">もったいないリスト</div>
		 <div id="expired-content">
		<div id="expired-material">
			<p class="expired-title">----------------期限の切れてしまった材料---------------</p>
			<%
			List<MaterialBean> list = new ArrayList<MaterialBean>();
			List<MaterialBean> nearlist = new ArrayList<MaterialBean>();
			Date date = new Date();

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			Date pastDate = calendar.getTime();

			for (int i = 0; i < expiredList.size(); i++) {
				Date thatDate = expiredList.get(i).getMaterial_limit();
				if ((thatDate.compareTo(date) == -1) || (thatDate.compareTo(date) == 0)) {
					
					list.add(expiredList.get(i));

				} else if ((thatDate.compareTo(pastDate) == -1) || (thatDate.compareTo(pastDate) == 0)) {

					nearlist.add(expiredList.get(i));

				} else {

				}
			}
			%>

			<%
			if (list.size() != 0) {
			%>
			<div class="exe-tablewrapper">
			<table id="expired">
				<%
				for (int i = 0; i < list.size(); i++) {
					
				%>
				<tr>
					<td ><%=list.get(i).getMaterial_name()%></td>
					<td ><%=list.get(i).getMaterial_limit()%></td>
					<td>
						<form action="expired-delete-confirm-servlet" method="post">
							<input type="hidden" name="material_name"
								value="<%=list.get(i).getMaterial_name()%>"> <input
								type="hidden" name="material_limit"
								value="<%=list.get(i).getMaterial_limit()%>"> <input
								type="submit" value="削除">
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</table>
			</div>
			<%
			} else {
			%>
			<p class="empty-content">消費期限切れの材料はありません。</p>
			<%
			}
			%>
		</div>
		<div id="near-expired-material">
			<p class="expired-title">-------------------期限切れの近い材料-------------------</p>
			<%
			if (nearlist.size() != 0) {
				long datetimeNow = date.getTime();
				long one_date_time = 1000 * 60 * 60 * 24;
				long diffDays;
				int time = 0;
			%>
			<div class="exe-tablewrapper">
			<table>
				<%
				for (int i = 0; i < nearlist.size(); i++) {
					long datetimeList = nearlist.get(i).getMaterial_limit().getTime();
					diffDays = (int) (datetimeList - datetimeNow) / one_date_time + 1;
					time = (int) diffDays;
					switch (time) {
						case 1 :
				%>
				<tr id="nearlist1">
					<td><%=nearlist.get(i).getMaterial_name()%></td>
					<td><%=nearlist.get(i).getMaterial_limit()%></td>
					<td>あと<%=diffDays%>日
					</td>
				</tr>
				<%
				break;
				case 2 :
				%>
				<tr id="nearlist2">
					<td><%=nearlist.get(i).getMaterial_name()%></td>
					<td><%=nearlist.get(i).getMaterial_limit()%></td>
					<td>あと<%=diffDays%>日
					</td>
				</tr>
				<%
				break;
				default :
				%>
				<tr id="nearlist3">
					<td><%=nearlist.get(i).getMaterial_name()%></td>
					<td><%=nearlist.get(i).getMaterial_limit()%></td>
					<td>あと<%=diffDays%>日
					</td>
				</tr>
				<%
				break;
				}
				}
				%>
			</table>
			
			<%
			} else {
			%>
			<p class="empty-content">消費期限切れの近い材料はありません。</p>
			<%
			}
			%>
		</div>
		</div>
		</div>
		

	</div>
	</div>
<%@include file="footer.jsp" %>
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
</body>
</html>