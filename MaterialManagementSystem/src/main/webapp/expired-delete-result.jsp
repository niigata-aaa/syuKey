<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了</title>
<link rel="stylesheet" href="css/main-style.css">
</head>
<body>
<%@include file="header.jsp" %>
<%
	int processingNumber =
    (Integer)request.getAttribute(
            "processingNumber");

	if(processingNumber != 0){
%>
	正常に削除しました
<%
	}else{
%>
	削除できませんでした
<%
	}
%>

		
	<%--<a href="menu.jsp">トップに戻る</a> --%>
	
	
	 <%//session.invalidate();%> 
<%@include file="footer.jsp" %>
</body>
</html>