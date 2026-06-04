<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録ページ</title>
<link rel="stylesheet" href="css/admin-each-start.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="main-content">
	<div class="area">
		<div class="btn-area">
			<form action="user-regist-confirm" method="POST">
				ユーザ名：<input type="text" size="12" name="user_id" class="text-box"
					required maxlength="10" required><br>
				<!-- <p>最大10文字までです</p> -->
				変更後のパスワード：<input type="password" size="12" name="user_pass"
					class="text-box" required minlength="8" required><br>
				<!-- <p>8文字以上で入力してください</p> -->
				管理者権限：<select name="admin_flg" class="text-box-flg">
					<option value="false">付与しない</option>
					<option value="true">付与</option>
					
				</select><br> 
				<input type="reset" value="クリア" class="btn">
				<input type="submit" value="登録確認へ" class="btn">
				
			</form>
		</div>
	</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>