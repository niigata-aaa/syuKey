<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新完了</title>
<link rel="stylesheet" href="css/main-style.css">
</head>
<body>
<%@include file="header.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
List<String> msgList = (List<String>)request.getAttribute("errmsg");
if(!(msgList == null || msgList.isEmpty())){
%>
一部更新に成功しました。<br>
以下は失敗しました。<br>
<% for(int i=0;i<msgList.size();i++){ %>
<%=msgList.get(i) %><br>
<%
}
} else {
%>
正常に登録完了しました。
<%
}
%>
<form action="menu-servlet" method="post">
<input type="submit" value="戻る">
</form>
<%@include file="footer.jsp" %>
</body>
</html>