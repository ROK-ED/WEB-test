<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer/customerInput.jsp</title>
</head>
<body>
<jsp:include page="../menu.jsp"></jsp:include>
<form action='../customerInsert.do' method='post'>
		<input type="radio" name="authority" value="일반회원" checked>일반회원
		<input type="radio" name="authority" value="관리자">관리자<br>
		아이디: <input type='text' name='cId'><br> 
		비밀번호: <input type='password' name='cPw'><br> 
		이름: <input type='text' name='cName'><br> 
		주소: <input type='text' name='adr'><br> 
		연락처: <input type='text' name='phone'><br>
		<!--가입일은 디폴트로  -->
		E-mail: <input type='email'	name='email'><br> 
		<input type='submit' value='가입'>
	</form>

</body>
</html>