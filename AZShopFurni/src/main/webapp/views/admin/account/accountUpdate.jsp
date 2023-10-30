<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="adminUpdateAccount" method="post">
	<input type="text" value="${account.userID}" name="userID" readonly="readonly">
	<input type="text" value="${account.userName}" name="userName" >
	<input type="text" value="${account.password}" name="password" >
	<input type="submit" value="UPDATE">
	</form>

</body>
</html>