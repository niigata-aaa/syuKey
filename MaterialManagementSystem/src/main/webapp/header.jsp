<%@ page language="java"
   contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
  
<style>
#header{
	width:100%;
	height:150px;
	background-image:url(img/header.png);
	background-repeat: repeat-x;
	padding:20px;
	margin-bottom:20px;
}

#content{
	height:90%;
}

#logo-image{
	width:240px;
	height:100px;
	float:left;
}

#logoutbtn{
	position: absolute;
	right: 20px;
    top: 7%;
	transform: translateY(-50%);
}

.user-welcome{
	font-size:24px;
	margin-left:20px;
	margin-top:40px;
    display: inline-block;
    height: 100px;
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
	<div id="content">
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
</div>
