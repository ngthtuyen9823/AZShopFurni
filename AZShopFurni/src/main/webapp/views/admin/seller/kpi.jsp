<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Table - Seller</title>
</head>
<body>
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">Statistics Chart</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">Statistics Chart</li>
			</ol>
			<div class="row">
				<div class="col-xl-6">
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-chart-area me-1"></i>Seller's KPI for the year
						</div>
						<div class="card-body">
							<canvas id="viewchart1" width="100%" height="40"></canvas>
							<script>
					             var lineChartData = {
					                  labels: [<c:forEach var="item" items="${listReceipt}">'${item.time}',</c:forEach>],
					                  datasets: [
					                       {
					                    	   	 label:'KPIs',
					                             data: [<c:forEach var="item" items="${listReceipt}">${item.value},</c:forEach>],
					                       		 backgroundColor:'rgba(255, 99, 132, 0.6)'
					                       }
					                  ]
					
					             };
					             new Chart(document.getElementById("viewchart1").getContext("2d"),{
                                     type: 'line',
                                     data: lineChartData
                                 });
					       </script>
						</div>
					</div>
				</div>
				<div class="col-xl-6">
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-chart-bar me-1"></i>Seller's best-selling product
						</div>
						<div class="card-body">
							<canvas id="myChart" width="100%" height="40"></canvas>
							<script>
                                                var barChartData = {
                                                    labels: [<c:forEach var="item" items="${listItem}">'${item.item}',</c:forEach>],
                                                    datasets: [
                                                        {
                                                        	fillColor: "#FC8213",
                                                        	label:'Items',
                                                            data: [<c:forEach var="item" items="${listItem}">${item.value},</c:forEach>],
                                                            backgroundColor:'rgba(0, 98, 201, 0.8)'
                                                        }
                                                    ]

                                                };                                          
                                                new Chart(document.getElementById("myChart").getContext("2d"), {
                                                    type: 'bar',
                                                    data: barChartData
                                                });

                            </script>
						</div>
					</div>
				</div>
			</div>
			<h1 class="mt-4">Tables of 10 Best Sellers</h1>
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
								<th>KPI</th>
								<th>Update</th>
							</tr>
						</thead>
						<tfoot>
						<tbody>
							<c:forEach var="i" items="${listseller}">
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
									<td>${i.avatar}</td>
									<td>${i.kpi}</td>
									<td>
										<div class="hidden-sm hidden-xs btn-group">
											<a href="<c:url value='/admin-SellerKPIYear?userID=${i.userID}'/>">
												<button class="btn btn-xs btn-info btn-sm">
													<i class="ace-icon fa fa-eye"></i>
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