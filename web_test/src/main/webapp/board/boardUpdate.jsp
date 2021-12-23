<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#h3 {
	font-size: 30px; /* 글자크기 */
	text-align: center; /* 가운데 정렬  */

}
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
#text{
background-color: white; /* 전체 배경색  */
	color: black; /* 전체 글자색  */
}
</style>
</head>
<body>
<header>
		<jsp:include page="../menu.jsp"></jsp:include>
	</header>
	<div id="h3">상세보기</div>
	<table>
	<thead></thead>
	<tbody>
	<form action='boardUpdate.do' name="registerBoard" method = 'post'>
		<tr>
		<th>게시번호</th>
		<td><input type='hidden' name='bId' value= '${board.bId }'>${board.bId }</td>
		</tr>
		<tr>
		<th>게시자</th>
		<td><input type='hidden' name='cId' value = '${board.cId }'>${board.cId }</td>
		</tr>
		
		<tr>
		<th>게시일</th>
		<td><input type='hidden' name='bDate' value = '${board.bDate }'>${board.bDate }</td>
		</tr>
		<tr>
		<th>제목</th>
		<td><input id='text' type='text' name='bTitle' value='${board.bTitle }'></td>
		</tr>
		<tr>
		<th>내용</th>
		<td><input id='text' type='text' name='bContent' value='${board.bContent }'></td>
		</tr>
		<tr>
		<th>비밀번호</th>
		<td><input type='hidden' name='bPw' value='${board.bPw }'>${board.bPw }</td>
		</tr>
		<tr>
		<th></th>
		<td><input id="button1" type='submit' value='수정'></td>
		</form>
		</tbody>
		</table>
</body>
</html>