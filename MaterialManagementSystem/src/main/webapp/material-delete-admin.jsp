<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者材料マスタ削除ページ</title>
</head>
<body>
<h2>管理者材料マスタ削除ページ</h2>
    <%
		List<MaterialBean> materialNameList = (List<MaterialBean>)request.getAttribute("materialNameList");
	%>

	<form action="material-delete-confirm-admin" method="post">
		<%
			for(MaterialBean material : materialNameList){
		%>
		<input type="radio" name="material_name" value="<%= material.getMaterial_name() %>"> 
		<span><%= material.getMaterial_name() %></span><br>
		<%
			}
		%>
		<input type="submit" value="削除確認へ">
    </form>
    <a href="admin-menu.jsp">戻る</a>
	</table>

</body>
</html>