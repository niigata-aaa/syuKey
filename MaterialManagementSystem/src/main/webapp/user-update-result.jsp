<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ更新完了ページ</title>
</head>
<body>
<%
processingNumber = (Integer) request.getAttribute("processingNumber");
if(processingNumber > 0){
	%>
正常に更新しました。<br>
<%
}else{
%>
正常に更新できませんでした。<br>
<%
}
%>
<jsp:useBean id="user" scope="session" class="model.entity.UserBean"/>
ユーザID：<jsp:getProperty name=”user” property=”user_id”/>
パスワード：<jsp:getProperty name=”user” property=”user_pass”/>
<a href="user-update.jsp">更新を続ける</a>
<a href="admin-menu.jsp">戻る</a>
</body>
</html>