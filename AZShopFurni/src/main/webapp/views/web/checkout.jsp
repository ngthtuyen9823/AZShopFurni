<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="other.City"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>checkout</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>
@import
	url("https://fonts.googleapis.com/css2?family=Poppins:weight@100;200;300;400;500;600;700;800&display=swap")
	;

body {
	background-color: #f5eee7;
	font-family: "Poppins", sans-serif;
	font-weight: 300;
}

.container {
	height: 100vh;
}

.card {
	border: none;
}

.card-header {
	padding: .5rem 1rem;
	margin-bottom: 0;
	background-color: rgba(0, 0, 0, .03);
	border-bottom: none;
}

.btn-light:focus {
	color: #212529;
	background-color: #e2e6ea;
	border-color: #dae0e5;
	box-shadow: 0 0 0 0.2rem rgba(216, 217, 219, .5);
}

.form-control {
	height: 50px;
	border: 2px solid #eee;
	border-radius: 6px;
	font-size: 14px;
}

.form-control:focus {
	color: #495057;
	background-color: #fff;
	border-color: #039be5;
	outline: 0;
	box-shadow: none;
}

.input {
	position: relative;
}

.input i {
	position: absolute;
	top: 16px;
	left: 11px;
	color: #989898;
}

.input input {
	text-indent: 25px;
}

.card-text {
	font-size: 13px;
	margin-left: 6px;
}

.certificate-text {
	font-size: 12px;
}

.billing {
	font-size: 11px;
}

.super-price {
	top: 0px;
	font-size: 22px;
}

.super-month {
	font-size: 11px;
}

.line {
	color: #bfbdbd;
}

.free-button {
	background: #1565c0;
	height: 52px;
	font-size: 15px;
	border-radius: 8px;
}

.payment-card-body {
	flex: 1 1 auto;
	padding: 24px 1rem !important;
}
</style>
</head>

