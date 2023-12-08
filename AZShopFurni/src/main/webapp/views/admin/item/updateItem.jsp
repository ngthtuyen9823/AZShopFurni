<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UpdateItem</title>
</head>
<body>
	<main>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="card shadow-lg border-0 rounded-lg mt-5">
						<div class="card-header">
							<h3 class="text-center font-weight-light my-4">Update Item</h3>
						</div>
						<div class="card-body">
							<form action="adminupdateItem" method="post" enctype="multipart/form-data">
								<div class="row">
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="productID"
												readonly="readonly" value="${item.productID}" /> <label>Product
												ID</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="color"
												value="${item.color}" /> <label>Color</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="color" name="colorCode"
												id="colorCodeInput" value="${ item.colorCode}" /> <label>Color
												Code</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="size"
												value="${item.size}" /> <label>Size</label>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="stock"
												value="${item.stock}" /> <label>Stock</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="originalPrice"
												id="originalPriceInput" value="${item.originalPrice}" /> <label>Original
												Price</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="promotionPrice"
												value="${item.promotionPrice}" /> <label>Promotion
												Price</label>
										</div>
									</div>
								</div>

								<div class="text-center mt-4">
									<c:forEach var="i" items="${ images}">
										<img src="${i.image}" height="80px">
									</c:forEach>
									<c:if test="${empty images}">
										<input type="file" name="image" multiple="multiple">
										
											
									</c:if>
									<div class="text-center mt-4">
										<a href="<c:url value="/updateimage?ItemID=${item.itemID}"/>"><button
												type="button" class="btn btn-primary">Clear Image</button></a>
									</div>
								</div>
								<div class="text-center mt-4">
								<input type="hidden" name="itemID" value= "${item.itemID}"/>
									<input type="submit" class="btn btn-primary" value="Update" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>