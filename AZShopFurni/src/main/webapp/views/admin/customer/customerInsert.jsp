<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="adminInsertCustomer" method="post">
		<label>First Name:</label>
		<input type="text" name="firstName">
		<br>
		<label>Last Name:</label>
		<input type="text" name="lastName">
		<br>
		<label>Address:</label>
		<input type="text" name="address">
		<br>
		<label>Gender:</label>
		<input type="number" name="gender">
		<br>
		<label>Phone:</label>
		<input type="text" name="phone">
		<br>
		<label>Dob:</label>
		<input type="date" name="dob">
		<br>
		<label>Cid:</label>
		<input type="text" name="cid">
		<br>
		<label>Avatar:</label>
		<input type="text" value="https://s.net.vn/6OoR" name="avatar">
		<br>
		<label>Email:</label>
		<input type="text" name="email">
		<br>
		<input type="submit" value="INSERT CUSTOMER">
	</form>

</body>
</html>