<body class="checkout-body">
	<link rel="stylesheet" type="text/css"
		href="<c:url value="/templates/web/css/voucher/voucher.css"/>">


	<c:set var="cityList" value="${City.getListCity()}" />

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog voucher-modal" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Mã khuyến mãi</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body voucher-card-container">
					<c:forEach var="voucher" items="${listVoucher}">
						<div class="">
							<c:set var="voucher" value="${voucher}" scope="request" />
							<jsp:include page="./components/voucherCard.jsp" />
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<form action="${pageContext.request.contextPath}/checkout"
		method="post">
		<div class="checkout-container">
			<div class="row">
				<div class="col-xl-7">
					<div class="card card-info">
						<div class="card-body">
							<ol class="activity-checkout mb-0 px-4 mt-3">
								<li class="checkout-item">
									<div class="avatar checkout-icon p-1">
										<div class="avatar-title rounded-circle bg-primary">
											<i class="bx bxs-receipt text-white font-size-20"></i>
										</div>
									</div>
									<div class="feed-item-list">
										<div>
											<h5 class="font-size-16 mb-1">Thông tin thanh toán</h5>
											<p class="text-muted text-truncate mb-4">Thông tin thanh
												toán của đơn hàng</p>
											<div class="mb-3">
												<form>
													<div>
														<div class="row">
															<div class="col-lg-4">
																<div class="mb-3">
																	<label class="form-label" for="billing-name">Họ
																		và tên</label> <input type="text" class="form-control"
																		readonly="readonly"
																		value="${user.firstName} ${user.lastName}"
																		id="billing-name" placeholder="Enter name">
																</div>
															</div>
															<div class="col-lg-4">
																<div class="mb-3">
																	<label class="form-label" for="billing-email-address">Email</label>
																	<input type="email" class="form-control"
																		readonly="readonly" value="${user.email}"
																		id="billing-email-address" placeholder="Enter email">
																</div>
															</div>
															<div class="col-lg-4">
																<div class="mb-3">
																	<label class="form-label" for="billing-phone">Số
																		điện thoại</label> <input type="text" class="form-control"
																		readonly="readonly" value="${user.phone}"
																		id="billing-phone" placeholder="Enter Phone no.">
																</div>
															</div>
														</div>
														<div class="mb-3">
															<label class="form-label" for="billing-address">Địa
																chỉ</label>
															<textarea class="form-control" id="billing-address"
																name="address" rows="3"
																placeholder="Nhập địa chỉ giao hàng">${address != null ? address : user.address}</textarea>
														</div>
														<div class="mb-3">
															<label class="form-label" for="billing-address">Ghi
																chú</label>
															<textarea class="form-control" id="billing-address"
																name="note" rows="3" placeholder="Nhập ghi chú">${note != null ? note : ''}</textarea>
														</div>
														<div class="row">
															<!-- <div class="col-lg-4">
																<div class="mb-4 mb-lg-0">
																	<label class="form-label">Quốc gia</label> <select
																		name="country" class="form-control form-select"
																		title="Country">
																		<option value="0">Chọn quốc gia</option>
																		<option value="AF">Việt Nam</option>
																	</select>
																</div>
															</div> -->
															<div class="col-lg-4">
																<label class="form-label">Thành phố</label> <select
																	data-live-search="true" name="city"
																	class="form-control form-select" title="City">
																	<option value="none">Chọn thành phố</option>
																	<c:forEach items="${cityList}" var="cityName">
																		<option value="${cityName}"
																			${city != null && city == cityName ? 'selected' : ''}>${cityName}</option>
																	</c:forEach>
																</select>
																<c:if test="${cityError != null}">
																	<div class="error-message">${cityError}</div>
																</c:if>
															</div>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</li>
								<li class="checkout-item checkout-item-active">
									<div class="avatar checkout-icon p-1">
										<div class="avatar-title rounded-circle bg-primary">
											<i class="bx bxs-truck text-white font-size-20"></i>
										</div>
									</div>
									<div class="feed-item-list">
										<div>
											<h5 class="font-size-16 mb-1">Thông tin vận chuyển</h5>
											<p class="text-muted text-truncate mb-4">Phương thức vận
												chuyển</p>
											<div class="mb-3">
												<div class="row address-card-container">
													<div class="col-lg-4 col-sm-6 address-card">
														<div data-bs-toggle="collapse">
															<label class="card-radio-label mb-0"> <input
																type="radio" name="address" id="info-address1"
																class="card-radio-input" checked>
																<div class="card-radio text-truncate p-3">
																	<span class="fs-14 mb-4 d-block">Giao hàng nhanh</span>
																	<span
																		class="text-muted fw-normal text-wrap mb-1 d-block">Dự
																		kiến giao hàng vào:
																		${LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))}</span>
																	<span class="text-muted fw-normal d-block">Phí vận chuyển : 
																		200 000 đ</span>
																</div>
															</label>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</li>
								<li class="checkout-item checkout-item-active">
									<div class="avatar checkout-icon p-1">
										<div class="avatar-title rounded-circle bg-primary">
											<i class="bx bxs-wallet-alt text-white font-size-20"></i>
										</div>
									</div>
									<div class="feed-item-list">
										<div>
											<h5 class="font-size-16 mb-1">Thông tin thanh toán</h5>
											<p class="text-muted text-truncate mb-4">Các phương thức
												thanh toán đơn hàng</p>
										</div>
										<div>
											<div class="row checkout-card">
												<div class="col-sm-6">
													<div>
														<label class="card-radio-label"> <input
															type="radio" name="pay-method" id="pay-methodoption3" onclick="hideElement()"
															class="card-radio-input" checked value="0"> <span
															class="card-radio py-3 text-center text-truncate">
																<i class="bx bx-money d-block h2 mb-3"></i> <span>Thanh
																	toán khi giao hàng</span>
														</span>
														</label>
													</div>
												</div>
												<div class="col-sm-6">
													<div data-bs-toggle="collapse">
														<label class="card-radio-label"> <input
															type="radio" name="pay-method" id="pay-methodoption1"
															onclick="showElement()" class="card-radio-input"
															value="1"> <span
															class="card-radio py-3 text-center text-truncate">
																<i class="bx bx-credit-card d-block h2 mb-3"></i> Thẻ
																tín dụng / thẻ ghi nợ
														</span>
														</label>
													</div>
												</div>
											</div>
										</div>
										<div class="container d-flex justify-content-center mt-5 mb-5">
											<div class="col-md-12" id="myElement" style="display: none;">
												<span>Payment Method</span>

												<div class="card">
													<div class="accordion" id="accordionExample">

														<div class="card">
															<div class="card-header p-0" id="headingTwo">
																<h2 class="mb-0">
																	<button
																		class="btn btn-light btn-block text-left collapsed p-3 rounded-0 border-bottom-custom"
																		type="button" data-toggle="collapse"
																		data-target="#collapseTwo" aria-expanded="false"
																		aria-controls="collapseTwo">
																		<div
																			class="d-flex align-items-center justify-content-between">
																			<span>Paypal</span> <img
																				src="https://i.imgur.com/7kQEsHU.png" width="30">
																		</div>
																	</button>
																</h2>
															</div>

															<div id="collapseTwo" class="collapse"
																aria-labelledby="headingTwo"
																data-parent="#accordionExample">
																<div class="card-body">
																	<input type="text" class="form-control"
																		placeholder="Paypal email">
																</div>
															</div>
														</div>

														<div class="card">
															<div class="card-header p-0">
																<h2 class="mb-0">
																	<button
																		class="btn btn-light btn-block text-left p-3 rounded-0"
																		data-toggle="collapse" data-target="#collapseOne"
																		aria-expanded="true" aria-controls="collapseOne">
																		<div
																			class="d-flex align-items-center justify-content-between">

																			<span>Credit card</span>
																			<div class="icons">
																				<img src="https://i.imgur.com/2ISgYja.png"
																					width="30"> <img
																					src="https://i.imgur.com/W1vtnOV.png" width="30">
																				<img src="https://i.imgur.com/35tC99g.png"
																					width="30"> <img
																					src="https://i.imgur.com/2ISgYja.png" width="30">
																			</div>

																		</div>
																	</button>
																</h2>
															</div>

															<div id="collapseOne" class="collapse show"
																aria-labelledby="headingOne"
																data-parent="#accordionExample">
																<div class="card-body payment-card-body">
																	<span class="font-weight-normal card-text">Card
																		Number</span>
																	<div class="input">
																		<i class="fa fa-credit-card"></i> <input type="text"
																			class="form-control"
																			placeholder="0000 0000 0000 0000">
																	</div>

																	<div class="row mt-3 mb-3">
																		<div class="col-md-6">
																			<span class="font-weight-normal card-text">Expiry
																				Date</span>
																			<div class="input">
																				<i class="fa fa-calendar"></i> <input type="text"
																					class="form-control" placeholder="MM/YY">
																			</div>
																		</div>

																		<div class="col-md-6">
																			<span class="font-weight-normal card-text">CVC/CVV</span>
																			<div class="input">
																				<i class="fa fa-lock"></i> <input type="text"
																					class="form-control" placeholder="000">
																			</div>
																		</div>
																	</div>
																	<span class="text-muted certificate-text"><i
																		class="fa fa-lock"></i> Your transaction is secured
																		with ssl certificate</span>

																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>

								</li>
							</ol>
						</div>
					</div>
					<div class="row my-4">
						<div class="col">
							<a href="<c:url value='/products'/>"
								class="btn btn-link text-muted"> <i
								class="mdi mdi-arrow-left me-1"></i> Tiếp tục mua sắm
							</a>
						</div>
					</div>
				</div>
				<div class="col-xl-5 cart-detail-container">
					<div class="card checkout-order-summary card-info">
						<div class="voucher-list-container">
							<button type="button" data-toggle="modal"
								data-target="#exampleModal">
								<i class="fa-solid fa-ticket"></i> Áp dụng khuyến mãi
							</button>
						</div>

						<div class="card-body">
							<div class="p-3 bg-light mb-3">
								<c:choose>
									<c:when test="${voucherErrorMessage != null}">
										<h5 class="font-size-16 mb-0 error-message">
											Giá trị tối thiểu đơn hàng phải đạt
											<fmt:formatNumber type="currency" value="${minimumPrice}"
												currencyCode="VND" pattern="#,##0 VND" var="formattedPrice" />${formattedPrice}</h5>
									</c:when>
									<c:otherwise>
										<h5 class="font-size-16 mb-0">Chi tiết đơn hàng</h5>
									</c:otherwise>
								</c:choose>

							</div>
							<div class="table-responsive">
								<table class="table table-centered mb-0 table-nowrap">
									<thead>
										<tr>
											<th class="border-top-0" style="width: 110px;" scope="col">Sản
												phẩm</th>
											<th class="border-top-0" scope="col">Chi tiết sản phầm</th>
											<th class="border-top-0" scope="col">Giá</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listCart}" var="cart">
											<tr>
												<th scope="row"><img
													src="${cart.image}"
													alt="product-img" title="product-img"
													class="avatar-lg rounded"></th>
												<td>
													<h5 class="font-size-16 text-truncate">
														<a href="#" class="text-dark">${cart.productName}</a>
													</h5>
													<p class="text-muted mb-0">
														<i class="bx bxs-star text-warning"></i> <i
															class="bx bxs-star text-warning"></i> <i
															class="bx bxs-star text-warning"></i> <i
															class="bx bxs-star text-warning"></i> <i
															class="bx bxs-star-half text-warning"></i>
													</p>
													<p class="text-muted mb-0 mt-1">
														<fmt:formatNumber type="currency"
															value="${cart.totalPrice}" currencyCode="VND"
															pattern="#,##0 VND" var="formattedPrice" />${formattedPrice}
														x${cart.quantity}
													</p>
												</td>
												<td><fmt:formatNumber type="currency"
														value="${cart.totalPrice * cart.quantity}"
														currencyCode="VND" pattern="#,##0 VND"
														var="formattedPrice" />${formattedPrice}</td>
											</tr>
										</c:forEach>
										<tr>
											<td colspan="2">
												<h5 class="font-size-14 m-0">Tổng phí :</h5>
											</td>
											<td><fmt:formatNumber type="currency"
													value="${rawPrice}" currencyCode="VND" pattern="#,##0 VND"
													var="formattedPrice" />${formattedPrice}</td>
										</tr>
										<tr>
											<td colspan="2">
												<h5 class="font-size-14 m-0">Giảm giá :</h5>
											</td>
											<td><input type="hidden"
												value="${discount != null ? discount : 0}" name="discount" />
												<fmt:formatNumber type="currency"
													value="${discount != null ? discount : 0}"
													currencyCode="VND" pattern="#,##0 VND" var="formattedPrice" />${discount != null ? '- ' : ''}
												${formattedPrice}</td>
										</tr>
										<tr>
											<td colspan="2">
												<h5 class="font-size-14 m-0">Phí vận chuyển :</h5>
											</td>
											<td><fmt:formatNumber type="currency" value="0"
													currencyCode="VND" pattern="#,##0 VND" var="formattedPrice" />${formattedPrice}</td>
										</tr>
										<tr>
											<td colspan="2">
												<h5 class="font-size-14 m-0">VAT :</h5>
											</td>
											<td><fmt:formatNumber type="currency" value="0"
													currencyCode="VND" pattern="#,##0 VND" var="formattedPrice" />${formattedPrice}</td>
										</tr>
										<tr class="bg-light">
											<td colspan="2">
												<h5 class="font-size-14 m-0">Thành tiền:</h5>
											</td>
											<td><input type="hidden" value="${totalCost}"
												name="totalCost" /> <fmt:formatNumber type="currency"
													value="${totalCost}" currencyCode="VND" pattern="#,##0 VND"
													var="formattedPrice" />${formattedPrice}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>

					</div>
					<div class="text-end mt-2 mt-sm-0 process-button">
						<button type="submit" class="btn btn-success">
							<i class="mdi mdi-cart-outline me-1"></i> Đặt hàng
						</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"></script>
	<script>
		// Function to show the element
		function showElement() {
			var element = document.getElementById("myElement");
			element.style.display = "block";
		}
		
		function hideElement() {
			var element = document.getElementById("myElement");
			element.style.display = "none";
		}
	</script>

</body>
</html>