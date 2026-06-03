<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了</title>
<link rel="stylesheet" href="css/main-style.css">
<link rel="stylesheet" href="css/expired-delete-result.css">
</head>
<body>
<%@include file="header.jsp" %>
<div id="box">
<div id="big">

<%
	int processingNumber =
    (Integer)request.getAttribute(
            "processingNumber");
%>
<div class="result-card">
<%
if(processingNumber != 0){
%>
<div class="check-mark success-mark">
✔
			</div>
	<p>正常に削除しました</p>
<%
	}else{
%>
<div class="check-mark error-mark">
				✖
			</div>
	<p>削除できませんでした</p>
<%
	}
%>
</div>
</div>
</div>

		
	<%--<a href="menu.jsp">トップに戻る</a> --%>
	
	
	 <%//session.invalidate();%> 
<%@include file="footer.jsp" %>
</body>
</html>