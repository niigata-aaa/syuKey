<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="css/header.css">

  <img src="img/ロゴ.png" alt="在庫見るくん">
</div>
<img src="img/ヘッダー.png" alt="枠">

</div>
<body>

    ようこそ、<%=session.getAttribute("user_id") %>さん<br>

    
    
    
    <form action="logout-servlet" method="post">
        <input type="submit" value="ログアウト">
         
    </form>
</body>
</div>
