<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新失敗</title>
</head>
<body>
更新に失敗しました。
<%
request.setCharacterEncoding("UTF-8");
List<String> msg = (List<String>)request.getAttribute("errmsg");
if(!(msg == null || msg.isEmpty())){
%>
<% for(int i=0;i<msg.size();i++){ %>
<%=msg.get(i) %><br>
<%
}
}
%>
</body>
</html>