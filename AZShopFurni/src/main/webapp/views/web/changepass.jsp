<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!doctype html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/vendor/bootstrap/css/bootstrap.min.css"/>">
  <!-- Style -->
  <link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/css/login.css"/>">


  <title>Đổi mật khẩu</title>
</head>

<body>



  <div class="login">
    <div class="contents">
      <div class="row align-items-center justify-content-center">
        <div class="col-md-7">
          <h3>
            <strong>Đổi mật khẩu</strong>
          </h3>
          <h2>${mess}</h2>
          <form action="changepass" method="post">
          	<input type="hidden" name="formail" value="${formail}"/>
            <div class="form-group">
              <label for="username">Mật khẩu mới</label> <input type="text" class="form-control"
                placeholder="Nhập tài khoản" name="passchange">
            </div>
            <div class="form-group">
              <label for="password">Mật khẩu xác nhận</label> <input type="password" class="form-control"
                placeholder="Nhập mật khẩu" name="passcheck">
            </div>
            <div class="form-group w-100 mt-4">
              <input type="submit" value="Đổi mật khẩu" class="btn btn-block btn-primary">
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</body>

</html>