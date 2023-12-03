<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<title>Đổi mật khẩu</title>
<body>
	<form action="updateAccount" method="post">

		<div class="untree_co-section">
		<div class="container">
			<div class="row">
				<div class="col-md-6 mb-5 mb-md-0">
					<h2 class="h3 mb-3 text-black">Đổi mật khẩu</h2>
					<div class="p-3 p-lg-5 border bg-white">
					
						<input type="hidden" name="UserID" value="${accountModel.userID}">
						<div class="form-group row">
							<div class="col-md-12">
								<input type="hidden" class="form-control" id="c_username" name="UserName" value="${accountModel.userName}">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-12">
								<label for="c_oldpass" class="text-black">Mật khẩu cũ: <span class="text-danger">*</span></label>
								<input type="password" class="form-control" id="c_oldpass" name="OldPassWord">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-md-12">
								<label for="c_pass" class="text-black">Mật khẩu mới: </label>
								<input type="password" class="form-control" id="c_pass" name="Password">
							</div>
						</div>
						<input class="btn btn-black btn-sm" type="submit" value="Thay đổi">
					</div>
				</div>
				
			</div>
		</div>
	</div>
	</form>
</body>
</html>