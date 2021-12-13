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
	<!-- 상단 menu -->
	<!--  아이디 확인  -->

	<a href="../index.jsp">첫 페이지로</a>
	<h3>상품목록</h3>
	<div id="List">
		<c:forEach var="item" items="${requestScope.productList }">
			<ul>
				<li>상품코드: ${item.pId }</li>
				<li>상품명: ${item.pName }</li>
				<li>판매가: ${item.originPrice }</li>
				<li>할인가: ${item.salePrice }</li>
				<li>상세내용: ${item.pContent }</li>
				<li>이미지링크: ${item.pImage }</li>
				<li>평점: ${item.review }</li>
			</ul>
		</c:forEach>
	</div>

	<!-- 하단 footer  -->
</body>
</html>