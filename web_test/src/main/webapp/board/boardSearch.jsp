<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardSearch</title>
</head>
<body>
<a href="index.jsp">첫 페이지로</a>
<form>

	<h1>게시글상세보기</h1>
		<div>게시번호: ${board.bId }</div>
		<div>제목:${board.bTitle }</div>
		<div>게시자:${board.cId } </div>
		<div>게시일${board.bDate }: </div>
		
	<div>
		내용:${board.bContent }
	</div>
	
		비밀번호: <input type='password' name='bPw'>
		<input type="hidden" name='bId' vlaue='${board.bId }'>
		<input type="hidden" name='bPw' vlaue='${board.bPw }'>
		<input type='submit' value='수정'>
		<input type='submit' value='삭제'>


</form>
</body>
</html>