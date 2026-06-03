<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/expired-delete-confirm.css">

</head>
<body>
<%@include file="header.jsp" %>
		<%
		request.setCharacterEncoding("UTF-8");
		
		%>
		<div id="main-content">
<div id ="box">
	<div id ="big">
	<div id="confirm-card">
	以下の内容を削除します。
	
	<jsp:useBean id="material" scope="session" class="model.entity.MaterialBean" />
	
	<jsp:setProperty name="material" property="material_name" param="material_name" />
	<jsp:setProperty name="material" property="material_kana" param="material_kana" />
	<jsp:setProperty name="material" property="material_limit" param="sdf" />
	<jsp:setProperty name="material" property="amount" param="amount" />
	<jsp:setProperty name="material" property="material_unit" param="material_unit" />
	
	<div id="sample">
	名前：<jsp:getProperty name="material" property="material_name" /><br>
	ふりがな：<jsp:getProperty name="material" property="material_kana" /><br>
	消費期限：<jsp:getProperty name="material" property="material_limit" /><br>
	数量：<jsp:getProperty name="material" property="amount" /><br>
	単位：<jsp:getProperty name="material" property="material_unit" /><br>
    </div>
</div>
</div>	
</div>
<div id="btn-area">
  <form action="menu-servlet" method="POST">
		<input type="submit" value="戻る">
	</form>

	<form action="expired-delete-result-servlet" method="POST">
		<input type="submit" value="OK">
	</form>  

</div>
</div>
<%@include file="footer.jsp" %>	
</body>
</html>