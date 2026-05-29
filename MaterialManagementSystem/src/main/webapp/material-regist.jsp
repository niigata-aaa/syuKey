<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, model.entity.MaterialBean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>材料登録</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<%
		List<String> materialNameList = (List<String>)request.getAttribute("nameList");
		List<String> unitList = (List<String>)request.getAttribute("unitList");	
	%>
	<form action="material-regist-confirm" method="post">
		<div class="item-area">
			<%
				for(int i=0;i<materialNameList.size();i++) {
			%>
			<div class="item">
				<input type="radio" name="material_name" value="<%=materialNameList.get(i) %>" onchange="showSelected()">
				<span><%=materialNameList.get(i) %></span>
			</div>
			<%
				}
			%>
		</div>
	
		<div class="selected">
			材料名：<span id="selectedText">----------------</span>&emsp;
			消費期限：<input type="date" name="material_limit">&emsp;
			量：<input type="number" name="material_amount">
			<select name="unit">
			<%
			for(int i=0;i<unitList.size();i++){
			%>
			<option><%=unitList.get(i) %></option>
			<%
			}
			%>
			</select>
			<input type="submit" value="登録確認へ">
		</div>
	</form>
	
	<form action="material-newregist" method="post">
		<input type="submit" value="新規">
	</form>
	
	<form action="material-delete" method="post">
		<input type="submit" value="削除">
	</form>
	
	<script>
		function showSelected() {
			const selected = document.querySelector('input[name="material_name"]:checked');
			const text = selected ? selected.value:"----------------";
			document.getElementById("selectedText").innerText = text;
		}
	</script>
</body>
</html>