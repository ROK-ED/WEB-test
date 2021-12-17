<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product/productUpdateForm.jsp</title>
</head>
<body>
<jsp:include page="../menu.jsp"></jsp:include>

<form action='productUpdate.do' name="registerProduct"
			enctype="multipart/form-data" method='post'>
		상품코드 : <input type="hidden" name='pId' value='${product.pId }'>${product.pId }<br>
		상품명 : <input type='text' name='pName' value='${product.pName }'><br> 
		판매가 : <input type="number" name='originPrice' value='${product.originPrice }'><br>
		할인가 : <input type="number" name='salePrice' value='${product.salePrice }'><br>  
		입고수량 : <input type="number" name='pCount' value='${product.pCount }'><br>
		상세내용 : <input type='text' name='pContent' value='${product.pContent }'><br> 
		이미지 : <input type='file' name='pImage' value='upload/${product.pImage }'><br><!--수정시 이전 이미지 들고오는법  -->
		평점 : <input type="text" name='review' value='${product.review }'><br> 
		<input type='submit' value='수정'>
	</form>

</body>
</html>