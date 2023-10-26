<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Untree.co">
<link rel="shortcut icon" href="favicon.png">

<meta name="description" content="" />
<meta name="keywords" content="bootstrap, bootstrap4" />
<link href='<c:url value="/templates/web/css/style.css"/>'
	rel="stylesheet" />
<link href='<c:url value="/templates/web/css/bootstrap.min.css"/>'
	rel="stylesheet" />

<link href='<c:url value="/templates/web/css/tiny-slider.css"/>'
	rel="stylesheet" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	rel="stylesheet">
<title><decorator:title default="Trang chủ" /></title>
</head>
<body>
	<%@ include file="/common/web/header.jsp"%>
	<div class="container">
		<decorator:body></decorator:body>
	</div>
	<%@ include file="/common/web/footer.jsp"%>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="<c:url value="/templates/web/js/tiny-slider.js"/>"></script>
	<script src="<c:url value="/templates/web/js/custom.js"/>"></script>
</body>
</html>