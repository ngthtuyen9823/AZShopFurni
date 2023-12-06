<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Thông tin cá nhân</title>
<section class="sec-product-detail bg0 p-t-65 p-b-60">
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-lg-2 p-b-80">
				<div class="side-menu">
					<div class="p-t-55">
						<h4 class="mtext-112 cl2 p-b-33">TÀI KHOẢN</h4>
						<ul>
							<li class="bor18"><a 	href="${pageContext.request.contextPath}/infoUser"
								class="dis-block stext-115 cl6 hov-cl1 trans-04 p-tb-8 p-lr-4">
									Hồ sơ cá nhân </a></li>
							<li class="bor18"><a href="${pageContext.request.contextPath}/listOrder"
								class="dis-block stext-115 cl6 hov-cl1 trans-04 p-tb-8 p-lr-4">
									Đơn mua </a></li>
							<li class="bor18"><a href="#"
								class="dis-block stext-115 cl6 hov-cl1 trans-04 p-tb-8 p-lr-4">
									Kho voucher </a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-lg-6 p-b-80">
				<div class="p-r-50 p-t-5 p-lr-0-lg">
					<h5 class="mtext-113 cl2 p-b-12">Hồ sơ cá nhân</h5>
					<div style="display: flex; align-items: center;">
						<span class="mtext-106 cl2" style="margin-right: 10px;"
							style="margin-right: 10px;"> Họ và tên:</span>
						<p style="font-size: 20px; margin: 0;">${userModel.lastName}
							${userModel.firstName}</p>
					</div>
					<div style="display: flex; align-items: center;">
						<span class="mtext-106 cl2" style="margin-right: 10px;"
							style=" margin-right: 10px;">Địa chỉ:</span>
						<p style="font-size: 20px; margin: 0;">${userModel.address}</p>
					</div>
					<div style="display: flex; align-items: center;">

						<span class="mtext-106 cl2" style="margin-right: 10px;">
							Email:</span>
						<p style="font-size: 20px;">${userModel.email}</p>
					</div>
					<div style="display: flex; align-items: center;">
						<span class="mtext-106 cl2" style="margin-right: 10px;">
							Giới tính:</span>
						<p style="font-size: 20px;">
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
					<div style="display: flex; align-items: center;">
						<span class="mtext-106 cl2" style="margin-right: 10px;"> Số
							điện thoại:</span>
						<p style="font-size: 20px;">${userModel.phone}</p>
					</div>
					<div style="display: flex; align-items: center;">
						<span class="mtext-106 cl2" style="margin-right: 10px;">
							Căn cước công dân:</span>
						<p style="font-size: 20px;">${userModel.cid}</p>
					</div>
					<div style="display: flex; align-items: center;">
						<span class="mtext-106 cl2" style="margin-right: 10px;">
							Ngày sinh:</span>
						<p style="font-size: 20px;">${userModel.dob}</p>
					</div>
					<h4 class="mtext-105 cl2 js-name-detail p-b-14"></h4>
					<h4 class="mtext-105 cl2 js-name-detail p-b-14"></h4>

					<div class="flex-w flex-m m-r-20 m-tb-5">
						<div
							class="flex-c-m stext-101 cl2 size-118 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-5">
							<a href="updateUser?userID=${userModel.userID}">Chỉnh sửa
								thông tin</a>
						</div>
					</div>

					<a href="updateAccount?userID=${userModel.userID}" class="stext-101 cl2 hov-cl1 trans-04 m-tb-10"> 
							Đổi mật khẩu </a>
				</div>
				<div class="flex-w w-full p-b-42">
					<c:choose>
						<c:when test="${userModel.type == 1}">
							<span class="fs-18 cl5 txt-center size-211"> <span
								class="lnr lnr-map-marker"></span>
							</span>
							<div class="size-212 p-t-2">
								<span class="mtext-110 cl2"> KPI </span>
								<p class="stext-115 cl6 size-213 p-t-18">%%%</p>
							</div>
						</c:when>
						<c:when test="${userModel.type == 2}">
							<span class="fs-18 cl5 txt-center size-211"> <span
								class="lnr lnr-map-marker"></span>
							</span>
							<div class="size-212 p-t-2">
								<span class="mtext-110 cl2"> Địa chỉ giao hàng </span>
								<p class="stext-115 cl6 size-213 p-t-18">Quận 9</p>
							</div>
						</c:when>
					</c:choose>
				</div>
			</div>
			<div class="col-md-5 col-lg-4 p-b-80">

				<form action="updateAvatar" method="post"
					enctype="multipart/form-data">
					<div class="p-l-25 p-r-30 p-lr-0-lg">
						<div class="wrap-slick3 flex-sb flex-w">
							<div class="wrap-slick3-dots"></div>
							<div class="wrap-slick3-arrows flex-sb-m flex-w"></div>

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

						<div class="flex-w flex-l-m filter-tope-group m-tb-10">
							<div class="flex-c-m stext-106 cl6 size-105 bor4 pointer hov-btn3 trans-04 m-tb-4 js-show-search" 
								style="padding: 10px 20px;">
								<i class="icon-close-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"></i>
								Thay đổi avatar
							</div>
						</div>
						<!-- Search product -->
						<div class="dis-none panel-search w-full p-t-10 p-b-15">
						    <div class="dis-none panel-search w-full p-t-10 p-b-15">
							    <input type="file" name="image" id="image" class="file-input" style="display: none;" onchange="displayFileName()">
							    <label for="image" class="file-label flex-c-m stext-101 cl0 size-125 bg3 bor2 hov-btn3 p-lr-15 trans-04">Chọn file</label>
							    <span id="selectedFileName" class="selected-file-name">${fileName}</span>
							    <input type="hidden" name="UserID" value="${userModel.userID}">
							</div>
						    <button class="flex-c-m stext-101 cl0 size-125 bg3 bor2 hov-btn3 p-lr-15 trans-04" type="submit">Chỉnh sửa</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
        function displayFileName() {
            const fileInput = document.getElementById('image');
            const selectedFileName = document.getElementById('selectedFileName');
            const fileLabel = document.querySelector('.file-label');

            if (fileInput.files.length > 0) {
                const fileName = fileInput.files[0].name;
                selectedFileName.textContent = `File đã chọn: ${fileName}`;
                selectedFileName.style.display = 'block';
                fileLabel.style.backgroundColor = '#4CAF50'; // Màu nền khi đã chọn file
            } else {
                selectedFileName.style.display = 'none';
                fileLabel.style.backgroundColor = '#3498db'; // Màu nền mặc định
            }
        }
    </script>