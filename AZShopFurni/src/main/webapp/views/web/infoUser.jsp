<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Thông tin cá nhân</title>
</head>
<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">

	<section class="ftco-about img ftco-section ftco-no-pt ftco-no-pb"
		id="about-section">
		<div class="container">
			<div class="row d-flex no-gutters">
				<div class="col-md-6 col-lg-6 d-flex">
					<div class="img-about img d-flex align-items-stretch">
						<div class="overlay"></div>
						<img src="${userModel.avatar}" height="400" width="auto"
                			 alt="Avatar">

					</div>
				</div>
				<div class="col-md-6 col-lg-6 pl-md-5 py-5">
					<div class="row justify-content-start pb-3">
						<div class="col-md-12 heading-section ftco-animate">
							<h1 class="big">About</h1>
							<h2 class="mb-4">Thông tin cá nhân</h2>
							<ul class="about-info mt-4 px-md-0 px-4">
								<li class="d-flex"><span>Họ và tên:</span> <span>${userModel.lastName} ${userModel.firstName}</span></li>
								<li class="d-flex"><span>Địa chỉ:</span> <span>${userModel.address}</span></li>
								<li class="d-flex"><span>Email:</span> <span>${userModel.email}</span></li>
								<li class="d-flex"><span>Giới tính:</span> <span> <c:choose>
											<c:when test="${userModel.gender == 0}">
												<c:out value="Nam" />
											</c:when>
											<c:when test="${userModel.gender == 1}">
												<c:out value="Nữ" />
											</c:when>
										</c:choose>
								</span></li>
								<li class="d-flex"><span>Số điện thoại:</span> <span>${userModel.phone}</span></li>
								<li class="d-flex"><span>Ngày sinh: </span> <span>${userModel.dob}</span></li>
								<li class="d-flex"><span>Căn cước công dân: </span> <span>${userModel.cid}</span></li>
							</ul>
						</div>
					</div>
					
					<a href="updateUser?userID=${userModel.userID}" class="btn btn-primary shadow-0"> 
						<i></i> Chỉnh sửa thông tin
					</a>
					
					<div class="counter-wrap ftco-animate d-flex mt-md-0">
						<div class="text">
							<p>
								<a href="updateAccount?userID=${userModel.userID}">Đổi mật khẩu</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="ftco-section ftco-no-pb goto-here" id="resume-section">
		<div class="container">
			<div class="row">
				<div class="col-md-9">
					<div id="page-1" class="page one">
						<c:choose>
							<c:when test="${userModel.type == 1}">
								<div id="page-3" class="page three">
									<h2 class="heading">KPI</h2>
									<div class="row progress-circle mb-5">
										<div class="col-lg-4 mb-4">
											<div class="bg-white rounded-lg shadow p-4">
												<h2 class="h5 font-weight-bold text-center mb-4">Tháng 10</h2>
												<div class="progress mx-auto" data-value='80'>
													<span class="progress-left"> <span
														class="progress-bar border-primary"></span>
													</span> <span class="progress-right"> <span
														class="progress-bar border-primary"></span>
													</span>
													<div
														class="progress-value w-100 h-100 rounded-circle d-flex align-items-center justify-content-center">
														<div class="h2 font-weight-bold">
															${userModel.kpi}<sup class="small">%</sup>
														</div>
													</div>
												</div>
												<div class="row text-center mt-4">
													<div class="col-6 border-right">
														<div class="h4 font-weight-bold mb-0">28%</div>
														<span class="small text-gray">Tuần trước</span>
													</div>
													<div class="col-6">
														<div class="h4 font-weight-bold mb-0">60%</div>
														<span class="small text-gray">Tháng trước</span>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:when>
							<c:when test="${userModel.type == 2}">
								<div id="page-4" class="page four">
									<h2 class="heading">Shipper</h2>
									<div class="resume-wrap d-flex ftco-animate">
										<div
											class="icon d-flex align-items-center justify-content-center"><span class="flaticon-ideas"></span>
										</div>
										<div class="text pl-3">
											<span class="date">Khu vực</span>
											<h2>Quận 9</h2>
										</div>
									</div>
								</div>
							</c:when>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
