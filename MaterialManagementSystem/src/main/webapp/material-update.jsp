<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,model.entity.MaterialBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>材料更新ページ</title>
<link rel="stylesheet" href="css/material-update.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<%
	request.setCharacterEncoding("UTF-8");
	List<MaterialBean> nameunitList = (List<MaterialBean>) request.getAttribute("nameunitList");
	%>

	<form action="material-update-confirm" method="post"
		enctype="multipart/form-data">
		<div id="main-content">
		<div id="update">
		
			<table id="tb1">
				<tr>
					<th>使った材料：</th>
					<th>消費量：</th>
				</tr>
				<tr>
					<td><input type="text" list="lists" name="material_name"
						onchange="showUnit(this)" required> <datalist id="lists">
							<%
							for (int i = 0; i < nameunitList.size(); i++) {
							%>
							<option value="<%=nameunitList.get(i).getMaterial_name()%>"><%=nameunitList.get(i).getMaterial_name()%></option>
							<%
							}
							%>
						</datalist> </td>
					<td><input type="number" name="amount" min="0" step="1" required></td>
					<td class="unitCell"></td>
				</tr>
				<tr>
					<td><input type="text" list="lists" name="material_name"
						onchange="showUnit(this)"></td>
					<td><input type="number" name="amount" min="0" step="1"></td>
					<td class="unitCell"></td>
				</tr>
				<tr>
					<td><input type="text" list="lists" name="material_name"
						onchange="showUnit(this)"></td>
					<td><input type="number" name="amount" min="0" step="1"></td>
					<td class="unitCell"></td>
				</tr>
				<tr>
					<td><input type="text" list="lists" name="material_name"
						onchange="showUnit(this)"></td>
					<td><input type="number" name="amount" min="0" step="1"></td>
					<td class="unitCell"></td>
				</tr>
				<tr>
					<td><input type="text" list="lists" name="material_name"
						onchange="showUnit(this)"></td>
					<td><input type="number" name="amount" min="0" step="1"></td>
					<td class="unitCell"></td>
				</tr>
			</table>
			<button type="button" onclick="addRow()" id="add">行の追加</button>
		</div>
	


<div id="history">
    <div id="history-title">
        履歴を登録する場合は、以下の情報を入力してください
    </div>
 <div class="history-row"><br>
    <label>
        お菓子の名前
        <input type="text"
               name="sweets_name"
               id="sweets_name"
               onchange="setRequired(this)">
    </label><br>

    <label>
        参考レシピのURL<br>
        <input type="url" name="recipe_url">
    </label><br>

    <label>
        コメント
        <textarea name="comment"></textarea>
    </label><br>

    <label>
        画像
        <input type="file" name="history_image">
    </label>
</div>
		</div>
		</div>
		<input type="submit" value="OK">
	</form>
	<%@include file="footer.jsp"%>
	<script>
function addRow() {
    const table = document.getElementById("tb1");

    const row = table.insertRow();

    row.innerHTML = `
        <td>
            <input type="text"
                   list="lists"
                   name="material_name"
                   onchange="showUnit(this)">
        </td>
        <td>
            <input type="number" name="amount" min="0" step="1">
        </td>
        <td class="unitCell"></td>
    `;
};

function toggleHistory() {
    const history = document.getElementById("history");
    const button = document.getElementById("historyBtn");

    if (history.style.display === "none") {
        history.style.display = "block";
        button.textContent = "履歴登録を閉じる";
    } else {
        history.style.display = "none";
        button.textContent = "履歴を登録";
    }
}

const unitMap = {
<%for (int i = 0; i < nameunitList.size(); i++) {%>
    "<%=nameunitList.get(i).getMaterial_name()%>": "<%=nameunitList.get(i).getMaterial_unit()%>",
<%
}
%>
};

function showUnit(input) {
    const materialName = input.value;
    const unit = unitMap[materialName] || "";

    const row = input.closest("tr");
    row.querySelector(".unitCell").textContent = unit;
};

function setRequired(input){
	const parentElement = document.getElementById('history');
	const links = parentElement.getElementsByTagName('input');
	if(!(input.value == "")){
	for(let i=0;i<links.length;i++){
		
	links[i].setAttribute('required', 'true');
};
	}else {
		for(let i=0;i<links.length;i++){
			
			links[i].required = false;
		};
}
	

};


</script>
</body>
</html>