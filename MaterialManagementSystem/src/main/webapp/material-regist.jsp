<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, model.entity.MaterialBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>材料登録</title>
<link rel="stylesheet" href="css/material-regist.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<%
		List<MaterialBean> nameunitList = (List<MaterialBean>)request.getAttribute("nameunitList");
			
	%>
	<form action="material-regist-confirm" method="post">
		<div class="radio-grid">
			<%
				for(int i=0;i<nameunitList.size();i++) {
			%>
			<div class="radio">
				<input type="radio" name="material_name"
					value="<%=nameunitList.get(i).getMaterial_name() %>"
					onchange="showSelected()"> <span><%=nameunitList.get(i).getMaterial_name() %></span>
			</div>
			<%
				}
			%>
		</div>

		<div class="selected" required>
			材料名：<span id="selectedText">----------------</span>&emsp; 消費期限：<input
				type="date" name="material_limit" class="text-box" required>&emsp; 
				数量：<input type="number" name="material_amount" class="text-box" min="0" step="1" required> <span id="unit"></span>
				<input type="hidden" name="unit">
			<input type="submit" value="登録確認へ" class="btn-regist">
		</div>
	</form>
	
	<div class="btn-area">
		<form action="material-newregist" method="post">
			<input type="submit" value="新規" class="btn">
		</form>
	
		<form action="material-delete" method="post">
			<input type="submit" value="削除" class="btn">
		</form>
	</div>
	<%@include file="footer.jsp"%>
	<script>
	const unitMap = {
			<%
			for (int i = 0; i < nameunitList.size(); i++) {
			%>
			    "<%=nameunitList.get(i).getMaterial_name()%>": "<%=nameunitList.get(i).getMaterial_unit()%>",
			<%
			}
			%>
			};
		function showSelected() {
			const selected = document.querySelector('input[name="material_name"]:checked');
			const text = selected ? selected.value:"----------------";
			const unit = unitMap[text] || "";
			document.getElementById("unit").innerText = unit;
			document.getElementById("selectedText").innerText = text;
		}

		
	</script>
</body>
</html>