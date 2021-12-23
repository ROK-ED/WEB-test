<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product/productInput.jsp</title>
<style>
#h3 {
	font-size: 30px; /* 글자크기 */
	text-align: center; /* 가운데 정렬  */
}
#text{
background-color: white; /* 전체 배경색  */
	color: black; /* 전체 글자색  */
	left: 30%;
	margin: 5px;
}
</style>
</head>
<body>
<jsp:include page="../menu.jsp"></jsp:include>

<form action='../productInsert.do' name="registerProduct"
			enctype="multipart/form-data" method='post'>

	<div id="h3"> 상품등록 </div>
	<table>
	<thead></thead>
	<tbody>
	<div>상품코드</div>
	<input id="text" type='text' name='pId'><br>
	<div >상품명</div>
	<input id="text" type="text" name='pName'><br>
	<div >판매가</div>
	<input id="text" type="number" name='originPrice'><br>
	<div >할인가</div>
	<input id="text" type="number" name='salePrice' value='0'><br>
	<div >입고수량</div>
	<input id="text" type="number" name='pCount'><br>
	<div >상세내용</div>
	<input id="text" type='text' name='pContent'><br>
	<div >이미지</div>
	<input type='file' name='pImage'><br>
	<div >평점</div>
	<input id="text" type="text" name='review'><br>  
		<input type='submit' value='등록'>
		</tbody>
	</table>
		<!-- 상품코드: <input type='text' name='pId'><br> 
		상품명: <input type='text' name='pName'><br> 
		판매가: <input type="number" name='originPrice'><br>
		할인가: <input type="number" name='salePrice' value='0'><br>  
		입고수량: <input type="number" name='pCount'><br>
		상세내용: <input type='text' name='pContent'><br> 
		이미지: <input type='text' name='pImage'><br> 
		이미지: <input type='file' name='pImage'><br>
		평점: <input type="text" name='review'><br>  
		<input type='submit' value='등록'> -->
		
	</form>

</body>
</html>