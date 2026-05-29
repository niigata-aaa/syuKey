<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ更新完了ページ</title>
</head>
<body>
	<h2>ユーザ更新完了ページ</h2>
	<%
	int processingNumber = (Integer) request.getAttribute("processingNumber");
	if (processingNumber > 0) {
	%>
	正常に更新しました。
	<br>
	<%
	} else {
	%>
	正常に更新できませんでした。
	<br>
	<%
}
%>

	<form action="user-update" method="POST">
		<input type="submit" value="更新を続ける">
	</form>

</body>
</html>