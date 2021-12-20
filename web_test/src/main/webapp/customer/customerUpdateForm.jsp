<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer/customerUpdateForm.jsp</title>
<style>

*{
/* background-color: gray; */
}

#text{
background-color: white;
	margin: 19px 0;
    font-size: 14px;
    font-weight: 700;
}

#val{
	display: inline-block;
    position: relative;
    width: 100%;
    height: 29px;
    padding-right: 25px;
    line-height: 29px;
    background: #fff;
    font-size: 15px;
    box-sizing: border-box;
    border: 1px;
    }



</style>
</head>

<body>
	<jsp:include page="../menu.jsp"></jsp:include>

	<table>
	<form action="customerUpdate.do" method="post">
	
	<div id="text">아이디</div>
	<input id="val" size="10" type="hidden" name='cId' value='${customer.cId }'>${customer.cId }<br> 
	<div id="text">비밀번호</div>
	<input id="val" type='password' name='cPw' value='${customer.cPw }'><br> 
	<div id="text">이름</div>
	<input type="hidden" name='cName' value='${customer.cName }'>${customer.cName }<br> 
	<div id="text">주소</div>
	<input id="val" type='text' name='adr' value='${customer.adr }'><br> 
	<div id="text">연락처</div>
	<input id="val" type='text' name='phone' value='${customer.phone }'><br>
	<div id="text">E-mail</div>
	<input id="val" type='email' name='email' value='${customer.email }'><br>
	<input type='submit' value='수정'>	
	
	

	
<%-- 		아이디 : <input type="hidden" name='cId' value='${customer.cId }'>${customer.cId }<br>
		비밀번호 : <input type='password' name='cPw' value='${customer.cPw }'><br> 
		이름 : <input type="hidden" name='cName' value='${customer.cName }'>${customer.cName }<br> 
		주소 : <input type='text' name='adr' value='${customer.adr }'><br> 
		연락처 : <input type='text' name='phone' value='${customer.phone }'><br>
		E-mail : <input type='email' name='email' value='${customer.email }'><br>
	    가입일 : <input type="hidden" name='cDate' value='${customer.cDate }'>${customer.cDate }<br>
		권한 : <input type="hidden" name='authority' value='${customer.authority }'>${customer.authority }<br>
 --%>		
	</form>
	</table>
</body>
</html>