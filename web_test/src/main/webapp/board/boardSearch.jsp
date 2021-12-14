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

<form>
	<div>
		<div>게시번호: <%=request.getAttribute("bId") %></div>
		<div>제목: <%=request.getAttribute("bTitle") %></div>
		<div>게시자:<%=request.getAttribute("cId") %> </div>
		<div>게시일:<%=request.getAttribute("bDate") %> </div>
	</div>	
	<div>
		<%=request.getAttribute("bContent") %>
	</div>
	
		비밀번호: <input type='password' name='bPw'>
		
		<input type='submit' value='수정'>
		<input type='submit' value='삭제'>


</form>
</body>
</html>