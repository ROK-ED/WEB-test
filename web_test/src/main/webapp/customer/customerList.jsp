<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer/customerList.jsp</title>
<!-- <link rel="stylesheet" href="customerList.css"> -->
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
	text-align: center; /* 글자 가운데 정렬  */
}

#h3 {
	font-size: 30px; /* 글자크기 */
	text-align: center; /* 가운데 정렬  */
}

th, td {
	/* color: white; */
	
}
#button{
	border-radius: 5px;
	background-color: white;
        color:black;
}
 

</style> 
</head>
<body>
<header>
	<jsp:include page="../menu.jsp"></jsp:include>
</header>
<section>
	<div id="h3">회원목록</div>
	<table id="table" border='1'>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>권한</th>
				<th>상세정보</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="customer" items="${requestScope.customerList }">
				<tr>
					<td>${customer.cId }</td>
					<td>${customer.cName }</td>
					<td>${customer.authority }</td>
					<td>
						<form action="customerSearch.do" method='get'>
							<input type='hidden' name='cId' value='${customer.cId }'>
							<input type='hidden' name='job' value='search'>
							<input id="button" type='submit' value='상세정보'>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</section>
</body>
</html>