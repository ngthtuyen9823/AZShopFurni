<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
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
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<body>
	<style>
html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p,
	blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn,
	em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var,
	b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas,
	details, embed, figure, figcaption, footer, header, hgroup, menu, nav,
	output, ruby, section, summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	vertical-align: baseline;
}
/* HTML5 display-role reset for older browsers */
article, aside, details, figcaption, figure, footer, header, hgroup,
	menu, nav, section {
	display: block;
}

body {
	line-height: 1;
}

ol, ul {
	list-style: none;
}

blockquote, q {
	quotes: none;
}

blockquote:before, blockquote:after, q:before, q:after {
	content: '';
	content: none;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

*, *:before, *:after {
	box-sizing: border-box;
}

.table {
	width: 100%;
	border: 1px solid silver;
}

.table-header {
	display: flex;
	width: 100%;
	background: #000;
}

.table-row {
	display: flex;
	width: 100%;
	&:
	nth-of-type
	(odd)
	{
	background
	:
	silver;
}

}
.table-data, .header__item {
	flex: 1 1 20%;
	text-align: center;
}

.header__item {
	text-transform: uppercase;
}

.filter__link {
	color: white;
	text-decoration: none;
	position: relative;
	display: inline-block; &:: after { content : '';
	position: absolute;
	top: 50%;
	transform: translateY(-50%);
}

&
.desc::after {
	content: '(desc)';
}

&
.asc::after {
	content: '(asc)';
}

}
.table_product {
	display: flex;
	justify-content: space-evenly;
	margin-top: 50px;
}

.payment {
	width: 30%;
}

.table {
	width: 60%;
}

.table-row {
	align-items: center;
	padding-bottom: 3px;
}

.table-header {
	padding: 15px 0;
}

.text {
	text-align: end;
}

.pad {
	padding: 30px 0;
}

.bor {
	border-right: solid 1px silver;
}

.content_end {
	display: flex;
	justify-content: end;
}

.btn_content select {
	padding: 10px 15px;
}

h1 {
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji",
		"Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
}

h2 {
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji",
		"Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
}

h3 {
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji",
		"Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
}

h4 {
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji",
		"Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
}

h5 {
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji",
		"Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
}

p {
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji",
		"Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
}

b {
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji",
		"Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
}

.btn_content {
	display: flex;
	gap: 15px;
	height: max-content;
	align-items: center;
}

.button {
	border-radius: 10px;
	border: solid 1px silver;
	display: flex;
	align-items: center;
	width: 80px;
	height: 40px;
	transition: all 0.5s;
}

.button img {
	width: 25%;
	margin: auto;
}

.button:hover {
	background-color: cadetblue;
}

.container {
	max-width: 1800px;
	height: auto;
	padding: 50px;
}

.head_order {
	display: flex;
	justify-content: space-between;
}

.top_content img {
	width: 10%;
}

.top_content {
	display: flex;
	align-items: center;
	justify-content: space-evenly;
}

.bottom_content {
	margin-left: 30%;
	max-width: max-content;
	line-height: 1.5;
	opacity: 0.7;
}

.a {
	position: relative;
}

.b {
	position: absolute;
	bottom: -40%;
	left: 0;
	background-color: silver;
	height: 1px;
	width: 100%;
}

.infor_cart {
	margin-top: 70px;
	display: flex;
	justify-content: space-around;
}

.item {
	display: flex;
	line-height: 1.5;
	max-width: max-content;
	border: solid 1px silver;
	padding: 20px;
	border-radius: 10px;
}

.icon_item {
	width: 30%;
}

.icon_item img {
	width: 60px;
	height: 60px;
	display: block;
	margin: auto;
	object-fit: cover;
	border-radius: 50%;
	display: block;
}

.top {
	padding: 15px;
	border: solid 1px silver;
	border-radius: 5px;
	margin-bottom: 50px;
	background-color: azure;
}

.img {
	display: flex;
	align-items: center;
}

.img img {
	width: 12%;
}

.text_2 {
	line-height: 1.5;
	max-width: max-content;
	margin-left: 13px;
}

input {
	padding: 40px 130px;
	border: 1px solid silver;
	margin-top: 10px;
}
</style>
	<form action="sellerUpdateOrder" method="post">
		<div style="text-align: center; font-size: 24px; font-weight: bold;">Chi
			tiết đơn hàng</div>

		<div class="oder_detail">
			<div class="container">
				<div class="head_order a">
					<div class="calendar">
						<div class="top_content">
							<%-- <img src="https://booster.io/wp-content/uploads/custom-order-numbers-e1438361586475.png"
							alt=""> <b>${order.address}</b> --%>
							<img
								src="https://cdn-icons-png.flaticon.com/128/6422/6422210.png"
								alt=""> <b>Ngày đặt hàng : ${order.orderDate}</b>
						</div>
						<div class="bottom_content">
							<p>
								<b>Mã đơn : </b> ${order.orderID}
							</p>
							<p>
								<b>Địa chỉ : </b> ${order.address}
							</p>
						</div>
					</div>
					<div class="btn_content">

						<c:if test="${order.status==0 || order.status==1 }">
							<div >Cập nhật trạng thái:</div>
							<c:choose>
								<c:when test="${order.status == 0 }">
									<input type="hidden" name="status" value="${order.status}">
									<button type="submit" 
										class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5"
										style="background-color: green; color: white">Xác
										nhận đơn hàng</button>
								</c:when>
								<c:when test="${order.status == 1}">
									<input type="hidden" name="status" value="${order.status}">
									<button type="submit"
										class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5"
										style="background-color: green; color: white; height : 40 px; ">Chuẩn
										bị thành công</button>
								</c:when>
							</c:choose>
						</c:if>
						
					</div>
					<span class="b"></span>
				</div>

				<div class="infor_cart" style="gap: 10px;">
					<div class="item ">
						<div class="icon_item">
							<img
								src="https://t4.ftcdn.net/jpg/05/21/94/81/360_F_521948178_WUlWgu8X5k2TyHH5bDJDY1tRfJEvz4CN.jpg"
								alt="ảnh">
						</div>
						<div class="text_item">
							<h2>
								<b>Khách hàng</b>
							</h2>
							<p>
								<b> Họ tên : </b> ${order.customer.firstName}
								${order.customer.lastName}
							</p>
							<p>
								<b> Số điện thoại : </b> ${order.customer.phone}
							</p>
							<p>
								<b> Email : </b> ${order.customer.email}
							</p>
							<p>
								<b> Căn cước : </b> ${order.customer.cid}
							</p>
						</div>
					</div>
					<div class="item ">
						<div class="icon_item">
							<img src="${user.avatar}" alt="ảnh">
						</div>
						<div class="text_item">
							<h2>
								<b>Nhân viên</b>
							</h2>
							<p>
								<b> Họ tên : </b> ${user.firstName} ${user.lastName}
							</p>
							<p>
								<b> Số điện thoại : </b> ${user.phone}
							</p>
							<p>
								<b> Email : </b> ${user.email}
							</p>
							<p>
								<b> Căn cước : </b> ${user.cid}
							</p>
						</div>
					</div>
					<div class="item ">
						<div class="icon_item">
							<img
								src="https://static.vecteezy.com/system/resources/previews/013/484/033/original/digital-payment-3d-icon-png.png"
								alt="ảnh">
						</div>
						<div class="text_item">
							<h2>
								<b>Phương thức thanh toán</b>
							</h2>
							<p>

								<c:choose>
									<c:when test="${order.payment.method  == 0 }">
										Thanh toán khi nhận hàng
									</c:when>

									<c:when test="${order.payment.method  == 1 }">
										Thanh toán qua ngân hàng
									</c:when>
								</c:choose>

							</p>
							<p></p>
							<p></p>
							<p></p>
						</div>
					</div>

				</div>

				<div class="table_product">
					<div class="table">
						<div class="table-header">
							<div class="header__item">
								<a id="name" class="filter__link" href="#">Sản phẩm</a>
							</div>
							<div class="header__item">
								<a id="wins" class="filter__link filter__link--number" href="#"></a>
							</div>
							<div class="header__item">
								<a id="draws" class="filter__link filter__link--number" href="#">Tổng</a>
							</div>

						</div>

						<div class="table-content">
							<c:forEach var="j" items="${order.details}">
								<c:if test="${j != null}">
									<div class="table-row">
										<div class="product-image ">
											<img src="${j.item.image}" alt="ảnh" width="100" height="100"
												style="width: 100px; height: 100px;">
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
												<span class="fw-medium"> <c:choose>
														<c:when test="${ j.item.promotionPrice ==0}">
															<fmt:formatNumber type="currency"
																value="${j.item.originalPrice}" currencyCode="VND"
																pattern="#,##0" var="formattedPrice" />
										            ${formattedPrice}
										        </c:when>
														<c:otherwise>
															<fmt:formatNumber type="currency"
																value="${j.item.promotionPrice}" currencyCode="VND"
																pattern="#,##0" var="formattedPrice" />
									            ${formattedPrice}
									        </c:otherwise>
													</c:choose> x${j.quantity}
												</span>
											</p>
										</div>
										<div class="price-info font-size-20"
											style="color: orange; margin-left: auto; margin-right: 50px">

											<c:choose>
												<c:when test="${ j.item.promotionPrice==0}">
													<fmt:formatNumber type="currency"
														value="${j.item.originalPrice * j.quantity}"
														currencyCode="VND" pattern="#,##0 VND"
														var="formattedPrice" />
										            ${formattedPrice}
										        </c:when>
												<c:otherwise>
													<fmt:formatNumber type="currency"
														value="${j.item.promotionPrice * j.quantity}"
														currencyCode="VND" pattern="#,##0 VND"
														var="formattedPrice" />
									            ${formattedPrice}
									        </c:otherwise>
											</c:choose>
										</div>

									</div>

								</c:if>
							</c:forEach>


							<div class="table-row pad">
								<div class="table-data"></div>
								<div class="table-data"></div>
								<div class="table-data">
									<p class="text">
										Phí vận chuyển :<br> <br> Giảm giá : <br> <br>
										Tổng đơn hàng :
										<!-- <br> <br> Phương thức thanh toán : -->
									</p>
								</div>
								<div class="table-data">
									<b><fmt:formatNumber type="currency"
											value="${order.transportFee}" currencyCode="VND"
											pattern="#,##0 VND" var="formattedPrice" />
										${formattedPrice}</b> <br> <br> <b><fmt:formatNumber
											type="currency" value="${order.discount}" currencyCode="VND"
											pattern="#,##0 VND" var="formattedPrice" />
										${formattedPrice}</b> <br> <br> <b><fmt:formatNumber
											type="currency" value="${order.totalMoney}"
											currencyCode="VND" pattern="#,##0 VND" var="formattedPrice" />
										${formattedPrice}</b>
									<%-- <br> ${order.payment.method==0?'Thanh toán tiền mặt':'Chuyển khoản ngân hàng'}<br> <b> --%>
								</div>
							</div>

						</div>
					</div>
					<div class="payment" style="max-width: max content">
						<div class="top">
							<h2>Thông tin thanh toán</h2>
							<div class="img">
								<img
									src="https://cdn-icons-png.flaticon.com/128/7942/7942533.png"
									alt="">
								<p>
									<b>Master card ${order.payment.accountNumber}</b>
								</p>

							</div>
							<div class="text_2">
								<p>
									Chủ thẻ : ${order.payment.cardOwner}<br> Ngân hàng :
									${order.payment.bank} <br> Thời gian thanh toán :
									${order.payment.time}
								</p>
							</div>
						</div>
						<div class="bottom">
							<div class="note">
								<h3>Ghi chú</h3>
								<p
									style="display: block; border: solid 1px silver; padding: 10px">${order.note}</p>
							</div>
						</div>
					</div>
					<input type="hidden" name="orderID" value="${order.orderID}">
				</div>
			</div>
		</div>
	</form>
</body>
</html>