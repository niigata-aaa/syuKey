<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者材料マスタ削除完了ページ</title>
</head>
<body>
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
</body>
</html>