<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menu.jsp</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/index.jsp">첫 페이지로</a>
<a href='${pageContext.request.contextPath }/productList.do'>전체상품</a>
<a href="${pageContext.request.contextPath }/product/productInput.jsp">상품등록(관리자)</a>
<a href='${pageContext.request.contextPath }/boardList.do'>게시판</a>
<a href='${pageContext.request.contextPath }/customerList.do'>회원목록(관리자)</a>
<a href='${pageContext.request.contextPath }/customer/customerInput.jsp'>회원가입</a>
 ${sessionScope.authority }
<form action="login.do" method="post">
ID: <input type='text' name='cId'><br>
PW: <input type='password' name='cPw'><br>
<input type='submit' value='Login'>
</form>

</body>
</html>