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
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="card shadow-lg border-0 rounded-lg mt-5">
						<div class="card-header">
							<h3 class="text-center font-weight-light my-4">Update Seller</h3>
						</div>
						<div class="card-body">
							<form action="adminUpdateSeller" method="post">
								<div class="row">
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="userID"
												value="${seller.userID}" readonly="readonly" /> <label>ID</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="firstName"
												value="${seller.firstName}" /> <label>First Name</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="lastName"
												value="${seller.lastName}" /> <label>Last Name</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="address"
												value="${seller.address}" /> <label>Address</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="gender"
												value="${seller.gender}" /> <label>Gender</label>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="phone"
												value="${seller.phone}" /> <label>Phone</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="date" name="dob"
												value="${seller.dob}" /> <label>DoB</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="cid"
												value="${seller.cid}" /> <label>CID</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="avatar"
												value="${seller.avatar}" /> <label>Avatar</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="kpi"
												value="${seller.kpi}" /> <label>KPI</label>
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