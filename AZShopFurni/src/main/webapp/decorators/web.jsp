<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!doctype html>
<html lang="en">
<head>
	<title>About</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="<c:url value="/templates/web/images/icons/favicon.png"/>">
	<link rel="icon" type="image/png" href="<c:url value="/templates/web/images/icons/icon-heart-02.png"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/vendor/bootstrap/css/bootstrap.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/fonts/iconic/css/material-design-iconic-font.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/fonts/linearicons-v1.0.0/icon-font.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/vendor/animate/animate.css"/>">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/vendor/css-hamburgers/hamburgers.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/vendor/animsition/css/animsition.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/vendor/select2/select2.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/vendor/perfect-scrollbar/perfect-scrollbar.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/css/util.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/css/main.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/css/products/products.css"/>">
<!--===============================================================================================-->
</head>
<body>
	<%@ include file="/common/web/header.jsp"%>
	<decorator:body></decorator:body>
	<%@ include file="/common/web/footer.jsp"%>
	
<!--===============================================================================================-->	
	<script src="<c:url value="/templates/web/vendor/jquery/jquery-3.2.1.min.js"/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="/templates/web/vendor/animsition/js/animsition.min.js"/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="/templates/web/vendor/bootstrap/js/popper.js"/>"></script>
	<script src="<c:url value="/templates/web/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="/templates/web/vendor/select2/select2.min.js"/>"></script>
	<script>
		$(".js-select2").each(function(){
			$(this).select2({
				minimumResultsForSearch: 20,
				dropdownParent: $(this).next(".dropDownSelect2")
			});
		})
	</script>
<!--===============================================================================================-->
	<script src="<c:url value="/templates/web/vendor/MagnificPopup/jquery.magnific-popup.min.js"/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="/templates/web/vendor/perfect-scrollbar/perfect-scrollbar.min.js"/>"></script>
	<script>
		$(".js-pscroll").each(function(){
			$(this).css("position","relative");
			$(this).css("overflow","hidden");
			var ps = new PerfectScrollbar(this, {
				wheelSpeed: 1,
				scrollingThreshold: 1000,
				wheelPropagation: false,
			});

			$(window).on("resize", function(){
				ps.update();
			})
		});
	</script>
<!--===============================================================================================-->
	<script src="<c:url value="/templates/web/js/main.js"/>"></script>
	
</body>
</html>