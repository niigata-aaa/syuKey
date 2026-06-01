<%@ page language="java"
   contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
  
<link rel="stylesheet" href="css/header.css">
<div id="header">
<!--<div class="relative">-->
<img src="img/ヘッダー.png" id="bgimage">
<img src="img/ロゴ.png" class="logo-img">
<!--</div>-->
<!-- <div class="header-content">-->
   <form action="logout-servlet" method="post" class="logout-form">
       <input type="submit" value="ログアウト"><br>
   </form>
</div>
<div class="user-welcome">
   ようこそ、<%=session.getAttribute("user_id") %>さん<br>
  
</div>