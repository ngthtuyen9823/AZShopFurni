<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
			<label>Tên:</label> <input type="text" name="ten">
		</div>
		<div class="form-row">
			<label>Mô tả:</label> <input type="text" name="mota">
		</div>
		<div class="form-row">
			<label >Nguồn gốc:</label> <input type="text" name="ngg">
		</div>
		<div class="form-row">
			<label >NCC:</label> <select name="ncc">
				<option value="">-- Chọn ncc --</option>
				<c:forEach var="ncc" items="${danhsachncc}">
					<option value="${ncc.getSupplierID()}">${ncc.getSupplierName()}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-row">
			<label >Loại:</label> <select name="loai">
				<option value="">-- Chọn loại --</option>
				<c:forEach var="loai" items="${danhsachLoai}">
					<option value="${loai.getCategoryID()}">${loai.getCategoryName()}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-row">
			<label for="Mat">Nguyên liệu:</label> <input type="text" name="ngl">
		</div>
		<div class="form-row">
			<input type="submit" value="Submit">
		</div>
	</form>



</body>
</html>