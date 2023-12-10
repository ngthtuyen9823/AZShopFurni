<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Table - Voucher</title>
</head>
<body>
	<main>
		<div class="container">
			<c:if test="${not empty message }">
				<div class="alert alert-${alert}">
					<strong>${message}!</strong>
				</div>
			</c:if>
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="card shadow-lg border-0 rounded-lg mt-5">
						<div class="card-header">
							<h3 class="text-center font-weight-light my-4">Insert
								Voucher</h3>
						</div>
						<div class="card-body">
							<form action="adminInsertVoucher" method="post">
								<div class="row">
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="voucherID"
												readonly="readonly" /> <label>ID</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="description" />
											<label>Description</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="discount" /> <label>Discount</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="minimumPrice" />
											<label>Minimum Price</label>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="quantity" /> <label>Quantity</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="date" name="mfg" /> <label>Mfg</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="date" name="exp" /> <label>Exp</label>
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