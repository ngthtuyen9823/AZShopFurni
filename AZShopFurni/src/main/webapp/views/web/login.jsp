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


  <title>Đăng nhập</title>
</head>

<body>



  <div class="login">
    <div class="contents">
      <div class="row align-items-center justify-content-center">
        <div class="col-md-7">
          <h3>
            <strong>ĐĂNG NHẬP</strong>
          </h3>
          <h2>${mess}</h2>
          <form action="/AZShopFurni/login" method="post">
            <div class="form-group">
              <label for="username">Tài khoản</label> <input type="text" class="form-control"
                placeholder="Nhập tài khoản" name="username" value="${username}">
            </div>
            <div class="form-group">
              <label for="password">Mật khẩu</label> <input type="password" class="form-control"
                placeholder="Nhập mật khẩu" name="password">
            </div>
            <div class="form-group d-flex align-items-center">
              <label class="control control--checkbox "> <span class="caption">Nhớ tài khoản</span> <input
                  type="checkbox" checked="checked" name="remember" value="on" />
                <div class="control__indicator"></div>
              </label> <span class="control ml-auto"><a href="${pageContext.request.contextPath}/forgetpass" class="forgot-pass">Quên
                  mật khẩu</a></span>
            </div>
            <div class="form-group w-100 mt-4">
              <input type="submit" value="Đăng nhập" class="btn btn-block btn-primary">
            </div>
          </form>
          <div class="form-group mb-3">
            <span class="caption ml-auto">Nếu bạn chưa có tài khoản</span>
            <a href="${pageContext.request.contextPath}/signup">Đăng ký tại đây </a>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>

</html>