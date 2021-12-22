<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer/customerSearchOutPut.jsp</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<h3>회원 상세정보</h3>
	<form action="customerSearch.do" method='get'>
			<input type='hidden' name='cId' value='${customer.cId }'> 
			<input type='hidden' name='job' value='update'> 
			<input type='submit' value='정보수정'>
	</form>
	<form action="customerSearch.do" method='get'>
		<input type='hidden' name='cId' value='${customer.cId }'> 
		<input type='hidden' name='job' value='delete'> 
		<input type='submit' value='탈퇴'>
	</form>
	<div>
		<p><strong>아이디 : </strong>${customer.cId }</p>
		<p><strong>비밀번호 : </strong>${customer.cPw }</p>
		<p><strong>이름 : </strong>${customer.cName }</p>
		<p><strong>주소 : </strong>${customer.adr }</p>
		<p><strong>전화번호 : </strong>${customer.phone }</p>
		<p><strong>이메일 : </strong>${customer.email }</p>
		<p><strong>가입일 : </strong>${customer.cDate }</p>
		<p><strong>권한 : </strong>${customer.authority }</p>
		
	</div>
</body>
</html>