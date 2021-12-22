<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product/productList.jsp</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<!--  아이디 확인  -->

	

	<h3>상품목록</h3>
	<div id="List">
		<c:forEach var="product" items="${requestScope.productList }">
			<form action="productSearch.do" method='get'>
				<ul>
					<%-- <li>재고수량: ${product.pCount }</li> --%>
					<%-- <li>상세내용: ${product.pContent }</li> --%>
					<li><img src="upload/${product.pImage }"></li>
					<li>상품명: ${product.pName }</li>
					<li>평점: ${product.review }</li>
					<li>판매가: ${product.originPrice }</li>
						<c:if test="${product.salePrice != 0 }">
					<li>할인가: ${product.salePrice }</li>
					</c:if> 
					<%-- <li name='pId'>상품코드: ${product.pId }</li> --%>
					<input type='hidden' name='pId' value='${product.pId }'>
					<input type='hidden' name='job' value='search'>
					<input type='submit' value='제품상세보기'>
				</ul>
			</form>
		</c:forEach>
	</div>

	<!-- 하단 footer  -->
</body>
</html>