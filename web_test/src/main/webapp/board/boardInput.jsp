<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#root {
	text-align: center; /* 가운데 정렬  */
}

#h3 {
	font-size: 30px; /* 글자크기 */
	text-align: center; /* 가운데 정렬  */
}

#button1 {
	background-color: white; /* 전체 배경색  */
	color: black; /* 전체 글자색  */
	border-radius: 5px;
}

#text {
	background-color: white; /* 전체 배경색  */
	color: black; /* 전체 글자색  */
	left: 30%;
	margin: 5px;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="../menu.jsp"></jsp:include>
	</header>
	<div id="h3">게시글 작성</div>
	<table>
		<thead></thead>
		<tbody>
			<form action='../boardInsert.do' method='post'>
				<tr>
					<th>고객아이디</th>
					<td><input id="text" type="hidden" name='bId'> <input
						id="text" type='text' name='cId'></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input id="text" type='text' name='bTitle'></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea id="text" cols="50" rows="10" name='bContent'>
	</textarea></td>
				</tr>
				<tr>
					<th>게시글 비밀번호</th>
					<td><input id="text" type='password' name='bPw'></td>
				</tr>
			</form>
		</tbody>
	</table>

	<div id="root">
		<input id="button1" type='submit' value='등록'>
	</div>


</body>
</html>