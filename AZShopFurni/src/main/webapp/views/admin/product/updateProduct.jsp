<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UpdateProduct</title>
</head>
<body>
	<main>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="card shadow-lg border-0 rounded-lg mt-5">
						<div class="card-header">
							<h3 class="text-center font-weight-light my-4">Update
								Product</h3>
						</div>
						<div class="card-body">
							<form action="update" method="post">
								<div class="row">
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="productID"
												value="${Product.productID}" readonly="readonly" /> <label>Product
												ID</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="productName"
												value="${Product.productName}" /> <label>Product
												Name</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="description"
												value="${Product.description}" /> <label>Description</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="origin"
												value="${Product.origin}" /> <label>Origin</label>
										</div>
									</div>
									<div class="col-md-6">
										<div  class="form-floating mb-3">
											<select name="category" class="form-control">
												<c:forEach var="category" items="${listCategory}">
													<option value="${category.categoryID}"
														<c:if test="${category.categoryID eq Product.categoryID}">selected</c:if>>${category.categoryName}</option>
												</c:forEach>
											</select> <label>Category</label>
										</div>

										<div class="form-floating mb-3">
											<select name="supplier" class="form-control">
												<c:forEach var="supplier" items="${listSupplier}">
													<option value="${supplier.supplierID}"
														<c:if test="${supplier.supplierID eq Product.supplierID}">selected</c:if>>${supplier.supplierName}</option>
												</c:forEach> 
											</select> <label>Supplier</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="material"
												value="${Product.material}" /> <label>Material</label>
										</div>
									</div>
								</div>
								<div class="text-center mt-4">
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