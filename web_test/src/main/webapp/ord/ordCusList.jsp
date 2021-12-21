<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ord/ordCusList.jsp</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<h3>전체 주문 확인</h3>

	<table border='1'>
		<thead>
			<tr>
				<!-- <th>장바구니번호</th> -->
				<th>상품번호</th>
				<th>주문고객</th>
				<th>장바구니등록일</th>
				<th>상태</th>
				<th>구매수량</th>
				<th>추가기능</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ord" items="${requestScope.ordCusList }">
				<tr>
					<%-- <td>${ord.oId }</td> --%>
					<td>${ord.pId }</td>
					<td>${ord.cId }</td>
					<td>${ord.oDate }</td>
					<td>${ord.oState }</td>
					<td>${ord.oCount }</td>
					<td>
					<c:choose>
						<c:when test="${ord.oState == '주문' }">	
							<form action="ordUpdate.do" method='get'>
								<input type="number" name='oCount' value='${ord.oCount }'>
								<input type='hidden' name='oId' value='${ord.oId }'> 
								<input type='hidden' name='pId' value='${ord.pId }'>
								<input type='submit' value='수정'>
							</form>
							<form action="ordDelete.do" method='get'>
								<input type="hidden" name='oCount' value='${ord.oCount }'>
								<input type='hidden' name='oId' value='${ord.oId }'> 
								<input type='hidden' name='pId' value='${ord.pId }'>
								<input type='submit' value='삭제'>
							</form>
						</c:when>
						<c:otherwise>
							주문하신 상품이 발송되었습니다.
						</c:otherwise>
					</c:choose>
						
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>