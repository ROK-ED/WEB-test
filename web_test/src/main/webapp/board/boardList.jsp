<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/boardList.jsp</title>
</head>
<body>
<a href="board/boardInput.jsp">상품등록</a>
	<h1>게시판</h1>
	<table border='1'>
		<thead>
			<tr>
				<th>게시번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
			</tr>
		</thead>
		<tbody>
		 	<c:forEach var="item" items="${requestScope.boardList }">
		 	
				<tr style = "cursor:'pointer'" onclick = "">
					<td>${item.bId }</td>
					<td>${item.bTitle }</td>
					<td>${item.cId }</td>
					<td>${item.bDate }</td>
				</tr>
				 			
			</c:forEach> 
		</tbody>
	</table>
</body>
</html>