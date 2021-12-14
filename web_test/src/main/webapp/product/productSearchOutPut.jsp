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
	<a href="index.jsp">첫 페이지로</a>
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
	<div>
		<p><img src="upload/${product.pImage }"></p>
		<p><strong>상품코드 : </strong>${product.pId }</p>
		<p><strong>상품명 : </strong>${product.pName }</p>
		<p><strong>판매가 : </strong>${product.originPrice }</p>
		<p><strong>할인가 : </strong>${product.salePrice }</p>
		<p><strong>재고수량 : </strong>${product.pCount }</p>
		<p><strong>상세내용 : </strong>${product.pContent }</p>
		<p><strong>평점 : </strong>${product.review }</p>
		
	</div>
</body>
</html>