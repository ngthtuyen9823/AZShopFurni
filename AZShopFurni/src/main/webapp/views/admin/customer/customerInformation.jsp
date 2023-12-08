<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<title>Thông tin cá nhân</title>
<<style>
.close-button {
        position: absolute;
        top: 10px;
        right: 10px;
        padding: 5px 10px;
        font-size: 18px;
        cursor: pointer;
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
									<p class="lead">${userModel.lastName}
										${userModel.firstName}</p>
								</div>
								<div class="info-pair">
									<h5>Địa chỉ:</h5>
									<p class="lead">${userModel.address}</p>
								</div>

								<div class="info-pair">
									<h5>Email:</h5>
									<p class="lead">${userModel.email}</p>
								</div>

								<div class="info-pair">
									<h5>Giới tính:</h5>
									<p class="lead">
										<c:choose>
											<c:when test="${userModel.gender == 0}">
												<c:out value="Nam" />
											</c:when>
											<c:when test="${userModel.gender == 1}">
												<c:out value="Nữ" />
											</c:when>
										</c:choose>
									</p>
								</div>
							</div>

							<div class="col-md-6">
								<div class="info-pair">
									<h5>Số điện thoại:</h5>
									<p class="lead">${userModel.phone}</p>
								</div>

								<div class="info-pair">
									<h5>Căn cước công dân:</h5>
									<p class="lead">${userModel.cid}</p>
								</div>

								<div class="info-pair">
									<h5>Ngày sinh:</h5>
									<p class="lead">${userModel.dob}</p>
								</div>
							</div>
						</div>
						<h4 class="mtext-105 cl2 js-name-detail p-b-14"></h4>
						<h4 class="mtext-105 cl2 js-name-detail p-b-14"></h4>

					</div>
				</div>
				
			</div>
			<div class="col-md-5 col-lg-4 p-b-80">

				<form action="updateAvatar" method="post"
					enctype="multipart/form-data">
					<div class="p-l-25 p-r-30 p-lr-0-lg">
						<div class="wrap-slick3 flex-sb flex-w">
							<div class="slick3 gallery-lb">
								<div class="item-slick3" data-thumb="${userModel.avatar}">
									<div class="wrap-pic-w pos-relative">
										<img src="${userModel.avatar}" alt="IMG-AVT"
											style="width: 100%; height: auto;"> <a
											class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04"
											href="${userModel.avatar}"> <i class="fa fa-expand"></i>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
    function closePage() {
        // JavaScript để chuyển trang
        window.location.href = 'url_moi'; // Thay 'url_moi' bằng URL mới bạn muốn chuyển đến
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
							<p class="lead">${userModel.address}</p>
						</div>

						<div class="info-pair">
							<h5>Email:</h5>
							<p class="lead">${userModel.email}</p>
						</div>

						<div class="info-pair">
							<h5>Giới tính:</h5>
							<p class="lead">
								<c:choose>
									<c:when test="${userModel.gender == 0}">
										<c:out value="Nam" />
									</c:when>
									<c:when test="${userModel.gender == 1}">
										<c:out value="Nữ" />
									</c:when>
								</c:choose>
							</p>
						</div>
					</div>

					<div class="col-md-6">
						<div class="info-pair">
							<h5>Số điện thoại:</h5>
							<p class="lead">${userModel.phone}</p>
						</div>

						<div class="info-pair">
							<h5>Căn cước công dân:</h5>
							<p class="lead">${userModel.cid}</p>
						</div>

						<div class="info-pair">
							<h5>Ngày sinh:</h5>
							<p class="lead">${userModel.dob}</p>
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
								<div class="item-slick3" data-thumb="${userModel.avatar}">
									<div class="wrap-pic-w pos-relative">
										<img src="${userModel.avatar}" alt="IMG-AVT"
											style="width: 100%; height: auto;"> <a
											class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04"
											href="${userModel.avatar}"> <i class="fa fa-expand"></i>
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
 --%>
