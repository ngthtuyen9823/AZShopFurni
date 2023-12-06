<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap"
	rel="stylesheet">
<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/web/vendor/bootstrap/css/bootstrap.min.css"/>">
<!-- Style -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/web/css/login.css"/>">


<title>Đăng ký</title>
</head>

<body>



	<div class="login">
		<div class="contents">
			<div class="row align-items-center justify-content-center">
				<div class="col-md-9">
					<h3>
						<strong>Đăng ký tài khoản</strong>
					</h3>
					<h2>${exception}</h2>
					<form action="signup" method="post">
						<div class="row">
							<div class="form-group mb-1 w75">
								<label for="usernamesignup">Tên đăng nhập</label> <input
									type="text" class="form-control"
									placeholder="Nhập tên đăng nhập" name="usernamesignup"
									value="${usernamesignup}">
							</div>
						</div>
						<div class="row">

							<div class="form-group mb-1 w-50">
								<label for="passsignup">Mật khẩu</label> <input type="password"
									class="form-control" placeholder="Nhập mật khẩu"
									name="passsignup">
							</div>
							<div class="form-group mb-1 w-50">
								<label for="passcheck">Nhập Mật khẩu</label> <input
									type="password" class="form-control"
									placeholder="Nhập mật khẩu" name="passcheck">
							</div>
						</div>
						<div class="row">
							<div class="form-group mb-1 w-50">
								<label for="firstname">Họ</label> <input type="text"
									class="form-control" placeholder="Nhập họ" name="firstname"
									value="${firstname}">
							</div>
							<div class="form-group mb-1 w-50">
								<label for="lastname">Tên</label> <input type="text"
									class="form-control" placeholder="Nhập tên" name="lastname"
									value="${lastname}">
							</div>
						</div>
						<div class="row">
							<div class="form-group mb-1 w-50">
								<label for="email">Email</label> <input type="text"
									class="form-control" placeholder="Nhập email" name="email"
									value="${email}">
							</div>
							<div class="form-group mb-1 w-25">
								<label for="gender">Giới tính</label><br> <select
									name="gender" class="form-control">
									<option value="0">Nam</option>
									<option value="1">Nữ</option>
								</select>
							</div>
							<div class="form-group mb-1 w-25">
								<label for="dob">Ngày Sinh</label> <input type="date"
									class="form-control p-1" name="dob" value="${dob}">
							</div>
						</div>
						<div class="row">
							<div class="form-group mb-1 w-50">
								<label for="phone">Số điện thoại</label> <input type="text"
									class="form-control" placeholder="Nhập số điện thoại"
									name="phone" value="${phone}">
							</div>
							<div class="form-group mb-1 w-50">
								<label for="area">Thành phố</label> <input type="text"
									class="form-control" placeholder="Chọn thành phố" name="area"
									list="exampleList" value="${area}">
								<datalist id="exampleList">
									<c:forEach var="city" items="${listcity}">
										<option value="${city}">
									</c:forEach>
								</datalist>
							</div>
						</div>
						<div class="row">
							<div class="form-group mb-3 w-100">
								<label for="address">Địa chỉ</label> <input type="text"
									class="form-control" name="address" value="${address}">
							</div>
						</div>
						<input type="submit" value="Đăng ký"
							class="btn btn-block btn-primary mb-3">
					</form>
					<div>
						<span class="caption ml-auto">Nếu bạn đã có tài khoản</span> <a
							href="${pageContext.request.contextPath}/login">Đăng nhập tại đây </a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>