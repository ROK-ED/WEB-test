<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product/productInput.jsp</title>
</head>
<body>
<jsp:include page="../menu.jsp"></jsp:include>
<h3>상품등록</h3>

<form action='../productInsert.do' name="registerProduct"
			enctype="multipart/form-data" method='post'>
<!-- <form action='../productInsert.do' method='post'> -->
		상품코드: <input type='text' name='pId'><br> 
		상품명: <input type='text' name='pName'><br> 
		판매가: <input type="number" name='originPrice'><br>
		할인가: <input type="number" name='salePrice' value='0'><br>  
		입고수량: <input type="number" name='pCount'><br>
		상세내용: <input type='text' name='pContent'><br> 
		<!-- 이미지: <input type='text' name='pImage'><br>  -->
		이미지: <input type='file' name='pImage'><br>
		평점: <input type="text" name='review'><br>  
		<input type='submit' value='등록'>
		
	</form>

</body>
</html>