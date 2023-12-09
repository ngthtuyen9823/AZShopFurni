<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Ưu đãi</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/web/css/voucher/voucher.css"/>">

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
							class="dis-block stext-115 cl6 hov-cl1 trans-04 p-tb-8 p-lr-4">
								Đơn mua </a></li>
						<li class="bor18"><a
							href="${pageContext.request.contextPath}/listVoucher"
							class="dis-block stext-115 cl6 hov-cl1 trans-04 p-tb-8 p-lr-4"
							style="color: #6C7AE0;"> Kho voucher </a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-md-9">
			<c:forEach var="voucher" items="${listVoucher}">
				<div class="p-t-55">
					<c:set var="voucher" value="${voucher}" scope="request" />
					<jsp:include page="../components/voucherCard.jsp" />
				</div>
			</c:forEach>
		</div>
	</div>
</section>