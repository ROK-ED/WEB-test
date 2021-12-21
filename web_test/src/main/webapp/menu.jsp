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

#button{
	border-radius: 5px;
	background-color: white;
        color:black;
}
a{
 text-decoration-line: none
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
				ID: <input type='text' name='cId' size="10">
				PW: <input type='password' name='cPw' size="10">
				<input id="button" type='submit' value='Login'>
			</form>
			</nav>
		</c:when>
		<c:otherwise>
		<nav>  <!--상세정보 , 로그아웃, 장바구니 일자배열 해야함  -->
			${sessionScope.cName }님(${sessionScope.authority }), 환영합니다.<br>
			<form id ="form" action="customerSearch.do" method='get'>
				<input type='hidden' name='cId' value='${sessionScope.cId }'>
				<input type='hidden' name='job' value='search'> 
				<input id="button" type='submit' value='상세정보'>
			</form>
			
			<form action="${pageContext.request.contextPath }/logout.do" method='get'>
				<input id="button" type='submit' value='로그아웃'>
			</form>
			<form action="ordCustomerList.do" method='get'>
				<input type='hidden' name='cId' value='${sessionScope.cId }'>
				<input id="button" type='submit' value='장바구니'>
			</form>
			</nav>
		</c:otherwise>
	</c:choose>
	
</header>
	<!--컨트롤 바-->
	<section>
	<hr>
	<a href='${pageContext.request.contextPath }/productList.do'>전체상품</a>
	<a href='${pageContext.request.contextPath }/boardList.do'>게시판</a>
	
	<c:if test="${sessionScope.authority == '관리자' }">
			<a href="${pageContext.request.contextPath }/product/productInput.jsp">상품등록(관리자)</a>
			<a href='${pageContext.request.contextPath }/customerList.do'>회원목록(관리자)</a>
			<a href="${pageContext.request.contextPath }/ordList.do">전체주문(관리자)</a>
		</c:if>
	<a href='${pageContext.request.contextPath }/customer/customerInput.jsp'>회원가입</a>
	<hr>
</section>

</body>