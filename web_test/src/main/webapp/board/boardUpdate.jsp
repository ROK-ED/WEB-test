<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp">첫 페이지로</a>
	<form action='boardUpdate.do' name="registerBoard" method = 'post'>
		<h1>상세보기</h1>
		<div>게시번호:<input type='hidden' name='bId' value= '${board.bId }'>${board.bId }</div>
 		<div>게시자:<input type='hidden' name='cId' value = '${board.cId }'>${board.cId }</div>
		<div>게시일:<input type='hidden' name='bDate' value = '${board.bDate }'>${board.bDate }</div>
		<div>제목:<input type='text' name='bTitle' value='${board.bTitle }'></div>
		<div>비밀번호:<input type='hidden' name='bPw' value='${board.bPw }'>${board.bPw }</div>
		<div>내용:<input type='text' name='bContent' value='${board.bContent }'>
		<input type='submit' value='수정'>
		</form>
</body>
</html>