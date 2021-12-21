<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/boardList.jsp</title>
<style >
#h3 {
	font-size: 30px; /* 글자크기 */
	text-align: center; /* 가운데 정렬  */
	}
table {
	margin-left: auto; /* 가운데 정렬  */
	margin-right: auto; /* 가운데 정렬  */
	width: 80%; /* 테이블 가로 크기  */
	text-align: center;
}
#button1{
	background-color: white; /* 전체 배경색  */
	color: black; /* 전체 글자색  */
	border-radius: 5px;
}
#foot{
float:right;
}
#btn{
background-color: white; /* 전체 배경색  */
	color: black; /* 전체 글자색  */	
	border-radius: 5px;
}
</style>
</head>
<body>
<header>
	<jsp:include page="../menu.jsp"></jsp:include>
</header>
<section>
	
	<div id="h3">게시판 목록</div>
	<div>
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
				<form action="boardSearch.do" method='get'>
				<tr>
					<td>${item.bId }</td>
					<td>${item.bTitle }</td>
					<td>${item.cId }</td>
					<td>${item.bDate }</td>
					<td><input id = "btn" type='submit' value='상세보기'></td>
					<input type='hidden' name = "bId" value='${item.bId }'>
					<input id="button1" type='hidden' name = 'job' value='search'>
				</tr>
				</form>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</section>
	<div id="foot">
	<button id="btn"><a id="btn" href="board/boardInput.jsp">게시글 작성</a></button>
	</div>
</body>
</html>