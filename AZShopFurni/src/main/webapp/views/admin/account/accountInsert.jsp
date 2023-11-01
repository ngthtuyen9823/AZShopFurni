<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="adminUpdateAccount" method="post">
	<input type="text" value="${account.userID}" name="userID" readonly="readonly">
	<input type="text" value="${account.userName}" name="userName" >
	<input type="text" value="${account.password}" name="password" >
	<input type="submit" value="UPDATE">
	</form>

</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Table - Account</title>
</head>
<body>
	<main>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="card shadow-lg border-0 rounded-lg mt-5">
						<div class="card-header">
							<h3 class="text-center font-weight-light my-4">Insert
								Account</h3>
						</div>
						<div class="card-body">
							<form action="adminInsertAccount" method="post">
								<div class="row">
									<div class="form-floating mb-3">
										<input class="form-control" type="text" name="userID" /> <label>UserID</label>
									</div>
									<div class="form-floating mb-3">
										<input class="form-control" type="text" name="userName" /> <label>User
											Name</label>
									</div>
									<div class="form-floating mb-3">
										<input class="form-control" type="text" name="password" /> <label>Password</label>
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

