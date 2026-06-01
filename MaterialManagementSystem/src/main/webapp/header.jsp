<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="css/header.css">

<body>
<!--<div class="relative">-->
<!--  <img src="img/ヘッダー.png" >-->
<!--  <img src="img/ロゴ.png" class="absolute">-->
<!--</div>-->
    ようこそ、<%=session.getAttribute("user_id") %>さん<br>

    
    
    
    <form action="logout-servlet" method="post">
        <input type="submit" value="ログアウト">
         
    </form>
</body>

