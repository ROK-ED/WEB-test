<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product/productSearchOutPut.jsp</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	
	<h3>제품 상세정보</h3>
	<form action="productSearch.do" method='get'>
		<input type='hidden' name='pId' value='${product.pId }'> 
		<input type='hidden' name='job' value='update'> 
		<input type='submit' value='제품수정(관리자)'>
	</form>
	<form action="productSearch.do" method='get'>
		<input type='hidden' name='pId' value='${product.pId }'> 
		<input type='hidden' name='job' value='delete'> 
		<input type='submit' value='제품삭제(관리자)'>
	</form>
	<!--장바구니  -->
	<form action="ord"></form>	
	<div>
		<p><img src="upload/${product.pImage }"></p>
		<p><strong>상품코드 : </strong>${product.pId }</p>
		<p><strong>상품명 : </strong>${product.pName }</p>
		<p><strong>판매가 : </strong>${product.originPrice }</p>
		<p><strong>할인가 : </strong>${product.salePrice }</p>
		<p><strong>재고 : </strong>${product.pCount }</p>
		<p><strong>상세내용 : </strong>${product.pContent }</p>
		<p><strong>평점 : </strong>${product.review }</p>
		<c:if test="${sessionScope.cId != null}">
			<form action="ordInsert.do" method='get'>
				<input type='hidden' name='pId' value='${product.pId }'>
				<p>구매수량 : <input type= "number" name='oCount' value="1"></p>
				<input type='hidden' name='cId' value='${sessionScope.cId }'>
				<input type='submit' value='장바구니담기'>
			</form>
		</c:if>
		
	</div>
</body>
</html>