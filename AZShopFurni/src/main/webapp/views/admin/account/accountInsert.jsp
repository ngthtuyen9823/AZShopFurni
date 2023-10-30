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
	<form action="adminInsertAccount" method="post">
	<input type="text" name="userID">
	<input type="text" name="userName" >
	<input type="text" name="password" >
	<input type="submit" value="INSERT">
	</form>

</body>
</html>