<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録完了ページ</title>
</head>
<body>
 <h2>ユーザ登録完了ページ</h2>
	<%
	int processingNumber = (Integer) request.getAttribute("processingNumber");
	if (processingNumber > 0) {
	%>
	正常に登録しました。
	<br>
	<%
	} else {
	%>
	正常に登録できませんでした。
	<br>
	<%
}
%>
 
 <form action="user-regist" method="POST">
	<input type="submit" value="登録を続ける">
	</form>
 
</body>
</html>