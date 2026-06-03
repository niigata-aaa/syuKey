<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新完了</title>
<link rel="stylesheet" href="css/material-update-result.css">
</head>
<body>
<%@include file="header.jsp" %>
<div id="confirm-card">
<%
request.setCharacterEncoding("UTF-8");
List<String> msgList = (List<String>)request.getAttribute("errmsg");
List<String> msg = (List<String>)request.getAttribute("msg");
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
<div id="big">

正常に更新完了しました。<br>
<%if(!(msg == null || msg.isEmpty())){ %>
<%for(int i=0;i<msg.size();i++){ %>
<%=msg.get(i) %><br>
<%} %>
<%} %>
<%
}
%>

</div>
</div>

<form action="material-update" method="post">
<input type="submit" value="続けて更新する">
</form>
<%@include file="footer.jsp" %>
</body>
</html>
