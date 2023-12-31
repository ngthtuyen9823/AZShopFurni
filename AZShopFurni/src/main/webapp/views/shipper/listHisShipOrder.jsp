<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<html>
<main>
	<div class="container-fluid px-4">
		<h1 class="mt-4">Lịch sử giao hàng</h1>
		<div class="card mb-4">
			<div class="card-body">Những đơn hàng giao thành công và thất
				bại đều lưu ở đây !!!</div>
		</div>
		<table id="datatablesSimple" class="table table-bordered">
			<thead>
				<tr>
					<th>
					<th>Mã</th>
					<th>Ngày giao</th>
					<th>Tên khách hàng</th>
					<th>Địa chỉ</th>
					<th>Phương thức</th>
					<th>Tổng tiền</th>
					<th>Trạng thái</th>
					<th>Thanh toán</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${listOrder}">
					<tr>
						<td>
							<div class="hidden-sm hidden-xs btn-group">
								<a href="shipper-detail-order?orderID=${i.orderID}">
									<button class="btn btn-xs btn-sm bor7">
										<i class="fa fa-info"></i>
									</button>
								</a>
							</div>
						</td>
						<td>${i.orderID}</td>
						<td><fmt:formatDate value="${i.deliveryTime}"
								pattern="dd/MM/yyyy" /></td>
						<td>${i.customer.lastName} ${i.customer.firstName}</td>
						<td>${i.address}</td>
						<td>${i.payment.method==1?'Ngân hàng':'COD'}</td>
						<td>
							<div class="d-flex justify-content-end">
								<fmt:formatNumber type="currency" value="${i.totalMoney}"
									currencyCode="VND" pattern="#,##0 đ" var="formattedPrice" />
								${formattedPrice}
							</div>
						</td>

						<td>
							<div class="d-flex justify-content-start">
								<c:choose>
									<c:when test="${i.status == 5}">
										<i style="color: red"> Đã hủy</i>
									</c:when>
									<c:when test="${i.status == 4 && i.customerConfirmation == 1}">
										<i style="color: green"> Đã giao</i>
									</c:when>
									<c:otherwise>
										<i style="color: orange"> Chưa xác nhận</i>
									</c:otherwise>
								</c:choose>
							</div>
						</td>
						<td>
							<div class="d-flex justify-content-center">
								<c:choose>
									<c:when test="${i.payment.status==1}">
										<div style="color: green; font-size: 20;"><strong>✔</strong></div>
									</c:when>
									<c:otherwise>
										<div style="color: red; font-size: 20;"><strong>✖</strong></div>
									</c:otherwise>
								</c:choose>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</main>