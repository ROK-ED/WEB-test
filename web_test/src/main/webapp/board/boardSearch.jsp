<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardSearch</title>
<style>
table {
	margin-left: auto; /* 가운데 정렬  */
	margin-right: auto; /* 가운데 정렬  */
	width: 80%; /* 테이블 가로 크기  */
}

th, td {
/* 	color: white; */
	color:wihte;
}

th {
	width: 20%;
	text-align: center; /* 글자 가운데 정렬  */
}

#h3 {
	font-size: 30px; /* 글자크기 */
	text-align: center; /* 가운데 정렬  */
}

#button1{
	float:right;
	background-color: white; /* 전체 배경색  */
	color: black; /* 전체 글자색  */
	border-radius: 5px;
}
#text {
	background-color: white; /* 전체 배경색  */
	color: black; /* 전체 글자색  */
	}
</style>
</head>
<body>

	<header>
		<jsp:include page="../menu.jsp"></jsp:include>
	</header>
	<table>
	<div id="h3">게시글 상세보기</div>
		<thead></thead>
		<tbody>
			<tr>
				<th>게시번호</th>
				<td>${board.bId }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.cId }</td>
			</tr>
			<tr>
				<th>게시일</th>
				<td>${board.bDate }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${board.bTitle }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${board.bContent }</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input id="text" type='password' name='bPw'>
					<form action="boardSearch.do" method='get'>
						<input type='hidden' name="bId" value='${board.bId }'>
						<input type='hidden' name="bPw" value='${board.bPw }'>
						<input type='hidden' name='job' value='update'>
						<input id="button1" type='submit' value='수정'>
							
					</form>
					<form action="boardSearch.do" method='post'>
						<input type='hidden' name="bId" value='${board.bId }'>
						<input type='hidden' name="bPw" value='${board.bPw }'>
						<input type='hidden' name='job' value='delete'>
						<input id="button1" type='submit' value='삭제'>
					</form></td>
			</tr>

		</tbody>
	</table>
	<div id="h3">댓글</div>
	<table border='1'>
		<thead>
			<form>
				<tr>
					<td>댓글내용</td>
					<td>작성자</td>
					<td>작성일</td>
					<td>비밀번호 / 삭제</td>
				</tr>
			</form>
		</thead>

		<tbody>
			<form action='commInsert.do' method='post'>  <!--  여기를 겟?? -->
				<c:forEach var="items" items="${requestScope.commList }">
					<tr>
						<td>${items.cmContent }</td>
						<td>${items.cId }</td>
						<td>${items.cmDate }</td>
						<input type="hidden" name="tId" value='${items.tId}'>
						<input type="hidden" name="cPw" value='${items.cPw }'>
						<input type="hidden" name='cmId' value='${items.cmId }'>
						<input type="hidden" name="job" value='delete'>
						<td><input id="text" type="password" name="cPw">
						<input type='submit' value='삭제'></td>
					</tr>
				</c:forEach>
			</form>
		</tbody>
	</table>
	<table>
	<thead></thead>
	<tbody>
	<form action='commInsert.do' method='post'>
		<div id='h3'>댓글등록</div>
		<tr>
		<th>내용</th>
<%-- 		 <input type="hidden" name='cmId' value='${comm.cmId }'> --%>
		 <input type="hidden" name='tId' value='${board.bId }'>
		 <input type="hidden" name='cId' value='${board.cId }'>
		 <%-- <input type="hidden" name='cmDate'	value='${comm.cDate }'> --%>
		<td>
		<input id="text" type='text' name='cmContent'>
		</td>
		<th>비밀번호</th>
		<td><input id="text" type='password' name='cPw'></td>
		<input type='hidden' name='job' value='insert'>
		<input id="button1" type='submit' value='등록'>
		</tr>
	</form>
	
	</tbody>
</table>
</body>
</html>