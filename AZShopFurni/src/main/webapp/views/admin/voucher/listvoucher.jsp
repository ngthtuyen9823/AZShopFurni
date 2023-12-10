<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Table - Shipper</title>
</head>
<body>
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">Tables Voucher</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
				<li class="breadcrumb-item active">Voucher</li>
			</ol>
			<div class="card mb-4">
				<div class="card-body">
					<a href="<c:url value='/adminInsertVoucher'/>">
						<button type="button" class="btn btn-dark">
							<i class="ace-icon fa fa-pencil"></i> Add new voucher
						</button>
					</a>
				</div>
			</div>
			<c:if test="${not empty message }">
				<div class="alert alert-${alert}">
					<strong>${message}!</strong>
				</div>
			</c:if>
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i> DataTable Vouchers
				</div>
				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th>ID</th>
								<th>Description</th>
								<th>Discount</th>
								<th>MinimumPrice</th>
								<th>Quantity</th>
								<th>Mfg</th>
								<th>Exp</th>
								<th>Action</th>
							</tr>
						</thead>
						<tfoot>
						<tbody>
							<c:forEach var="i" items="${listvoucher}">
								<tr>
									<td>${i.voucherID}</td>
									<td>${i.description}</td>
									<td>${i.discount}</td>
									<td>${i.minimumPrice}</td>
									<td>${i.quantity}</td>
									<td>${i.mfg}</td>
									<td>${i.exp}</td>
									<td>
										<div class="hidden-sm hidden-xs btn-group">
											<a
												href="<c:url value='/adminUpdateVoucher?voucherID=${i.voucherID}'/>">
												<button class="btn btn-xs btn-info btn-sm">
													<i class="ace-icon fa fa-pencil"></i>
												</button>
											</a>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</main>
</body>
</html>