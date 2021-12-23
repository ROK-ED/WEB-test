<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer/customerUpdateForm.jsp</title>
<!-- <link rel="stylesheet" href="customerUpdate.css">-->
<style>
table {
	margin-left: auto; /* 가운데 정렬  */
	margin-right: 60%; /* 가운데 정렬  */
	width: 50%; /* 테이블 가로 크기  */

}

th {
	width: 20%;
}
#button1{
	float:right;
	background-color: white; /* 전체 배경색  */
	color: black; /* 전체 글자색  */
	border-radius: 5px;
}
td{
background-color: white;
	color:black;
	width: 40%
}
#val{
 background-color: white;
	color:black;
	border:0px;
}
#h3 {
	font-size: 30px; /* 글자크기 */
	text-align: center; /* 가운데 정렬  */
}

#test{
background-color: black;
color:white;
}

</style>
</head>

<body>
	<header>
		<jsp:include page="../menu.jsp"></jsp:include>
	</header>
	<div id="con">
	<div id="h3">회원정보수정</div>
		<table>
			<thead></thead>
			<tbody>
				<form action="customerUpdate.do" method="post">
					<tr>
						<th>아이디</th>
						<td id= "test"><input  type="hidden" name='cId' value='${customer.cId }'>${customer.cId }</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input id="val" type='password' name='cPw' value='${customer.cPw }'></td>
					</tr>
					<tr>
						<th>이름</th>
						<td id= "test" ><input type="hidden" name='cName' value='${customer.cName }'>${customer.cName }</td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input id="val" type='text' name='adr' value='${customer.adr }'></td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><input id="val" type='text' name='phone' value='${customer.phone }'></td>
					</tr>
					<tr>
						<th>E-mail</th>
						<td><input id="val" type='email' name='email' value='${customer.email }'>
							
					</tr>
					<tr>
					<th></th>
					<td id="test">
					<input type="hidden" name='cDate' value='${customer.cDate }'> <%-- ${customer.cDate } --%>
					<input type="hidden" name='authority' value='${customer.authority }'><%-- ${customer.authority } --%>
					<input id="button1" type='submit' value='수정'></td>
					</td>
					</tr>
				</form>
			</tbody>
		</table>
	</div>
	



	<%-- 		아이디 : <input type="hidden" name='cId' value='${customer.cId }'>${customer.cId }<br>
		비밀번호 : <input type='password' name='cPw' value='${customer.cPw }'><br> 
		이름 : <input type="hidden" name='cName' value='${customer.cName }'>${customer.cName }<br> 
		주소 : <input type='text' name='adr' value='${customer.adr }'><br> 
		연락처 : <input type='text' name='phone' value='${customer.phone }'><br>
		E-mail : <input type='email' name='email' value='${customer.email }'><br>
	    가입일 : <input type="hidden" name='cDate' value='${customer.cDate }'>${customer.cDate }<br>
		권한 : <input type="hidden" name='authority' value='${customer.authority }'>${customer.authority }<br>
 --%>
</body>
</html>