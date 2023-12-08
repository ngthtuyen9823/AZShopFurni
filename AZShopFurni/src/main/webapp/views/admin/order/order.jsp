<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Table - Order</title>

</head>
<body>

	<main>
		<script type="text/javascript">
		var 
	</script>

		<div class="container-fluid px-4">
			<h1 class="mt-4">Đơn hàng</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">Đơn hàng trong tuần</li>
			</ol>
			<div class="row">
				<div class="col-xl-3 col-md-6">
					<div class="card text-white mb-4"
						style="background-color: #5D5DF6;">
						<div class="card-body">
							Đơn chưa xác nhận
							<h3>${chXN}</h3>
						</div>
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
					<div class="card text-white mb-4"
						style="background-color: #818001;">
						<div class="card-body">
							Đơn đã xác nhận
							<h3>${daXN}</h3>
						</div>
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
						<div class="card-body">
							Đơn đang chuẩn bị
							<h3>${chDG}</h3>
						</div>
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
					<div class="card bg-primary text-white mb-4">
						<div class="card-body">
							Đang vận chuyển
							<h3>${dVC}</h3>
						</div>
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
						<div class="card-body">
							Đơn thành công
							<h3>${thCong}</h3>
						</div>
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
						<div class="card-body">
							Đơn đã hủy
							<h3>${daHuy}
						</div>
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
							<i class="fas fa-chart-area me-1"></i> Tổng doanh thu của tháng
						</div>
						<div class="card-body">
							<canvas id="myTotalMoneyChart" width="100%" height="40"></canvas>
							<script>
                                                var lineChartData = {
                                                    labels: [<c:forEach var="item" items="${listPayMentInMonth}">'${item.get(0)}',</c:forEach>],
                                                    datasets: [
                                                        {
                                                        	//fillColor: "#FC8213",
                                                        	label:'Store revenue',
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
							<i class="fas fa-chart-bar me-1"></i> Thống kê đơn hàng trong
							tháng
						</div>
						<div class="card-body">
							<canvas id="myChart" width="100%" height="40"></canvas>
							<script>
                                                var barChartData = {
                                                		
                                                    labels: [<c:forEach var="item" items="${listPayMentInMonth}">'${item.get(0)}',</c:forEach>],
                                                    datasets: [
                                                        {
                                                        	fillColor: "#FC8213",
                                                        	label:'Orders',
                                                            data: [<c:forEach var="item" items="${listPayMentInMonth}">${item.get(2)},</c:forEach>],
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
			<h1 class="mt-4">Quản lý đơn hàng</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
				<li class="breadcrumb-item active">Order</li>
			</ol>
			<div class="card mb-4">
				<div class="card-body">
					<a href="<c:url value='/adminInsertCustomer'/>">
						<button type="button" class="btn btn-dark">
							<i class="ace-icon fa fa-pencil"></i> Add new Order
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
					<i class="fas fa-table me-1"></i> DataTable Order
				</div>
				<div class="card-body">
					<div style="margin-bottom: 30px;">
						<form action="adminFilterOrder" method="post">
							<div style="display: inline-block; margin-right: 40px;">
								<input type="submit" value=" Lọc ">
							</div>

							<div style="display: inline-block; margin-right: 40px;">
								<label> <select name="fOrderDate"
									class="datatable-selector">
										<option value="-1" ${param.fOrderDate == -1 ? 'selected' : ''}>Tất
											cả</option>
										<option value="0" ${param.fOrderDate == 0 ? 'selected' : ''}>Trong
											ngày</option>
										<option value="7" ${param.fOrderDate == 7 ? 'selected' : ''}>Trong
											tuần</option>
										<option value="30" ${param.fOrderDate == 30 ? 'selected' : ''}>Trong
											tháng</option>
										<option value="360"
											${param.fOrderDate == 360 ? 'selected' : ''}>Trong
											năm</option>
										<option value="1080"
											${param.fOrderDate == 1080 ? 'selected' : ''}>Trong
											ba năm</option>
								</select> Ngày đặt hàng
								</label>
							</div>

							<div style="display: inline-block; margin-right: 60px;">
								<label> <select name="fStatuOrder"
									class="datatable-selector">
										<option value="-1"
											${param.fStatuOrder == -1 ? 'selected' : ''}>Tất cả</option>
										<option value="0" ${param.fStatuOrder == 0 ? 'selected' : ''}>Chờ
											xác nhận</option>
										<option value="1" ${param.fStatuOrder == 1 ? 'selected' : ''}>Đã
											xác nhận</option>
										<option value="2" ${param.fStatuOrder == 2 ? 'selected' : ''}>Đóng
											gói</option>
										<option value="3" ${param.fStatuOrder == 3 ? 'selected' : ''}>Đang
											vận chuyển</option>
										<option value="4" ${param.fStatuOrder == 4 ? 'selected' : ''}>Thành
											công</option>
										<option value="5" ${param.fStatuOrder == 5 ? 'selected' : ''}>Đã
											hủy</option>
								</select> Tình trạng đơn hàng
								</label>
							</div>

							<div style="display: inline-block; margin-right: 60px;">
								<label> <select name="fStatuPayment"
									class="datatable-selector">
										<option value="-1"
											${param.fStatuPayment == -1 ? 'selected' : ''}>Tất
											cả</option>
										<option value="0"
											${param.fStatuPayment == 0 ? 'selected' : ''}>Chưa
											thanh toán</option>
										<option value="1"
											${param.fStatuPayment == 1 ? 'selected' : ''}>Đã
											thanh toán</option>
								</select> Trạng thái thanh toán
								</label>
							</div>
						</form>

					</div>

					<table id="datatablesSimple">

						<thead>
							<tr>
								<th>Mã đơn hàng</th>
								<th>Ngày đặt hàng</th>
								<th>Khách hàng</th>
								<th>Người bán</th>
								<th>Người giao</th>
								<th>Tình trạng</th>
								<th>Thanh toán</th>
								<th>Tổng tiền</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="i" items="${listOrder}">
								<tr>
									<td>${i.orderID}</td>
									<td>${i.orderDate}</td>
									<td>${i.customer.lastName} ${i.customer.firstName}</td>
									<td>${i.seller.lastName} ${i.seller.firstName}</td>
									<td>${i.shipper.lastName } ${ i.shipper.firstName}</td>
									<td><c:choose>
											<c:when test="${i.status == 0}">Chờ xác nhận</c:when>
											<c:when test="${i.status == 1}">Đã xác nhận</c:when>
											<c:when test="${i.status == 2}">Đóng gói</c:when>
											<c:when test="${i.status == 3}">Đang giao</c:when>
											<c:when test="${i.status == 4}">Giao thành công</c:when>
											<c:when test="${i.status == 5}">Đã hủy</c:when>
										</c:choose></td>
									<td><c:choose>
											<c:when test="${i.payment.status == 0}">Chưa thanh toán</c:when>
											<c:when test="${i.payment.status == 1}">Đã thanh toán</c:when>
										</c:choose></td>

									<td>${i.totalMoney}</td>
									<td>
										<div class="hidden-sm hidden-xs btn-group">
											<a
												href="<c:url value='/adminUpdateOrder?orderID=${i.orderID}'/>">
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
	</main>
	<!-- <script>
		function onOrderDateChange() {
			filterData(); // Gọi hàm lọc dữ liệu khi combobox Order Date thay đổi
		}

		function onStatusOrderChange() {
			filterData(); // Gọi hàm lọc dữ liệu khi combobox Status Order thay đổi
		}

		function onStatusPaymentChange() {
			filterData(); // Gọi hàm lọc dữ liệu khi combobox Status Payment thay đổi
		}

		function filterData() {
			// Lấy giá trị của các combobox
			var orderDateValue = document.getElementById("orderDateSelector").value;
			var statusOrderValue = document
					.getElementById("statusOrderSelector").value;
			var statusPaymentValue = document
					.getElementById("statusPaymentSelector").value;

			// Gửi yêu cầu POST đến servlet để xử lý việc lọc
			var xhr = new XMLHttpRequest();
			xhr.open("POST", "/your_project/OrderFilterServlet", true);
			xhr.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			xhr.onreadystatechange = function() {
				if (xhr.readyState === 4 && xhr.status === 200) {
					// Xử lý kết quả nếu cần
					console.log(xhr.responseText);
				}
			};

			// Tạo dữ liệu truyền đi
			var data = "orderDateFilter=" + orderDateValue
					+ "&statusOrderFilter=" + statusOrderValue
					+ "&statusPaymentFilter=" + statusPaymentValue;

			// Gửi yêu cầu
			xhr.send(data);
		}
	</script> -->
</body>


</html>


