<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertItem</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
	<main>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="card shadow-lg border-0 rounded-lg mt-5">
						<div class="card-header">
							<h3 class="text-center font-weight-light my-4">Thêm mặt hàng</h3>
						</div>
						<div class="card-body">
							<form action="admininsertItem" method="post" enctype="multipart/form-data">
								<div class="row">
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="productID"
												readonly="readonly" value="${ProID}" /> <label>Mã sản phẩm</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="color" /> <label>Màu sắc</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="color" name="colorCode"
												id="colorCodeInput" /> <label>Mã màu</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="size" /> <label>Kích thước</label>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="stock" /> <label>Số lượng tồn</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="originalPrice"
												id="originalPriceInput" /> <label>Giá gốc</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="promotionPrice" />
											<label>Giá khuyến mãi</label>
										</div>
									</div>
								</div>
								<div class="text-center mt-4">
									<input type="file" name ="image" multiple="multiple">
								</div>
								<div class="text-center mt-4">
									<input type="submit" class="btn btn-primary" value="Thêm" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<!-- <script type="text/javascript">
		document.addEventListener('DOMContentLoaded',
				function() {
					var priceInputs = document
							.querySelectorAll('input[name*="Price"]');

					priceInputs.forEach(function(input) {
						input.addEventListener('blur', formatCurrency);
						input.addEventListener('focus', removeCurrency);
					});

					function formatCurrency(event) {
						var input = event.target;
						var value = input.value;

						// Xóa các ký tự không phải là số và dấu chấm trong giá trị nhập vào
						var numericValue = value.replace(/[^0-9.]/g, '');

						// Định dạng giá trị thành chuỗi có dấu phân cách hàng nghìn và ký hiệu VND
						var formattedValue = numericValue.replace(
								/\B(?=(\d{3})+(?!\d))/g, ',')
								+ ' VND';

						// Gán giá trị đã định dạng vào input
						input.value = formattedValue;
					}

					function removeCurrency(event) {
						var input = event.target;
						var value = input.value;

						// Xóa ký hiệu VND trong giá trị nhập vào
						var numericValue = value.replace(' VND', '');

						// Gán giá trị đã xóa ký hiệu VND vào input
						input.value = numericValue;
					}
				});
	</script> -->
</body>
</html>