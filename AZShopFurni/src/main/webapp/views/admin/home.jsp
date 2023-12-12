<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
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
					<div class="card bg-warning text-white mb-4">
						<div class="card-body">
							Đơn đang chuẩn bị
							<h3>${chDG}</h3>
						</div>
						<div
							class="card-footer d-flex align-items-center justify-content-between">
							<a class="small text-white stretched-link" href="#">Xem chi tiết</a>
							<div class="small text-white">
								<i class="fas fa-angle-right"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-md-6">
					<div class="card bg-primary text-white mb-4">
						<div class="card-body">
							Đang vận chuyển
							<h3>${dVC}</h3>
						</div>
						<div
							class="card-footer d-flex align-items-center justify-content-between">
							<a class="small text-white stretched-link" href="#">Xem chi tiết</a>
							<div class="small text-white">
								<i class="fas fa-angle-right"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-md-6">
					<div class="card bg-success text-white mb-4">
						<div class="card-body">
							Đơn thành công
							<h3>${thCong}</h3>
						</div>
						<div
							class="card-footer d-flex align-items-center justify-content-between">
							<a class="small text-white stretched-link" href="#">Xem chi tiết</a>
							<div class="small text-white">
								<i class="fas fa-angle-right"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-md-6">
					<div class="card bg-danger text-white mb-4">
						<div class="card-body">
							Đơn đã hủy
							<h3>${daHuy}
						</div>
						<div
							class="card-footer d-flex align-items-center justify-content-between">
							<a class="small text-white stretched-link" href="#">Xem chi tiết</a>
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
							<i class="fas fa-chart-area me-1"></i> Tổng doanh thu của tháng:
							<span class="highlighted"
								style="font-size: 1.2em; color: #6060F8; font-weight: bold;"><fmt:formatNumber
									type="currency" value="${sumTotal}" currencyCode="VND"
									pattern="#,##0 VND" var="formattedPrice" /> ${formattedPrice}</span>

						</div>
						<div class="card-body">
							<canvas id="myTotalMoneyChart" width="100%" height="40"></canvas>
							<script>
							 var lineChartData = {
							            labels: [<c:forEach var="item" items="${listPayMentInMonth}">'${item.get(0)}',</c:forEach>],
							            datasets: [
							                {
							                	//fillColor: "#FC8213",
							                	label:'Doanh thu',
							                    data: [<c:forEach var="item" items="${listPayMentInMonth}">${item.get(1)},</c:forEach>],
							                    backgroundColor:' rgba(0, 0, 255, 0.6)'
							                }
							            ]

							        };                                          
							        new Chart(document.getElementById("myTotalMoneyChart").getContext("2d"), {
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
							<i class="fas fa-chart-bar me-1"></i>Số đơn hàng trong 7 ngày gần đây nhất</div>
						<div class="card-body">
							<canvas id="myChart" width="100%" height="40"></canvas>
							<script>
                                                var barChartData = {
                                                    labels: [<c:forEach var="item" items="${listReceipt}">'${item.time}',</c:forEach>],
                                                    datasets: [
                                                        {
                                                        	fillColor: "#FC8213",
                                                        	label:'Đơn hàng',
                                                            data: [<c:forEach var="item" items="${listReceipt}">${item.value},</c:forEach>],
                                                            backgroundColor:'rgba(255, 99, 132, 0.6)'
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
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i> DataTable Example
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
									<td>${i.gender}</td>
									<td>${i.phone}</td>
									<td>${i.dob}</td>
									<td>${i.cid}</td>
									<td>${i.avatar}</td>
									<td>${i.kpi}</td>
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