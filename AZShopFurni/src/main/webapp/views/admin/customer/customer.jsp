<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Table - Customer</title>
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
						<div class="card-body">CustomerID: ${list3[0].totalMoney}</div>
						<div class="card-body">${list3[0].firstName} ${list3[0].lastName}</div>
						<div
							class="card-footer d-flex align-items-center justify-content-between">
							<a class="small text-white">
								<fmt:formatNumber type="currency" value="${list3[0].totalMoney}" currencyCode="VND"
								pattern="#,##0 VND" var="formattedPrice" /> ${formattedPrice}
							</a>
							<div class="small text-white">
								<i class="fas fa-angle-right"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-md-6">
					<div class="card bg-warning text-white mb-4">
						<div class="card-body">CustomerID: ${list3[1].totalMoney}</div>
						<div class="card-body">${list3[1].firstName} ${list3[1].lastName}</div>
						<div
							class="card-footer d-flex align-items-center justify-content-between">
							<a class="small text-white" >
								<fmt:formatNumber type="currency" value="${list3[1].totalMoney}" currencyCode="VND"
								pattern="#,##0 VND" var="formattedPrice" /> ${formattedPrice}</a>
							<div class="small text-white">
								<i class="fas fa-angle-right"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-md-6">
					<div class="card bg-success text-white mb-4">
						<div class="card-body">CustomerID: ${list3[2].totalMoney}</div>
						<div class="card-body">${list3[2].firstName} ${list3[2].lastName}</div>
						<div class="card-footer d-flex align-items-center justify-content-between">
							<a class="small text-white ">
								<fmt:formatNumber type="currency" value="${list3[2].totalMoney}" currencyCode="VND"
								pattern="#,##0 VND" var="formattedPrice" /> ${formattedPrice}</a>
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
			<h1 class="mt-4">Tables Customer</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
				<li class="breadcrumb-item active">Customer</li>
			</ol>
			<div class="card mb-4">
				<div class="card-body">
					<a href="<c:url value='/adminInsertCustomer'/>">
						<button type="button" class="btn btn-dark">
							<i class="ace-icon fa fa-pencil"></i> Add new customer
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
					<i class="fas fa-table me-1"></i> DataTable Customer
				</div>
				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th>ID</th>
								<th>FirstName</th>
								<th>LastName</th>
								<th>Address</th>
								<th>Gender</th>
								<th>Phone</th>
								<th>DoB</th>
								<th>CID</th>
								<th>Email</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="i" items="${listCustomer}">
								<tr>
									<td>${i.userID}</td>
									<td>${i.firstName}</td>
									<td>${i.lastName}</td>
									<td>${i.address}</td>
									<td><c:choose>
											<c:when test="${i.gender == 1}">Nữ</c:when>
											<c:when test="${i.gender == 0}">Nam</c:when>
											<c:otherwise>Không rõ</c:otherwise>
										</c:choose></td>
									<td>${i.phone}</td>
									<td>${i.dob}</td>
									<td>${i.cid}</td>
									<td>${i.email}</td>
									<td>
										<div class="hidden-sm hidden-xs btn-group">
											<a
												href="<c:url value='/adminUpdateCustomer?customerID=${i.userID}'/>">
												<button class="btn btn-xs btn-info btn-sm">
													<i class="ace-icon fa fa-pencil"></i>
												</button>
											</a> <a
												href="<c:url value='/adminDeleteCustomer?customerID=${i.userID}'/>">
												<button type="button" class="btn btn-xs btn-info btn-sm"
													id="liveToastBtn">
													<i class="ace-icon fa fa-trash"></i>
												</button>
											</a> <a
												href="<c:url value='/adminInformationCustomer?customerID=${i.userID}'/>">
												<button type="button" class="btn btn-xs btn-info btn-sm"
													id="liveToastBtn">
													<i class="fa fa-info-circle" aria-hidden="true"></i>
												</button>
											</a>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="toast-container position-fixed bottom-0 end-0 p-3">
			<div id="liveToast" class="toast" role="alert" aria-live="assertive"
				aria-atomic="true">
				<div class="toast-header">
					<strong class="me-auto">Bootstrap</strong> <small>11 mins
						ago</small>
					<button type="button" class="btn-close" data-bs-dismiss="toast"
						aria-label="Close"></button>
				</div>
				<div class="toast-body">
					<c:if test="${message != null}">${message}</c:if>
				</div>
			</div>
		</div>
	</main>
</body>
</html>