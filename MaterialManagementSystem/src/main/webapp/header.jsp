<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="header.css">

<div id="header">

    <div class="logo">
        ヘッダー：堀さんデザイン
        
<!--        <img src =".jpg" width="20" height="30" alt="ヘッダーデザイン">-->
    </div>
    こんにちは、<%=session.getAttribute("user_id") %>さん<br>
    <form action="logout-servlet" method="post">
        <input type="submit" value="ログアウト">
         
    </form>

</div>