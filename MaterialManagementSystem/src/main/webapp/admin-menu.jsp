<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者メニュー</title>
</head>
<body>
<h2>メインページ_管理者用</h2>
<h3>ユーザ一覧</h3>
・UserUさん（最終ログイン：yyyymmdd）←後でやり方聞く
<h3>ユーザ管理メニュー</h3>
<form action="user-regist" method="POST">
	<input type="submit" value="登録">
</form>

<form action="user-update" method="POST">
	<input type="submit" value="更新">
</form>

<form action="user-delete" method="POST">
	<input type="submit" value="削除">
</form>

<form action="material-newregist" method="POST">
	<input type="submit" value="材料マスタ登録">
</form>

<form action="material-delete-admin" method="POST">
	<input type="submit" value="材料マスタ削除">
</form>
</body>
</html>