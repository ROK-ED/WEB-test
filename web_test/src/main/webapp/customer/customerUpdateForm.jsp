<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer/customerUpdateForm.jsp</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>

	<form action="customerUpdate.do" method="post">
		아이디 : <input type="hidden" name='cId' value='${customer.cId }'>${customer.cId }<br>
		비밀번호 : <input type='password' name='cPw' value='${customer.cPw }'><br> 
		이름 : <input type="hidden" name='cName' value='${customer.cName }'>${customer.cName }<br> 
		주소 : <input type='text' name='adr' value='${customer.adr }'><br> 
		연락처 : <input type='text' name='phone' value='${customer.phone }'><br>
		E-mail : <input type='email' name='email' value='${customer.email }'><br>
	    가입일 : <input type="hidden" name='cDate' value='${customer.cDate }'>${customer.cDate }<br>
		권한 : <input type="hidden" name='authority' value='${customer.authority }'>${customer.authority }<br>
		<input type='submit' value='수정'>
	</form>
</body>
</html>