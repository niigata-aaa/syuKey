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
	
	
	 <%session.invalidate();%> 
</body>
</html>