<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel = "stylesheet" href = "menuCss.css"> -->
<style>
*{
        box-sizing: border-box;
		background-color: black;
        color: white;
}
header{
	background-color: black;
        color:white;
   float: left;   
   width: 100%;
}
aside{
   float: left;
   font-size: 20px;   
}
nav{
   float:right;
   font-size: 20px;
   display: inline-block;
}
section{
   float: left;
   width: 100%;
   font-size: 20px;
   padding: 0px 10px 0px 10px;
   margin: 5px 0px 5px 0px;
}
#main{
   text-align: center;
   font-size: 30px;
   background-color: black;
       color:white;
}

#button2{
	border-radius: 5px;
	background-color: white;
      color:black;
      float:right;
}
a{
 text-decoration-line: none
 }
#menuList{
    display: inline-block;
	width: 16%;
	text-align: center;
}

#login{
	background-color: white; /* 전체 배경색  */
	color: black; /* 전체 글자색  */

}
#button{
	background-color: white;
    color:black;
    border-radius: 5px;
}
</style> 
</head>
<body>
<header>
	<div id="main">메인타이틀</div>
	<!--로그인창  -->
	<aside><a href="${pageContext.request.contextPath }/index.jsp">첫 페이지로</a></aside>
	<c:choose>
	
		<c:when test="${sessionScope.cId == null }">
		<nav>		
			<form action="login.do" method="post" size="10">
				ID: <input id="login" type='text' name='cId' size="10">
				PW: <input id="login" type='password' name='cPw' size="10">
				<input id="button" type='submit' value='Login'>
				<div id="menuList" ><a href='${pageContext.request.contextPath }/customer/customerInput.jsp'>회원가입</a></div>
			</form>
			</nav>
		</c:when>
		<c:otherwise>
		<nav>  <!--상세정보 , 로그아웃, 장바구니 일자배열 해야함  -->
			${sessionScope.cName }님(${sessionScope.authority }), 환영합니다.<br>
			<div>
			<form action="customerSearch.do" method='get'>
				<input type='hidden' name='cId' value='${sessionScope.cId }'>
				<input type='hidden' name='job' value='search'> 
				<input id="button2" type='submit' value='상세정보'>
			</form>
			
			<form action="${pageContext.request.contextPath }/logout.do" method='get'>
				<input id="button2" type='submit' value='로그아웃'>
			</form>
			<form action="ordCustomerList.do" method='get'>
				<input type='hidden' name='cId' value='${sessionScope.cId }'>
				<input id="button2" type='submit' value='장바구니'>
			</form>
			</div>
			</nav>
		</c:otherwise>
	</c:choose>
	
</header>
	<!--컨트롤 바-->
	<section>
	<hr>
	<div id="com">
	<a href="${pageContext.request.contextPath }/index.jsp">첫 페이지로</a>
	<div id="menuList"><a href='${pageContext.request.contextPath }/productList.do'>전체상품</a></div>
	<div id="menuList"><a href='${pageContext.request.contextPath }/boardList.do'>게시판</a></div>

	
	<c:if test="${sessionScope.authority == '관리자' }">
			<div id="menuList"><a href="${pageContext.request.contextPath }/product/productInput.jsp">상품등록(관리자)</a></div>
			<div id="menuList"><a href='${pageContext.request.contextPath }/customerList.do'>회원목록(관리자)</a></div>
			<div id="menuList"><a href="${pageContext.request.contextPath }/ordList.do">전체주문(관리자)</a></div>
	</c:if>
	
	<hr>
	</div>
	</section>

</body>
</html>
