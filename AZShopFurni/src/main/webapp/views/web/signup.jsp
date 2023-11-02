<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<style>
body {
	font-family: "Roboto", sans-serif;
	background-color: #fff;
}

p {
	color: #b3b3b3;
	font-weight: 300;
}

h1, h2, h3, h4, h5, h6, .h1, .h2, .h3, .h4, .h5, .h6 {
	font-family: "Roboto", sans-serif;
}

a {
	-webkit-transition: .3s all ease;
	-o-transition: .3s all ease;
	transition: .3s all ease;
}

a:hover {
	text-decoration: none !important;
}

.content {
	padding: 7rem 0;
}

h2 {
	font-size: 20px;
	color: #DC3545;
}

.login, .login .contents>.row {
	height: 100vh;
	min-height: 700px;
}

@media ( max-width : 991.98px) {
	.login {
		height: 200px;
	}
}

.login .contents {
	background: none;
}

.login {
	width: 100%;
}

.login .contents {
	width: 50%;
}

@media ( max-width : 1199.98px) {
	.login .contents, .login {
		width: 100%;
	}
}

.login .contents .form-control, .login .form-control {
	border: none;
	-webkit-box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.1);
	box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.1);
	border-radius: 4px;
	height: 54px;
	background: #fff;
	background-color: #fff !important;
}

.login .contents .form-control:active, .login .contents .form-control:focus,
	.login .form-control:active, .login .form-control:focus {
	outline: none;
	-webkit-box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.1);
	box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.1);
}

.login {
	background-size: cover;
	background-position: center;
}

.login a {
	color: #888;
	text-decoration: underline;
}

.login .btn {
	height: 54px;
	padding-left: 30px;
	padding-right: 30px;
	border-radius: 10px;
}

.login .btn :hover {
	background-color: #fb331a;
	border-color: #fb331a;
}

.login .btn-primary {
	color: #fff;
	background-color: #fb771a;
	border-color: #fb771a;
}

.login .btn-block {
	display: block;
	width: 100%;
}

.login .forgot-pass {
	position: relative;
	top: 2px;
	font-size: 14px;
}

.control {
	display: block;
	position: relative;
	padding-left: 30px;
	margin-bottom: 15px;
	cursor: pointer;
	font-size: 14px;
}

.control .caption {
	position: relative;
	top: .2rem;
	color: #888;
}

.control input {
	position: absolute;
	z-index: -1;
	opacity: 0;
}

.control__indicator {
	position: absolute;
	top: 2px;
	left: 0;
	height: 20px;
	width: 20px;
	background: #e6e6e6;
	border-radius: 4px;
}

.control--radio .control__indicator {
	border-radius: 50%;
}

.control:hover input ~.control__indicator, .control input:focus ~.control__indicator
	{
	background: #ccc;
}

.control input:checked ~.control__indicator {
	background: #fb771a;
}

.control:hover input:not([disabled]):checked ~.control__indicator,
	.control input:checked:focus ~.control__indicator {
	background: #fb8633;
}

.control input:disabled ~.control__indicator {
	background: #e6e6e6;
	opacity: 0.9;
	pointer-events: none;
}

.control__indicator:after {
	font-family: 'icomoon';
	content: '✔';
	position: absolute;
	display: none;
	font-size: 16px;
	-webkit-transition: .3s all ease;
	-o-transition: .3s all ease;
	transition: .3s all ease;
}

.control input:checked ~.control__indicator:after {
	display: block;
	color: #fff;
}

.control--checkbox .control__indicator:after {
	top: 50%;
	left: 50%;
	margin-top: -1px;
	-webkit-transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
}

.control--checkbox input:disabled ~.control__indicator:after {
	border-color: #7b7b7b;
}

.control--checkbox input:disabled:checked ~.control__indicator {
	background-color: #7e0cf5;
	opacity: .2;
}

.ml-auto, .mx-auto {
	margin-left: auto !important;
}
</style>
<div class="login"
	style="background-image: url('https://storage.googleapis.com/web-budget/Resource/Web/Login/bg_login.jpg');">
	<div class="contents">
		<div class="row align-items-center justify-content-center">
			<div class="col-md-10">
				<h3>
					<strong>Đăng ký tài khoản</strong>
				</h3>
				<h2>${exception}</h2>
				<form action="signup" method="post">
					<div class="form-group mb-1 w75">
						<label for="usernamesignup">Tên đăng nhập</label> <input type="text"
							class="form-control" placeholder="Nhập tên đăng nhập"
							name="usernamesignup" value="${usernamesignup}">
					</div>
					<div class="row">

						<div class="form-group mb-1 w-50">
							<label for="passsignup">Mật khẩu</label> <input type="password"
								class="form-control" placeholder="Nhập mật khẩu" name="passsignup">
						</div>
						<div class="form-group mb-1 w-50">
							<label for="passcheck">Nhập Mật khẩu</label> <input
								type="password" class="form-control" placeholder="Nhập mật khẩu"
								name="passcheck">
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
					<div class="form-group mb-3 w-100">
						<label for="address">Địa chỉ</label> <input type="text"
							class="form-control" name="address" value="${address}">
					</div>
					<input type="submit" value="Đăng ký"
						class="btn btn-block btn-primary">
				</form>

			</div>
		</div>
	</div>
</div>