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
		<div>게시일${board.bDate }</div>
		<div>내용:${board.bContent }</div>

		비밀번호: <input type='password' name='bPw'>
		<form action="boardSearch.do" method='get'>
			<input type='hidden' name="bId" value='${board.bId }'>
			<input type='hidden' name="bPw" value='${board.bPw }'>
				<input type='hidden' name='job' value='update'>
				<input type='submit' value='수정'>
		</form>
		<form action="boardSearch.do" method='post'>
			<input type='hidden' name="bId" value='${board.bId }'>
			<input type='hidden' name="bPw" value='${board.bPw }'>
			<input type='hidden' name='job' value='delete'>
			<input type='submit' value='삭제'>
		
		</form>
		<form>
		<div>댓글</div>
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
				<form action='commInsert.do' method='post'>
					<c:forEach var="items" items="${requestScope.commList }">
						<tr> 
							<td>${items.cmContent }</td>
							<td>${items.cId }</td>
							<td>${items.cmDate }</td>
							<input type = "hidden" name="tId" value='${items.tId}'>
							<input type = "hidden" name="cPw" value='${items.cPw }'>
							<input type="hidden" name = 'cmId' value='${items.cmId }'>
							<input type="hidden" name="job" value='delete'>
							<td><input type="password" name="cPw">
							<input type='submit' value='삭제'></td>
						</tr>
					</c:forEach>
				</form>
			</tbody>
			</table>	
			<form action='commInsert.do' method='post'>
			<br><br>댓글등록<br>
			<input type="hidden" name = 'cmId' value='${comm.cmId }' > <!--cmId  -->
			<input type="hidden" name = 'tId' value="${comm.tId }" > <!-- bId -->
			<input type="hidden" name = 'cId' value='${comm.cId }'> <!-- cId -->
			<input type="hidden" name = 'cmDate' value='${comm.cDate }'> <!-- cDate  -->
			내용 :<input type='text' name='cmContent'> <!-- cmContent -->
			비밀번호:<input type='password' name='cPW'> <!-- cPw -->
			<input type='hidden' name='job' value='insert'>
			<input type='submit' value='등록'><br>
			</form>
		
</body>
</html>