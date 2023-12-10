<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<title>Thông tin cá nhân</title>
<
<style>
.close-button {
	position: absolute;
	top: 10px;
	right: 10px;
	padding: 5px 10px;
	font-size: 18px;
	cursor: pointer;
}
.shipper-avt {
	width: 30%;
	flex-direction: column;
	display: flex;
	justify-content: center;
	align-items: right;
}
</style>
<section class="sec-product-detail bg0 p-t-65 p-b-60">

	<button class="close-button" onclick="closePage()">X</button>
	<div class="container">
		<div class="row">

			<div class="col-md-6 col-lg-6 p-b-80">
				<div class="p-r-50 p-t-5 p-lr-0-lg">
					<h1 class="mt-4" style="margin: 50px">Thông tin cá nhân</h1>
					<div class="card-body">
						<div class="row">

							<div class="col-md-6">
								<div class="info-pair">
									<h5>Họ Tên :</h5>
									<p class="lead">${user.lastName}${user.firstName}</p>
								</div>
								<div class="info-pair">
									<h5>Địa chỉ:</h5>
									<p class="lead">${user.address}</p>
								</div>

								<div class="info-pair">
									<h5>Email:</h5>
									<p class="lead">${user.email}</p>
								</div>

								<div class="info-pair">
									<h5>Giới tính:</h5>
									<p class="lead">
										<c:choose>
											<c:when test="${user.gender == 0}">
												<c:out value="Nam" />
											</c:when>
											<c:when test="${user.gender == 1}">
												<c:out value="Nữ" />
											</c:when>
										</c:choose>
									</p>
								</div>
							</div>

							<div class="col-md-6">
								<div class="info-pair">
									<h5>Số điện thoại:</h5>
									<p class="lead">${user.phone}</p>
								</div>

								<div class="info-pair">
									<h5>Căn cước công dân:</h5>
									<p class="lead">${user.cid}</p>
								</div>

								<div class="info-pair">
									<h5>Ngày sinh:</h5>
									<p class="lead">${user.dob}</p>
								</div>
							</div>
						</div>
						<h4 class="mtext-105 cl2 js-name-detail p-b-14"></h4>
						<h4 class="mtext-105 cl2 js-name-detail p-b-14"></h4>

					</div>
				</div>

			</div>
			<div class="col-md-5 col-lg-4 p-b-80 shipper-avt">
				<img src="${user.avatar}" id="myImage" alt="User Image">
			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
	function closePage() {
		// JavaScript để chuyển trang
		window.location.href = 'adminCustomer'; // Thay 'url_moi' bằng URL mới bạn muốn chuyển đến
	}
</script>







<%-- 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Thông tin cá nhân</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
.info-pair {
	margin-bottom: 20px;
}
</style>
</head>

<body class="bg-light">
	<section class="sec-product-detail bg0 p-t-65 p-b-60">
		<div class="col-md-6 col-lg-6 p-b-80">

			<div class="container mt-5">
				<h1 class="text-center mb-4">Thông tin cá nhân</h1>

				<div class="row">
					<div class="col-md-6">
						<div class="info-pair">
							<h5>Địa chỉ:</h5>
							<p class="lead">${user.address}</p>
						</div>

						<div class="info-pair">
							<h5>Email:</h5>
							<p class="lead">${user.email}</p>
						</div>

						<div class="info-pair">
							<h5>Giới tính:</h5>
							<p class="lead">
								<c:choose>
									<c:when test="${user.gender == 0}">
										<c:out value="Nam" />
									</c:when>
									<c:when test="${user.gender == 1}">
										<c:out value="Nữ" />
									</c:when>
								</c:choose>
							</p>
						</div>
					</div>

					<div class="col-md-6">
						<div class="info-pair">
							<h5>Số điện thoại:</h5>
							<p class="lead">${user.phone}</p>
						</div>

						<div class="info-pair">
							<h5>Căn cước công dân:</h5>
							<p class="lead">${user.cid}</p>
						</div>

						<div class="info-pair">
							<h5>Ngày sinh:</h5>
							<p class="lead">${user.dob}</p>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-5 col-lg-4 p-b-80">

				<form action="updateAvatar" method="post"
					enctype="multipart/form-data">
					<div class="p-l-25 p-r-30 p-lr-0-lg">
						<div class="wrap-slick3 flex-sb flex-w">
							<div class="slick3 gallery-lb">
								<div class="item-slick3" data-thumb="${user.avatar}">
									<div class="wrap-pic-w pos-relative">
										<img src="${user.avatar}" alt="IMG-AVT"
											style="width: 100%; height: auto;"> <a
											class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04"
											href="${user.avatar}"> <i class="fa fa-expand"></i>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>

		</div>

		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>


 
<%--  
 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<style>
.shipper-profile {
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-family: Arial, sans-serif;
	font-size: 20;
	margin: 40px;
	display: flex;
	flex-direction: row;
	justify-content: end;
}

.shipper-info p {
	margin-bottom: 25;
}

.shipper-info {
	width: 65%;
}

.shipper-avt {
	width: 30%;
	flex-direction: column;
	display: flex;
	justify-content: center;
	align-items: center;
}

button, .shipper-btn {
	padding: 10px 20px;
	width: 120px;
	background-color: #fff;
	color: #000;
	border: black solid 0.5px;
	border-radius: 10px;
	cursor: pointer;
	font-size: 16;
}

button:hover, .shipper-btn:hover {
	background-color: #d9d9d9;
	border: #d9d9d9 solid 0.5px;
}

.shipper-profile img {
	width: 100%;
	aspect-ratio: 1 / 1;
	object-fit: cover;
	border-radius: 50%;
	grid-row: 1/span 3;
	background-size: cover;
	background-position: center;
}

.hind{
	visibility: hidden;
    position: absolute;
}
</style>
<div style="display: flex;
    justify-content: center;
    align-items: center;
    " ><h1 style="margin-top: 30px;margin-bottom: 10px; ">Thông tin khách hàng</h1></div>
<div class="shipper-profile">
	<div class="shipper-info">
		<p>
			<strong>Họ tên:</strong> ${user.lastName} ${user.firstName}
		</p>
		<p>
			<strong>Địa chỉ:</strong> ${user.address}
		</p>
		<p>
			<strong>Số điện thoại:</strong> ${user.phone}
		</p>
		<p>
			<strong>Email:</strong> ${user.email}
		</p>
		<p>
			<strong>Giới tính:</strong> ${user.gender==1?'Nữ':'Nam'}
		</p>
		<p>
			<strong>Căn cước công dân:</strong> ${user.cid}
		</p>
		<p>
			<strong>Ngày sinh:</strong>
			<fmt:formatDate value="${user.dob}" pattern="dd/MM/yyyy" />
		</p>
		
		
	</div>
	<div class="shipper-avt">
		<img src="${user.avatar}" id="myImage" alt="User Image">
	</div>
</div>
 --%>