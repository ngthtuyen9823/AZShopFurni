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
			<h1 class="mt-4">Tables Shipper</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
				<li class="breadcrumb-item active">Seller</li>
			</ol>
			<div class="card mb-4">
				<div class="card-body">
					<a href="<c:url value='/adminInsertShipper'/>">
						<button type="button" class="btn btn-dark">
							<i class="ace-icon fa fa-pencil"></i> Add new shipper
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
					<i class="fas fa-table me-1"></i> DataTable Sellers
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
								<th>Avatar</th>
								<th>Area</th>
								<th>Update</th>
							</tr>
						</thead>
						<tfoot>
						<tbody>
							<c:forEach var="i" items="${listshipper}">
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
									<td> <img alt="avt" src="${i.avatar}" style="width: 50px; height: 50px;" /></td>
									<td>${i.area}</td>
									<td>
										<div class="hidden-sm hidden-xs btn-group">
											<a
												href="<c:url value='/adminUpdateShipper?userID=${i.userID}'/>">
												<button class="btn btn-xs btn-info btn-sm">
													<i class="ace-icon fa fa-pencil"></i>
												</button>
											</a> <a
												href="<c:url value='/adminDeleteShipper?userID=${i.userID}'/>">
												<button type="button" class="btn btn-xs btn-info btn-sm"
													id="liveToastBtn">
													<i class="ace-icon fa fa-trash"></i>
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