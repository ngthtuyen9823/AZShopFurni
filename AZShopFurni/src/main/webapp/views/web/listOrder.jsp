<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Đơn mua</title>
<style>
body {
	margin-top: 20px;
	background-color: #f1f3f7;
}

.avatar-lg {
	height: 5rem;
	width: 5rem;
}

.font-size-18 {
	font-size: 18px !important;
}

.text-truncate {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

a {
	text-decoration: none !important;
}

.w-xl {
	min-width: 160px;
}

.card {
	margin-bottom: 24px;
	-webkit-box-shadow: 0 2px 3px #e4e8f0;
	box-shadow: 0 2px 3px #e4e8f0;
}

.card {
	position: relative;
	display: -webkit-box;
	display: -ms-flexbox;
	display: flex;
	-webkit-box-orient: vertical;
	-webkit-box-direction: normal;
	-ms-flex-direction: column;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 1px solid #eff0f2;
	border-radius: 1rem;
}
</style>
<section class="sec-product-detail bg0 p-t-65 p-b-60">
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-lg-2 p-b-80">
				<div class="side-menu">
					<div class="p-t-55">
						<h4 class="mtext-112 cl2 p-b-33">TÀI KHOẢN</h4>
						<ul>
							<li class="bor18"><a
								href="${pageContext.request.contextPath}/infoUser"
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

			<div class="col-xl-8">
				<c:forEach var="i" items="${listOrder}">
					<div class="card border shadow-none">
						<div class="card-body">
							<div class="row">
								<div class="col-md-10">
									<div class="d-flex align-items-start border-bottom pb-3">
										<div class="me-5">
											<img src="${i.image}" alt="" width="150" height="150" style="margin-right: 20px;">
										</div>
										<div class="flex-grow-1 align-self-center overflow-hidden">
											<div>
												<input type="hidden" name= "itemID" value = "${i.itemID}" >
												<input type="hidden" name= "orderID" value = "${i.orderID}" >
												<input type="hidden" name= "sellerID" value = "${i.sellerID}" >
												<input type="hidden" name= "shipperID" value = "${i.shipperID}" >
											
												<h5 class="text-truncate font-size-20 ">
													<a href="#" class="text-dark ">${i.productName }</a>
												</h5>
												<p class="text-muted mb-0">
													<i class="bx bxs-star text-warning">${i.orderDate }</i> 
												</p>
												<p class="mb-0 mt-1">
													Phân loại hàng: <span class="fw-medium">${i.color }, ${i.size }</span>
												</p>
												<p class="mb-0 mt-1">
													<span class="fw-medium"> x${i.quantity }</span>
												</p>
												<c:choose>
													<c:when test="${i.status == 0}">
														<p class="mb-0 mt-1">
															<span class="fw-medium" style="color: Orange;"> Đơn hàng chờ xác nhận</span>
														</p>
													</c:when>
													<c:when test="${i.status == 1}">
														<p class="mb-0 mt-1"> <span class="fw-medium"> Đơn hàng đã được xác nhận</span>
														</p>
													</c:when>
													<c:when test="${i.status == 2}">
														<p class="mb-0 mt-1">
															<span class="fw-medium"> Đơn hàng đang được chuẩn bị</span>
														</p>
													</c:when>
													<c:when test="${i.status == 3}">
														<p class="mb-0 mt-1">
															<span class="fw-medium" style="color: green;"> Đơn hàng đang được giao đến bạn</span>
														</p>
													</c:when>
													<c:when test="${i.status == 4}">
														<p class="mb-0 mt-1"> <span class="fw-medium" style="color: green;"> Đơn hàng đã được giao thành công</span>
														</p>
													</c:when>
													<c:when test="${i.status == 5}">
														<p class="mb-0 mt-1">
															<span class="fw-medium" style="color: red;"> Đơn hàng đã bị hủy</span>
														</p>
													</c:when>
												</c:choose>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-2"> 
									<a href="#" class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
										Chat
									</a>
									<form action="customerConfirm" method="post" enctype="multipart/form-data">
										<input type="hidden" name= "orderID" value = "${i.orderID}" >
									    <c:choose>
									        <c:when test="${i.status <= 2 }">
									            <input type="hidden" name="action" value="cancelOrder">
									            <button type="submit" class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
									                Hủy đơn
									            </button>
									        </c:when>
									        <c:when test="${i.status == 3 }">
									            <input type="hidden" name="action" value="confirmOrder">
									            <button type="submit" class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
									                Xác nhận
									            </button>
									        </c:when>
									         <c:when test="${i.status == 4 }">
									            <input type="hidden" name="action" value="rateOrder">
									            <button type="submit" class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
									                Đánh giá
									            </button>
									        </c:when>
									    </c:choose>
									</form>
								</div>
							</div>
							<hr>
							<div>
								<div class="row">
									<div class="col-md-3">
										<div class="mt-3">
											<p class="text-muted mb-2"></p>
											<p class="text-muted mb-2"></p>
										</div>
									</div>
									<div class="col-md-5">
										<div class="mt-3">
											<p class="text-muted mb-2">Giá</p>
											<h5 class="mb-0 mt-2">
												<span class="text-muted me-2"> 
													<del class="font-size-16 fw-normal">${i.originalPrice } VND</del>
												</span>${i.promotionPrice } VND
											</h5>
										</div>
									</div>
									<div class="col-md-3">
										<div class="mt-3">
											<p class="text-muted mb-2">Thành tiền</p>
											<h5>${i.totalMoney }</h5>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</section>