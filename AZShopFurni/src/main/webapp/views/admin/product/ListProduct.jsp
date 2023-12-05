
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ListProduct</title>
<style>
.card-body a {
    margin-right: 10px; /* Khoảng cách giữa các phần tử <a> */
}
</style>
</head>
<body>

	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">Dashboard</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">Dashboard</li>
			</ol>
			<div class="row">
				<div class="col-xl-3 col-md-6">
					<div class="card bg-primary text-white mb-4">
						<div class="card-body">Primary Card</div>
						<div
							class="card-footer d-flex align-items-center justify-content-between">
							<a class="small text-white stretched-link" href="#">View
								Details</a>
							<div class="small text-white">
								<i class="fas fa-angle-right"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-md-6">
					<div class="card bg-warning text-white mb-4">
						<div class="card-body">Warning Card</div>
						<div
							class="card-footer d-flex align-items-center justify-content-between">
							<a class="small text-white stretched-link" href="#">View
								Details</a>
							<div class="small text-white">
								<i class="fas fa-angle-right"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-md-6">
					<div class="card bg-success text-white mb-4">
						<div class="card-body">Success Card</div>
						<div
							class="card-footer d-flex align-items-center justify-content-between">
							<a class="small text-white stretched-link" href="#">View
								Details</a>
							<div class="small text-white">
								<i class="fas fa-angle-right"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-md-6">
					<div class="card bg-danger text-white mb-4">
						<div class="card-body">Danger Card</div>
						<div
							class="card-footer d-flex align-items-center justify-content-between">
							<a class="small text-white stretched-link" href="#">View
								Details</a>
							<div class="small text-white">
								<i class="fas fa-angle-right"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xl-6">
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-chart-area me-1"></i> Area Chart Example
						</div>
						<div class="card-body">
							<canvas id="myAreaChart" width="100%" height="40"></canvas>
						</div>
					</div>
				</div>
				<div class="col-xl-6">
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-chart-bar me-1"></i> Bar Chart Example
						</div>
						<div class="card-body">
							<canvas id="myBarChart" width="100%" height="40"></canvas>
						</div>
					</div>
				</div>
			</div>
			<div class="card mb-4">
				<div class="card-body">
					<a href="<c:url value='/insertProduct'/>" style="margin-right: 50px;">
						<button type="button" class="btn btn-dark">
							<i class="ace-icon fa fa-pencil"></i> Add new product
						</button>
					</a> 
					<a href="<c:url value='/adminItem'/>">
						<button type="button" class="btn btn-dark">
							<i class="ace-icon fa fa-list-ul"></i> List all item
						</button>
					</a>
				</div>
			</div>
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i> DataTable Example
				</div>
				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th>ProductID</th>
								<th>ProductName</th>
								<th>Description</th>
								<th>Origin</th>
								<th>SupplierID</th>
								<th>CategoryID</th>
								<th>Material</th>
								<th>Action</th>

							</tr>
						</thead>
						<tfoot>
						<tbody>
							<c:forEach var="i" items="${listProduct}">
								<tr>
									<td>${i.productID}</td>
									<td>${i.productName}</td>
									<td>${i.description}</td>
									<td>${i.origin}</td>
									<td><c:forEach var="m" items="${listSupplier}">
											<c:if test="${i.supplierID == m.supplierID}">${m.supplierName}</c:if>
										</c:forEach></td>
									<td><c:forEach var="j" items="${listCate}">
											<c:if test="${i.categoryID == j.categoryID}">${j.categoryName}</c:if>
										</c:forEach></td>
									<td>${i.material}</td>
									<td><div class="hidden-sm hidden-xs btn-group">
											<a href='<c:url value = '/adminItem?ProductID=${i.productID}'></c:url>'>
												<button class="btn btn-xs btn-info btn-sm">
													<i class="ace-icon fa fa-eye"></i>
												</button>
											</a> <a href="<c:url value='/updateProduct?ProductID=${i.productID}'/>">
												<button class="btn btn-xs btn-info btn-sm">
													<i class="ace-icon fa fa-pencil"></i>
												</button>
											</a> <a href="<c:url value='/deleteProduct?ProductID=${i.productID}'/>">
												<button type="button" class="btn btn-xs btn-info btn-sm"
													id="liveToastBtn"
													onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm có ID là : ${i.productID} không?')">
													<i class="ace-icon fa fa-trash"></i>
												</button>
											</a>
										</div></td>
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