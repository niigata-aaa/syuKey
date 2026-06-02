<%@ page language="java"
   contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
  
<style>
#header{
    width:100%;
    height:80px;
    background-image:url(img/header.png);
    background-repeat: repeat-x;
    padding:3px;
    margin-bottom:20px;
    background-size:auto 80px;
}

#logo-image{
    width:170px;
    height:auto;
    float:left;
}

#logoutbtn{
	position: absolute;
	right: 20px;
    top: 5%;
	transform: translateY(-50%);
}

.user-welcome{
    font-size:20px;
    margin-left:20px;
    margin-top:20px;
    display:inline-block;
}

#btn{
	text-align:right;
	background-color: #ED7F70 ;
	height:50px;
	color:white;
	border:none;
	border-radius: 0.5em;
}

#btn:hover{
	filter:brightness(70%);
}

</style>
<div id="header">
		<img src="img/logo.png" id="logo-image">
		<span class="user-welcome">
		   ようこそ、<%=session.getAttribute("user_id") %>さん
	  
		</span>
		<span id="logoutbtn">
		   <form action="logout-servlet" method="post" class="logout-form">
		       <input type="submit" value="ログアウト" id="btn"><br>
		   </form>
	   </span>
</div>
