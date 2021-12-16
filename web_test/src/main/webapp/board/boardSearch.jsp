<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<div>게시자:${board.cId }</div>
		<div>게시일${board.bDate }:</div>

		<div>내용:${board.bContent }</div>

		비밀번호: <input type='password' name='bPw'>
		<form action="boardSearch.do" method='get'>
			<input type='hidden' name="bId" value='${board.bId }'>
			<input type='hidden' name="bPw" value='${board.bPw }'>
			<input type='hidden' name='job' value='update'>
			<input type='submit' value='수정'>
		</form>
		<form action="boardSearch.do" method='get'>
			<input type='hidden' name="bId" value='${board.bId }'>
			<input type='hidden' name="bPw" value='${board.bPw }'>
			<input type='hidden' name='job' value='delete'>
			<input type='submit' value='삭제'>

			<div>댓글</div>
			<table>
				<thead>
					<tr>
						<td>댓글순번</td>
						<td>댓글내용</td>
						<td>글쓴이</td>
						<td>작성일자</td>
					</tr>
				</thead>
				<tbody>
				<form>
					<c:forEach var="cmitem" items="${requestScope.cmList }">
					<tr>
					<td>${cmitem.cmId }</td>
					<td>${cmitem.cmContent }</td>
					<td>${cmitem.cId }</td>
					<td>${cmitem.cmDate }</td>
					</tr>
					</c:forEach>
				</form>
				<form>
				<input type ="hidden" name='job_c' value='update'>
				<input type = 'submit' value="댓글수정">
				</form>
				<form>
				<input type ="hidden" name='job_c' value='delete'>
				<input type = 'submit' value='댓글삭제'>
				</form>
				</tbody>
				<form>
				<input type='text' name='cmContent'>
				<input type="hidden" name='job_c' value='insert'>
				<input type='submit' value='댓글등록'>
				</form>
			</table>
			
		</form>
</body>
</html>