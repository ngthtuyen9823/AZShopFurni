<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Chi tiết đơn hàng</title>
<style>
.avatar-lg {
	height: 5rem;
	width: 5rem;
}

.font-size-18 {
	font-size: 18px !important;
}

.font-size-20 {
	font-size: 20px !important;
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

.product-item {
	display: flex;
	flex-wrap: nowrap;
	align-items: flex;
	margin-top: 20px;
}

.product-image {
	margin-left: 30px;
	margin-top: 10px;
	margin-bottom: 0px;
}

.product-info {
	flex-grow: 2;
	width: 70%;
}

.price-info {
	flex-grow: 10;
	justify-content: flex-end;
	text-align: center;
	align-items: center;
	width: 40%;
}

.order-details-container {
	margin-bottom: 0;
}

.track-line {
	height: 2px !important;
	background-color: #488978;
	opacity: 1;
	flex: 1 1 auto !important;
}

.off-track-line {
	height: 2px !important;
	background-color: #808080;
	opacity: 1;
	flex: 1 1 auto !important;
}

.dot {
	height: 10px;
	width: 10px;
	margin-left: 3px;
	margin-right: 3px;
	margin-top: 0px;
	background-color: #488978;
	border-radius: 50%;
	display: inline-block
}

.off-dot {
	height: 10px;
	width: 10px;
	margin-left: 3px;
	margin-right: 3px;
	margin-top: 0px;
	background-color: #808080;
	border-radius: 50%;
	display: inline-block
}

.big-dot {
	height: 25px;
	width: 25px;
	margin-left: 0px;
	margin-right: 0px;
	margin-top: 0px;
	background-color: #488978;
	border-radius: 50%;
	display: inline-block;
}

.off-big-dot {
	height: 25px;
	width: 25px;
	margin-left: 0px;
	margin-right: 0px;
	margin-top: 0px;
	background-color: #808080;
	border-radius: 50%;
	display: inline-block;
}

.big-dot i {
	font-size: 12px;
}

.card-stepper {
	z-index: 0
}
.status-update {
	display:flex;
	align-items:center;
	margin-bottom:5px;
}
.status-update >div{
	margin-right:5px;
}
</style>
<div style="text-align: center; margin-top: 75px;">
	<h2>Chi tiết đơn hàng</h2>
</div>
<section class="sec-product-detail bg0 p-t-65 p-b-60">
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-lg-2 p-b-80">
				<div class="side-menu">
					<div class="p-t-55"></div>
				</div>
			</div>

			<div class="col-xl-8">
				<div class="card border shadow-none mb-4">
					<div class="card-body">
						<div class="row">
							<div class="col-md-6 font-size-18">
								<p class="mb-0 mt-1">
									Mã đơn hàng: <span class="fw-medium"> ${order.orderID}</span>
								</p>
								<p class="mb-0 mt-1">
									Ngày đặt: <span class="fw-medium"> ${order.orderDate}</span>
								</p>
								<p class="mb-0 mt-1">
									SĐT: <span class="fw-medium"> ${order.customer.phone}</span>
								</p>
								<p class="mb-0 mt-1">
									<span
										class="fw-medium ${i.status == 0 ? 'text-orange' : ''} 
													           ${i.status == 1 ? 'text-green' : ''} 
													           ${i.status == 2 ? 'text-blue' : ''} 
													           ${i.status == 3 ? 'text-purple' : ''} 
													           ${i.status == 4 ? 'text-success' : ''} 
													           ${i.status == 5 ? 'text-danger' : ''}">
										${i.status == 0 ? 'Đơn hàng chờ xác nhận' :
                                               i.status == 1 ? 'Đơn hàng đã được xác nhận' :
                                               i.status == 2 ? 'Đơn hàng đang được chuẩn bị' :
                                               i.status == 3 ? 'Đơn hàng đang được giao đến bạn' :
                                               i.status == 4 ? 'Đơn hàng đã được giao thành công' :
                                               i.status == 5 ? 'Đơn hàng đã bị hủy' : ''}
									</span>
								</p>
							</div>
							<div class="col-md-6 font-size-18">
								<div class="mb-0 mt-1 d-flex justify-content-end">
									Khách hàng: ${order.customer.lastName} ${order.customer.firstName}
								</div>
								<div class="mb-0 mt-1 d-flex justify-content-end">
									Địa chỉ: ${order.address}
								</div>
							</div>

							<div class="d-none">
								<input type="hidden" name="orderID" value="${order.orderID}">
								<input type="hidden" name="sellerID" value="${order.sellerID}">
								<input type="hidden" name="shipperID" value="${order.shipperID}">
							</div>
							<div class="col-md-12 order-details-container">
								<c:forEach var="j" items="${order.details}">
									<c:if test="${j != null}">
										<div class="product-item">
											<div class="product-image w-50 h-50">
												<img src="${j.item.image}" alt="" width="150" height="150">
											</div>
											<div class="product-info">
												<h5 class="text-truncate font-size-20">
													<a href="#" class="text-dark"> ${j.product.productName}</a>
												</h5>
												<p class="mb-0 mt-1">
													Màu sắc: <span class="fw-medium"> ${j.item.color}</span>
												</p>
												<p class="mb-0 mt-1">
													Size: <span class="fw-medium"> ${j.item.size}</span>
												</p>
												<p class="mb-0 mt-1">
													<span class="fw-medium"> x${j.quantity}</span>
												</p>
											</div>
											<div class="price-info font-size-20" style="color: orange">
												<span class="text-muted me-2"> <del
														class="font-size-16 fw-normal">
														<fmt:formatNumber type="currency"
															value="${j.item.originalPrice}" currencyCode="VND"
															pattern="#,##0 VND" var="formattedPrice" />
														${formattedPrice}
													</del>
												</span>
												<fmt:formatNumber type="currency"
													value="${j.item.promotionPrice }" currencyCode="VND"
													pattern="#,##0 VND" var="formattedPrice" />
												${formattedPrice}
											</div>
										</div>
									</c:if>
								</c:forEach>
								<div class="col-md-12"></div>
									<div class="mb-0 mt-1 d-flex font-size-18">
									Ghi chú đơn hàng: <c:if test="${order.note==null}">Không có</c:if>${order.note}
								</div>
								<div class="col-md-12 mb-3">
									<div class="row">
										<div class="col-md-3">
										</div>
										<div class="col-md-4 text-end ">
											<p class="text-muted mb-2">Tổng tiền</p>
											<p class="text-muted mb-2">Phí vận chuyển</p>
											<p class="text-muted mb-2">Giảm giá</p>
											<p class="text-muted mb-2">Thành tiền</p>
											<p class="text-muted mb-2">Phương thức thanh toán</p>
											<p class="text-muted mb-2">Trạng thái thanh toán</p>
											<p class="text-muted">Trạng thái đơn hàng</p>
										</div>
										<div class="col-md-5 text-end ">
											<h5 class="font-size-19 mb-2">
												<fmt:formatNumber type="currency"
													value="${order.totalMoney}" currencyCode="VND"
													pattern="#,##0 VND" var="formattedPrice" />
												${formattedPrice}
											</h5>
											<h5 class="font-size-19 mb-2">
												<fmt:formatNumber type="currency"
													value="${order.transportFee}" currencyCode="VND"
													pattern="#,##0 VND" var="formattedPrice" />
												${formattedPrice}
											</h5>
											<h5 class="font-size-19 mb-2">
												<fmt:formatNumber type="currency" value="${order.discount}"
													currencyCode="VND" pattern="#,##0 VND" var="formattedPrice" />
												${formattedPrice}
											</h5>
											<h5 class="font-size-19 mb-2" style="color: orange">
												<fmt:formatNumber type="currency"
													value="${order.totalMoney}" currencyCode="VND"
													pattern="#,##0 VND" var="formattedPrice" />
												${formattedPrice}
											</h5>
											<h5 class="font-size-19 mb-2">
												${order.payment.method==0?'Thanh toán tiền mặt':'Chuyển khoản ngân hàng'}							
											</h5>
											<h5 class="font-size-19 mb-2" style="color: 
												${order.payment.status== 0 ? 'text-orange' : ''} 
													           ${order.payment.status == 1 ? 'green' : ''}">
												${order.payment.status==1?'Đã thanh toán':'Chưa thanh toán'}							
											</h5>
											<h5 class="font-size-19 mb-2" style="color:
												${order.status == 0 ? 'orange' : ''} 
													           ${order.status == 1 ? 'green' : ''} 
													           ${order.status == 2 ? 'blue' : ''} 
													           ${order.status == 3 ? 'purple' : ''} 
													           ${order.status == 4 ? 'green' : ''} 
													           ${order.status == 5 ? 'red' : ''}">
										${order.status == 0 ? 'Đơn hàng chờ xác nhận' :
                                               order.status == 1 ? 'Đã xác nhận' :
                                               order.status == 2 ? 'Đang được chuẩn bị' :
                                               order.status == 3 ? 'Đang được giao' :
                                               order.status == 4 ? 'Giao thành công' :
                                               order.status == 5 ? 'Đã bị hủy' : ''}							
											</h5>
										</div>
									</div>
								</div>
								<div class="ms-auto" style="margin: 0 auto">
									<form action="sellerUpdateOrder" method="post">
										<input type="hidden" name="orderID" value="${order.orderID}">
										 <div class="status-update">
										 <c:if test="${order.status==0 || order.status==1 }">
	            							<div>Cập nhật trạng thái:</div>
											<c:choose>
												<c:when test="${order.status == 0 }">
													<input type="hidden" name="status" value="${order.status}">
													<button type="submit"
														class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5" style="background-color: green; color:white">
														Xác nhận đơn hàng</button>
												</c:when>
												<c:when
													test="${order.status == 1}">
													<input type="hidden" name="status" value="${order.status}">
													<button type="submit"
														class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5" style="background-color: green; color:white">
														Chuẩn bị thành công</button>
												</c:when>
											</c:choose>
										</c:if>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</section>
