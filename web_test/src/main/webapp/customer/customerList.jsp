<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer/customerList.jsp</title>
<link rel="stylesheet" href="customerList.css"> <!--  왜적용이 안되지?? -->
<style>
*{
	/* background-color: gray;   블랙변경 예정 */
    color: white;
}
table{
  width: 100%;
  text-align: center;
/*   color: white; */
}
#h3{
	color: white;		
	text-align: center;
}
th,td{
/* color: white; */
}

/* 버튼 이미지 변경 요청 */


</style>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>

	<div id="h3">회원목록</div>
	<table id = "table" border='1'>
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
							<input type='submit' value='상세정보'>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>