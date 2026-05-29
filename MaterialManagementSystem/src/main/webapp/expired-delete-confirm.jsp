<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
		request.setCharacterEncoding("UTF-8");
		%>
	
	<br>以下の内容を削除します。<br>
	<jsp:useBean id="material" scope="session" class="model.entity.MaterialBean" />
	
	<jsp:setProperty name="material" property="material_name" param="material_name" />
	<jsp:setProperty name="material" property="material_kana" param="material_kana" />
	<jsp:setProperty name="material" property="material_limit" param="sdf" />
	<jsp:setProperty name="material" property="amount" param="Material_amount" />
	<jsp:setProperty name="material" property="material_unit" param="material_unit" />
	
	名前：<jsp:getProperty name="material" property="material_name" /><br>
	ふりがな：<jsp:getProperty name="material" property="material_kana" /><br>
	消費期限：<jsp:getProperty name="material" property="material_limit" /><br>
	数量：<jsp:getProperty name="material" property="amount" /><br>
	単位：<jsp:getProperty name="material" property="material_unit" /><br>
	
	<a href="menu.jsp">戻る</a>
	<form action="expired-delete-result-servlet" method="POST">
		<input type="submit" value="OK">
	</form>  
<%--
MaterialBean material =
    (MaterialBean)request.getAttribute("material");
%>

<h2>以下の内容を削除します。</h2>

名前：
<%= material.getMaterial_name() %>
<br>

ふりがな：
<%= material.getMaterial_kana() %>
<br>

消費期限：
<%= material.getMaterial_limit() %>
<br>

数量：
<%= material.getAmount() %>
<br>

単位：
<%= material.getMaterial_unit() %>
<br><br>

<form action="expired-delete-result-servlet"
      method="post">

    <input type="hidden"
           name="material_id"
           value="<%= material.getMaterial_id() %>">

    <input type="submit" value="OK">

</form>

<br>

<a href="menu.jsp">戻る</a>

 --%>
	
		
</body>
</html>