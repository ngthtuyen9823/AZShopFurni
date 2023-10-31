<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@include file="/images/cross.svg"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Untree.co">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://raw.githubusercontent.com/daneden/animate.css/master/animate.css">
<link rel="shortcut icon" href="favicon.png">
<meta name="description" content="" />
<meta name="keywords" content="bootstrap, bootstrap4" />
<link href='<c:url value="/templates/web/css/bootstrap.min.css"/>'
	rel="stylesheet" />
<link href='<c:url value="/templates/web/css/tiny-slider.css"/>'
	rel="stylesheet" />
<link href='<c:url value="/templates/web/css/bootnavbar.css"/>'
	rel="stylesheet" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	rel="stylesheet">
<link href='<c:url value="/templates/web/css/product-detail.css"/>'
	rel="stylesheet" />
<link href='<c:url value="/templates/web/css/style.css"/>'
	rel="stylesheet" />
<title><decorator:title default="Trang chủ" /></title>

</head>
<body>
	<%@ include file="/common/web/header.jsp"%>

	<decorator:body></decorator:body>

	<%@ include file="/common/web/footer.jsp"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="<c:url value="/templates/web/js/tiny-slider.js"/>"></script>
	<script src="<c:url value="/templates/web/js/custom.js"/>"></script>
	<script src="<c:url value="/templates/web/js/product-detail.js"/>"></script>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script src="/templates/web/js/bootnavbar.js"></script>
</body>
</html>