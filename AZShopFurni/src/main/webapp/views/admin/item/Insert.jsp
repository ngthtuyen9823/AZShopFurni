<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<style>
.form-row {
	margin-bottom: 10px;
}

.form-row label {
	display: inline-block;
	width: 100px;
}

.form-row input, .form-row select {
	width: 200px;
}
</style>
	<br>
	<br>
	<form action="insert" method="post">
		<div class="form-row">
			<label>Màu sắc: </label> <input type="text" name="mausac">
		</div>
		<div class="form-row">
			<label>Mã màu:</label> <input type="text" name="mamau">
		</div>
		<div class="form-row">
			<label>Kích thước:</label> <input type="text" name="kichthuoc">
		</div>
		<div class="form-row">
			<label>Tồn kho:</label> <input type="text" name="tonkho">
		</div>
		<div class="form-row">
			<label>Giá gốc:</label> <input type="number" name="giagoc">
		</div>
		<div class="form-row">
			<label>Giá khuyến mãi:</label> <input type="number" name="giakm">
		</div>
		<div class="form-row">
			<input type="submit" value="Submit">
		</div>
	</form>
</body>
</html>