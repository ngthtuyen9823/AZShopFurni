<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Ưu đãi</title>
<style>
@import url('https://fonts.googleapis.com/css?family=Oswald');

* {
	margin: 0;
	padding: 0;
	border: 2;
	box-sizing: border-box
}

.fl-left {
	float: left
}

.fl-right {
	float: right
}

h1 {
	text-transform: uppercase;
	font-weight: 900;
	border-left: 10px solid #fec500;
	padding-left: 10px;
	margin-bottom: 20px
}

.row {
	overflow: hidden
}

.card {
	display: table-row;
	width: 91%;
	background-color: #fff;
	color: #989898;
	margin-bottom: 30px;
	font-family: 'Oswald', sans-serif;
	text-transform: uppercase;
	border-radius: 5px;
	position: relative
}

.card+.card {
	margin-left: 2%
}

.date {
	display: table-cell;
	width: 25%;
	position: relative;
	text-align: center;
	border-right: 2px dashed #dadde6
}

.date time {
	display: block;
	position: absolute;
	top: 50%;
	left: 50%;
	-webkit-transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%)
}

.date time span {
	display: block
}

.date time span:first-child {
	color: #2b2b2b;
	font-weight: 600;
	font-size: 250%
}

.date time span:last-child {
	text-transform: uppercase;
	font-weight: 600;
	margin-top: -10px
}

.card-cont {
	display: table-cell;
	width: 80%;
	font-size: 85%;
	padding: 20px 10px 20px 50px
}

.card-cont h3 {
	color: #3C3C3C;
	font-size: 130%;
	font-weight: bold;
}

.card-cont .even-date i, .card-cont .even-info i, .card-cont .even-date time,
	.card-cont .even-info p {
	display: table-cell
}

.card-cont .even-date i, .card-cont .even-info i {
	padding: 5% 5% 0 0
}

.card-cont .even-info p {
	padding: 30px 50px 0 0
}

.card-cont .even-date time span {
	display: block
}

.card-cont a {
	display: block;
	text-decoration: none;
	width: 100px;
	height: 30px;
	background-color: #D8DDE0;
	color: #fff;
	text-align: center;
	line-height: 30px;
	border-radius: 2px;
	position: absolute;
	right: 10px;
	bottom: 10px
}

.row:last-child .card:first-child .card-cont a {
	background-color: #037FDD
}

.row:last-child .card:last-child .card-cont a {
	background-color: #6c7ae0
}

@media screen and (max-width: 860px) {
	.card {
		display: block;
		float: none;
		width: 100%;
		margin-bottom: 10px
	}
	.card+.card {
		margin-left: 0
	}
	.card-cont .even-date, .card-cont .even-info {
		font-size: 75%
	}
}

.border-input{
	border: 1px solid #000;
}
</style>

<section class="container">
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
						<li class="bor18"><a
							href="${pageContext.request.contextPath}/listOrder"
							class="dis-block stext-115 cl6 hov-cl1 trans-04 p-tb-8 p-lr-4"> Đơn mua </a></li>
						<li class="bor18"><a href="${pageContext.request.contextPath}/listVoucher"
							class="dis-block stext-115 cl6 hov-cl1 trans-04 p-tb-8 p-lr-4" style="color: #6C7AE0;"> 
								Kho voucher </a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-md-9">
			<div class="row">
				<div class="col-md-2">
					<div class="panel-search p-t-30 p-b-30">
						<span class="mtext-106 cl2">Tìm kiếm voucher:</span>
					</div>
				</div>
				<div class="col-md-9">
					<form action="${pageContext.request.contextPath}/searchVoucher" method="get">
						<div class="panel-search p-t-30 p-b-15">
							<div class="bor8 dis-flex p-l-15">
								<button class="size-113 flex-c-m fs-16 cl2 hov-cl1 trans-04 ">
									<i class="zmdi zmdi-search"></i>
								</button>
								<input class="mtext-107 cl2 size-114 plh2 p-r-15" type="text"
									name="keyword" placeholder="Nhập mã voucher tại đây">
							</div>
						</div>
					</form>
				</div>
			</div>
		<!-- List Voucher -->
			<c:forEach var="i" items="${listVoucher}">
				<div class="p-t-20">
					<article class="card fl-left">
						<section class="date">
							<time datetime="23th feb">
								<span style="color: #EE4D2D">${i.discount }%</span><span>saleoff</span>
							</time>
						</section>
						<section class="card-cont mb-2">
							<p>${i.voucherID }</p>
							<h3>${i.description }</h3>
							<div class="even-date mb-2">
								<time>
									<span>Số lượng: ${i.quantity }</span> 
									<span><fmt:formatDate value="${i.mfg }" pattern="dd/MM/yyyy"/> đến
										  <fmt:formatDate value="${i.exp }" pattern="dd/MM/yyyy"/></span>
								</time>
							</div>
							<div class="even-info">
								<p>áp dụng với đơn hàng trên  
								<fmt:formatNumber type="currency" value="${i.minimumPrice }" currencyCode="VND"
									pattern="#,##0 VND" var="formattedPrice" /> ${formattedPrice} </p>
								<a class="mt-20" href="#">Áp dụng</a>
							</div>
						</section>
					</article>
				</div>
			</c:forEach>
		</div>	
	</div>
</section>