<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InsertProduct</title>
</head>
<body>
	<main>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="card shadow-lg border-0 rounded-lg mt-5">
						<div class="card-header">
							<h3 class="text-center font-weight-light my-4">Insert
								Product</h3>
						</div>
						<div class="card-body">
							<form action="insertProduct" method="post">
								<div class="row">
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="productName" />
											<label>Product Name</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="description" />
											<label>Description</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="origin" /> <label>Origin</label>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<select name="category" class="form-control">
												<option value="" style="text-align: center">--
													Select --</option>
												<c:forEach var="category" items="${listCategory}">
													<option value="${category.categoryID}"
														style="text-align: center">${category.categoryName}</option>
												</c:forEach>
											</select> <label>Category</label>
										</div>

										<div class="form-floating mb-3">
											<select name="supplier" class="form-control">
												<option value="" style="text-align: center">--
													Select --</option>
												<c:forEach var="supplier" items="${listSupplier}">
													<option value="${supplier.supplierID}"
														style="text-align: center">${supplier.supplierName}</option>
												</c:forEach>
											</select> <label>Supplier</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="material" /> <label>Material</label>
										</div>
									</div>
								</div>
								<div class="text-center mt-4">
									<input type="submit" class="btn btn-primary" value="Insert" />
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