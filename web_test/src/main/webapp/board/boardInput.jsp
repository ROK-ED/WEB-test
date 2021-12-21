<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>


</style>
</head>
<body>
<header>
	<jsp:include page="../menu.jsp"></jsp:include>
</header>
<form action ='../boardInsert.do' method='post'>
	<input type="hidden" name='bId'>
	고객아이디: <input type='text' name='cId'><br>
	제목:<input type='text' name='bTitle'><br>
	내용:<input type='text' name='bContent'><br>
	게시글 비밀번호: <input type='password' name='bPw'><br>
	<input type='submit' value='등록'>
</form>

</body>
</html>