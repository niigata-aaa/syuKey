<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,model.entity.MaterialBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>材料更新ページ</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	List<MaterialBean> nameunitList = (List<MaterialBean>) request.getAttribute("nameunitList");
	%>

	<form action="material-update-confirm" method="post" enctype="multipart/form-data">
		<div id="update">
			<table id="tb1">
				<tr>
					<th>使った材料</th>
					<th>消費量</th>
				</tr>
				<tr>
					<td><input type="text" list="lists" name="material_name" onchange="showUnit(this)" required> <datalist
							id="lists">
							<%
							for (int i = 0; i < nameunitList.size(); i++) {
							%>
							<option value="<%=nameunitList.get(i).getMaterial_name()%>"><%=nameunitList.get(i).getMaterial_name()%></option>
							<%
							}
							%>
						</datalist> </select></td>
					<td><input type="number" name="amount" required></td>
					<td class="unitCell"></td>
				</tr>
				<tr>
					<td><input type="text" list="lists" name="material_name" onchange="showUnit(this)"></td>
					<td><input type="number" name="amount"></td>
					<td class="unitCell"></td>
				</tr>
				<tr>
					<td><input type="text" list="lists" name="material_name" onchange="showUnit(this)"></td>
					<td><input type="number" name="amount"></td>
					<td class="unitCell"></td>
				</tr>
				<tr>
					<td><input type="text" list="lists" name="material_name" onchange="showUnit(this)"></td>
					<td><input type="number" name="amount"></td>
					<td class="unitCell"></td>
				</tr>
				<tr>
					<td><input type="text" list="lists" name="material_name" onchange="showUnit(this)"></td>
					<td><input type="number" name="amount"></td>
					<td class="unitCell"></td>
				</tr>
			</table>
			<button type = "button" onclick="add()">追加（未実装）</button>
		</div>
		<div id="history">
			お菓子の名前：<input type="text" name="sweets_name"><br>
			URL：<input type="url" name="recipe_url"> <br>
			一言コメント：<input type="text" name="comment"><br>
			画像：<input type="file" name="history_image"><br>
		</div>
	<input type="submit" value="OK">
	</form>
	
<script>
function add() {
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
            <input type="number" name="amount">
        </td>
        <td class="unitCell"></td>
    `;
}

const unitMap = {
<%
for (int i = 0; i < nameunitList.size(); i++) {
%>
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
}

</script>
</body>
</html>