<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>product/productList.jsp</title>
	<style>
		#List{
			margin:  0;
			/* border: 1px solid rgba(128, 128, 128, 0.253); */
		}

		.products{
			display: inline-block;
			border: 2px solid white;
			width: 300px;
			height: 300px;
		 }

		ul{
			list-style: none;
			z-index: 0;
		}
		
		ul img{
			width: 200px;
			height: 150px;
		}
		
		ul input{
		
		background-color: rgba(255, 0, 0, 0);
		color: rgba(255, 0, 0, 0);
		position: relative;
		top: -235px;
		left: -42px;
		z-index: 1;
		width: 300px;
		height: 300px;
		}

	</style>
</head>

<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<!--  아이디 확인  -->

	<div id="List">
		<h3>상품목록</h3>
		<c:forEach var="product" items="${requestScope.productList }">
			<div class="products">
				<form action="productSearch.do" method='get'>
					<ul>
						<%-- <li>재고수량: ${product.pCount }</li> --%>
						<%-- <li>상세내용: ${product.pContent }</li> --%>
						<li><img src="upload/${product.pImage }"></li>
						<li>상품명: ${product.pName }</li>
						<li>평점: ${product.review }</li>
						<li>판매가: ${product.originPrice }
						<c:if test="${product.salePrice != 0 }">
							<sale>할인가: ${product.salePrice }</sale>
						</c:if>
						</li>
						<%-- <li name='pId'>상품코드: ${product.pId }</li> --%>
						<input type='hidden' name='pId' value='${product.pId }'>
						<input type='hidden' name='job' value='search'>
						<input type='submit' value='제품상세보기'>
					</ul>
				</form>
			</div>
		</c:forEach>
	</div>

	<!-- 하단 footer  -->
</body>

</html>