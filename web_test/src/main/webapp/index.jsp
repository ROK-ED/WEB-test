<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<h3>시작화면</h3>
<h3>${sessionScope.cName }님, 환영합니다.</h3>


</body>
</html>
