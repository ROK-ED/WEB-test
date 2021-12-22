<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer/customerSearchOutPut.jsp</title>
<!-- <link rel="stylesheet" href="customerSearchOutPut.css"> -->

<style>
* {
    box-sizing: border-box;
	background-color: black; /* 전체 배경색  */
	color: white; /* 전체 글자색  */

}
table {
	margin-left: auto; /* 가운데 정렬  */
	margin-right: auto; /* 가운데 정렬  */
	width: 80%; /* 테이블 가로 크기  */
	padding: 5px;
}

th, td {
/* 	color: white; */
	color:wihte;
}

tr{
	    height: 50px;
	
}
th {
	width: 60%;
	text-align: center; /* 글자 가운데 정렬  */
}

#h3 {
	font-size: 30px; /* 글자크기 */
	text-align: center; /* 가운데 정렬  */
	

}

#button1{
	float:right;
	background-color: white; /* 전체 배경색  */
	color: black; /* 전체 글자색  */
	border-radius: 5px;
}
</style>
</head>
<body>
<header>
	<jsp:include page="../menu.jsp"></jsp:include>
	</header>
	<div id="h3">회원 상세정보</div>

	<table>
		<thead></thead>
		<tbody>
			<tr>
				<th>아이디</th>
				<td>${customer.cId }</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>${customer.cPw }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${customer.cName }</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${customer.adr }</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${customer.phone }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${customer.email }</td>
			</tr>
			<tr>
				<th>가입일</th>
				<td>${customer.cDate }</td>
			</tr>
			<tr>
				<th>권한</th>
				<td>${customer.authority }</td>
			</tr>
		</tbody>
	</table>
	
	<!--  우측하단배열 해야함 -->
	<form action="customerSearch.do" method='get'>

		<input type='hidden' name='cId' value='${customer.cId }'>
		<input type='hidden' name='job' value='update'>
		<input id="button1" type='submit' value='정보수정'>
	</form>
	<form action="customerSearch.do" method='get'>
		<input type='hidden' name='cId' value='${customer.cId }'>
		<input type='hidden' name='job' value='delete'>
		<input id="button1" type='submit' value='탈퇴'>
	</form>
</body>
</html>