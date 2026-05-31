<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>材料削除-結果</title>
<link rel="stylesheet" href="css/main-style.css">
</head>
<body>
<%@include file=“header.jsp” %>
	<%
		int cnt = (Integer)request.getAttribute("cnt");
	%>
	<%
		if(cnt == 0) {
	%>
			削除できませんでした。<br>
	<%
		} else {
	%>
			削除しました。<br>
	<%
		}
	%>
<%@include file=“footer.jsp” %>
</body>
</html>