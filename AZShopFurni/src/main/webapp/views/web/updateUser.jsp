<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<title>Chỉnh sửa thông tin</title>
<body>
<form action="updateUser" method="post" enctype="multipart/form-data">
	
	<section class="ftco-about img ftco-section ftco-no-pt ftco-no-pb" id="about-section">
		<div class="container">
			<div class="row d-flex no-gutters">
				<div class="col-md-6 col-lg-6 d-flex">
					<div class="p-3 p-lg-5 border bg-white">
						<div class="overlay"></div>
						<img src="${userModel.avatar}" height="400" width="auto"
                			 alt="Avatar">
					</div>
				</div>
				<div class="col-md-6 col-lg-6 pl-md-5 py-5">
					<h2 class="h3 mb-3 text-black">Cập nhật thông tin</h2>
					<div class="p-3 p-lg-5 border bg-white">
						<input type="hidden" name="UserID" value="${userModel.userID}">
						<div class="form-group row">
							<div class="col-md-6">
								<label for="c_fname" class="text-black">Tên <span class="text-danger">*</span></label>
								<input type="text" class="form-control" id="c_fname" name="FirstName" value="${userModel.firstName}">
							</div>
							<div class="col-md-6">
								<label for="c_lname" class="text-black">Họ và tên đệm <span class="text-danger">*</span></label>
								<input type="text" class="form-control" id="c_lname" name="LastName" value="${userModel.lastName}">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-md-12">
								<label for="c_companyname" class="text-black">Địa chỉ </label>
								<input type="text" class="form-control" id="c_addr" name="Address" value="${userModel.address}">
							</div>
						</div>

						<div class="form-group">
							<label for="c_country" class="text-black">Giới tính </label>
							<select id="c_gd" class="form-control" name="Gender">
								<option>Select a value</option>
								<option value="0">Nam</option>
								<option value="1">Nữ</option>
							</select>
						</div>

						<div class="form-group row">
							<div class="col-md-6">
								<label for="c_fname" class="text-black">Số điện thoại <span
										class="text-danger">*</span></label>
								<input type="text" class="form-control" id="c_phone" name="Phone" value="${userModel.phone}">
							</div>
							<div class="col-md-6">
								<label for="c_lname" class="text-black">Căn cước công dân <span
										class="text-danger">*</span></label>
								<input type="text" class="form-control" id="c_id" name="Cid" value="${userModel.cid}">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-md-12">
								<label for="c_address" class="text-black">Ngày sinh</label>
								<input type="date" class="form-control" id="c_dob" name="Dob" value="${userModel.dob}">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-12">
								<label for="c_ava" class="text-black">Avatar</label>
								<input type="file"  id="c_ava" name="Avatar" <%-- value="${userModel.avatar} --%>>
							</div>
						</div>
						
						<input type="hidden" name="Type" value="${userModel.type}">
						<input type="hidden" name="Email" value="${userModel.email}">
						<%-- <input type="hidden" name="KPI" value="${userModel.kpi}">
						<input type="hidden" name="Area" value="${userModel.area}"> --%>
						<input class="btn btn-black btn-sm" type="submit" value="Chỉnh sửa">
					</div>
				</div>
			</div>
		</div>
	</section>
</form>
</body>
</html>