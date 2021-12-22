<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ord/ordList.jsp</title>
<style>
#h3 {
	font-size: 30px; /* 글자크기 */
	text-align: center; /* 가운데 정렬  */
}

table {
	margin-left: auto; /* 가운데 정렬  */
	margin-right: auto; /* 가운데 정렬  */
	width: 80%; /* 테이블 가로 크기  */
	text-align: center;
}

</style>
</head>
<body>
<jsp:include page="../menu.jsp"></jsp:include>
<div id="h3">전체주문확인</div>

<table border='1'>
		<thead>
			<tr>
				<!-- <th>장바구니번호</th> -->
				<th>상품번호</th>
				<th>구매수량</th>
				<th>주문고객</th>
				<th>장바구니등록일</th>
				<th>상태</th>
				<th>발송완료</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ord" items="${requestScope.ordList }">
				<tr>
					<%-- <td>${ord.oId }</td> --%>
					<td>${ord.pId }</td>
					<td>${ord.oCount }</td>
					<td>${ord.cId }</td>
					<td>${ord.oDate }</td>
					<td>${ord.oState }</td>
					<td>
						<form action="아직미구현.do" method='get'>
							<input type='hidden' name='oId' value='${ord.oId }'>
							<input type='hidden' name='job' value='delete'> 
							<input type='submit' value='발송완료(업데이트 미구현)'>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>