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


<title>Đăng nhập</title>
</head>

<body>

	<div class="login">
		<div class="contents">
			<div class="row align-items-center justify-content-center">
				<div class="col-md-6">
					<h3>
						<strong>Xác nhận</strong>
					</h3>
					Mã xác nhận đã được gửi tới email của bạn!
					<h2>${mess}</h2>
					<form action="verification" method="post">
					<div class="row">
						<div class="form-group mt-3">
							<input type="text" class="form-control"
								placeholder="Nhập mã xác nhận trên email" name="usercode">
						</div>
					</div>
						<input type="submit" value="Xác nhận"
							class="btn btn-block btn-primary mt-4 mb-2">
					</form>
					<span class="caption">Nếu sau 5 phút chưa có mã?</span> <a
						href="${pageContext.request.contextPath}/resend">Gửi lại mã</a>
				</div>
			</div>
		</div>
	</div>
</body>

</html>