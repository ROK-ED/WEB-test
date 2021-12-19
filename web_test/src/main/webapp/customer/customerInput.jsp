<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer/customerInput.jsp</title>
<link rel="stylesheet" href="customerInput.css">
</head>
<body>
<%-- <jsp:include page="../menu.jsp"></jsp:include> --%><div id="cuscon">
	<form action='../customerInsert.do' method='post'>
	<div><h1>회원가입</h1></div>
		<div id="text">회원구분</div>
		<div>
		<input type="radio" name="authority" value="일반회원" checked>일반회원
		<input type="radio" name="authority" value="관리자">관리자
		</div>
		<div id="text">아이디</div>
		<input id="val" type='text' name='cId' size="10"><br> 
		<div id="text">비밀번호</div>
		<input id="val" type='password' name='cPw' size="10" ><br> 
		<div id="text">이름</div>
		<input id="val" type='text' name='cName' size="10" ><br> 
		<div id="text">주소</div>
		<input id="val" type='text' name='adr' size="10" ><br> 
		<div id="text">연락처</div>
		<input id="val" type='text' name='phone' size="10"><br>
		<!--가입일은 디폴트로  -->
		<div id="text">E-mail</div>
		<input id="val" type='email'	name='email' size="10"><br>
		<input type='submit' value='가입'>
	</form>
</div>
</body>
</html>