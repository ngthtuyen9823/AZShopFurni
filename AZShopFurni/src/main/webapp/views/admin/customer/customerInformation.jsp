<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<title>Thông tin cá nhân</title>
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
