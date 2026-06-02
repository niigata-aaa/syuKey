<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<style>
#footer{
	height:40px;
	background-color: #9C6455;
	text-align: left;
	padding:20px;
	margin-top:20px;
}

#footer input{
	width: 200px;
	height: 50px;
	background-color: #ED7F70;
	border: none;
	color: white;
	border-radius: 10px;
}

#footer input:hover{
	filter:brightness(60%);
	
}
</style>

  <div id="footer">

<!--    <div class="pageList">-->
<!--        ページリスト-->
<!--    </div>-->

<form action ="menu-servlet"method="POST">
    <input type ="submit"value="メインページに戻る">
    
<!--        <input type="submit" value="メインページに戻る">-->
<!--            メインページに戻る-->
    </form>

</div>