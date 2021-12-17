<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp">첫 페이지로</a>
<form action ='../boardInsert.do' method='post'>
	게시번호: <input type='text' name='bId'><br> <!-- 자동생성?  -->
	고객아이디: <input type='text' name='cId'><br>  <!-- 로그인하면 가져오는기능 -->
	게시글 비밀번호: <input type='password' name='bPw'><br>
	제목:<input type='text' name='bTitle'><br>
	내용:<input type='text' name='bContent'><br>
	<input type='submit' value='등록'>
</form>

</body>
</html>