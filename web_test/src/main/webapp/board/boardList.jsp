<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/boardList.jsp</title>
</head>
<body>
	<a href="board/boardInput.jsp">게시글 작성</a>
	<h1>게시판</h1>
	<table border='1'>
		<thead>
			<tr>
				<th>게시번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>상세보기</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${requestScope.boardList }">
			console.log(item);
				<form action="boardSearch.do" method='get'>
				<tr>
					<td>${item.bId }</td>
					<td>${item.bTitle }</td>
					<td>${item.cId }</td>
					<td>${item.bDate }</td>
					
					<td><input type='submit' value='상세보기'></td>
				<%-- 	<td><input type='hidden' name="tId" value='${item.tId }'></td> --%>
					<td><input type='hidden' name = "bId" value='${item.bId }'></td>
					<td><input type='hidden' name = 'job' value='search'></td>
				</tr>
				</form>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>