<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer/customerSearchOutPut.jsp</title>
<link rel="stylesheet" href="customerSearchOutPut.css">

<style>
* {
	/* background-color: gray;  블랙변경 */
}

}
table {
	width: 100%;
	text-align: center;
/* 	color: white;
 */}

th, td {
/* 	color: white; */
}

th {
	width: 30%;
}

#h3 {
	/* color: white; */
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
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
		<input type='hidden' name='cId' value='${customer.cId }'> <input
			type='hidden' name='job' value='update'> <input type='submit'
			value='정보수정(관리자)'>
	</form>
	<form action="customerSearch.do" method='get'>
		<input type='hidden' name='cId' value='${customer.cId }'> <input
			type='hidden' name='job' value='delete'> <input type='submit'
			value='탈퇴(관리자)'>
	</form>
</body>
</html>