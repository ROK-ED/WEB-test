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
<a href="index.jsp">첫 페이지로</a>


<form action='../productInsert.do' method='post'>
		상품코드: <input type='text' name='pId'><br> 
		상품명: <input type='text' name='pName'><br> 
		판매가: <input type="number" name='originPrice'><br>
		할인가: <input type="number" name='salePrice'><br>  
		상세내용: <input type='text' name='pContent'><br> 
		이미지: <input type='text' name='pImage'><br> 
		<!-- 이미지: <input type='file' name='pImage'><br>  -->
		평점: <input type="text" name='review'><br>  
		<input type='submit' value='등록'>
	</form>

</body>
</html>