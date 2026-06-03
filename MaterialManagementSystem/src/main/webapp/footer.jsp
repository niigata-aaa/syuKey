<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<style>
#footer{
	height:45px;
	background-color: #9C6455;
	text-align: left;
	padding:10px;
}

#footer input{
	width: 150px;
	height: 30px;
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