<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet" />

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="<c:url value="/templates/web/images/icons/favicon.png"/>">
	<link rel="icon" type="image/png" href="<c:url value="/templates/web/images/icons/icon-heart-02.png"/>">
<!--===============================================================================================-->
<!--===============================================================================================-->
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/web/vendor/bootstrap/css/bootstrap.min.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/web/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/web/fonts/iconic/css/material-design-iconic-font.min.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/web/fonts/linearicons-v1.0.0/icon-font.min.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/web/vendor/animate/animate.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/web/vendor/css-hamburgers/hamburgers.min.css"/>">
<!--===============================================================================================-->

<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/web/vendor/animsition/css/animsition.min.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/web/vendor/perfect-scrollbar/perfect-scrollbar.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/web/vendor/select2/select2.min.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/web/vendor/daterangepicker/daterangepicker.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/web/vendor/slick/slick.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/web/vendor/MagnificPopup/magnific-popup.css"/>">
<!--===============================================================================================-->
<link href='<c:url value="/templates/web/css/products/tiny-slider.css"/>'
	rel="stylesheet" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	rel="stylesheet">
	<link href='<c:url value="templates/admin/css/styles.css"/>'
	rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/css/util.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/css/main.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/templates/web/css/products/products.css"/>">
<link href='<c:url value="/templates/web/css/products/product-detail.css"/>'
	rel="stylesheet" />
	
<link href='<c:url value="/templates/web/css/carts/carts.css"/>'
	rel="stylesheet" />

<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>
</head>
<body class="sb-nav-fixed">
	<!-- header -->
	<%@ include file="/common/seller/header.jsp"%>
	<!-- header -->
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<%@ include file="/common/seller/menu.jsp"%>
		</div>
		<div id="layoutSidenav_content">
			<decorator:body></decorator:body>
			<!-- footer -->
			<%@ include file="/common/seller/footer.jsp"%>
			<!-- footer -->
		</div>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src='<c:url value="templates/admin/js/scripts.js"/>'></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script
		src='<c:url value="templates/admin/assets/demo/chart-area-demo.js"/>'></script>
	<script
		src='<c:url value="templates/admin/assets/demo/chart-bar-demo.js"/>'></script>
	<script
		src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
		crossorigin="anonymous"></script>
	<script
		src='<c:url value="templates/admin/js/datatables-simple-demo.js"/>'></script>
	<script src='<c:url value="templates/admin/js/snippets.js"/>'></script>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<!-- Include SweetAlert library from CDN -->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>


	<script
		src="<c:url value="/templates/web/vendor/jquery/jquery-3.2.1.min.js"/>"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/templates/web/vendor/animsition/js/animsition.min.js"/>"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/templates/web/vendor/bootstrap/js/popper.js"/>"></script>
	<script
		src="<c:url value="/templates/web/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/templates/web/vendor/select2/select2.min.js"/>"></script>
	<script>
		$(".js-select2").each(function() {
			$(this).select2({
				minimumResultsForSearch : 20,
				dropdownParent : $(this).next(".dropDownSelect2")
			});
		})
	</script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/templates/web/vendor/MagnificPopup/jquery.magnific-popup.min.js"/>"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/templates/web/vendor/perfect-scrollbar/perfect-scrollbar.min.js"/>"></script>
	<script>
		$(".js-pscroll").each(function() {
			$(this).css("position", "relative");
			$(this).css("overflow", "hidden");
			var ps = new PerfectScrollbar(this, {
				wheelSpeed : 1,
				scrollingThreshold : 1000,
				wheelPropagation : false,
			});

			$(window).on("resize", function() {
				ps.update();
			})
		});
	</script>
	<!--===============================================================================================-->
	<script src="<c:url value="/templates/web/js/main.js"/>"></script>
	<script src="<c:url value="/templates/web/js/product-detail.js"/>"></script>
	<script src="<c:url value="/templates/web/js/tiny-slider.js"/>"></script>

	<!--===============================================================================================-->
	<script
		src="<c:url value="/templates/web/vendor/jquery/jquery-3.2.1.min.js"/>"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/templates/web/vendor/bootstrap/js/popper.js"/>"></script>
	<script
		src="<c:url value="/templates/web/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
	<!--===============================================================================================-->
	<!--===============================================================================================-->
	<script
		src="<c:url value="/templates/web/vendor/daterangepicker/moment.min.js"/>"></script>
	<script
		src="<c:url value="/templates/web/vendor/daterangepicker/daterangepicker.js"/>"></script>
	<!--===============================================================================================-->
	<script src="<c:url value="/templates/web/vendor/slick/slick.min.js"/>"></script>
	<script src="<c:url value="/templates/web/js/slick-custom.js"/>"></script>
	<!--===============================================================================================-->
	<script src="<c:url value="vendor/parallax100/parallax100.js"/>"></script>
	<script>
		$('.parallax100').parallax100();
	</script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/templates/web/vendor/MagnificPopup/jquery.magnific-popup.min.js"/>"></script>
	<script>
		$('.gallery-lb').each(function() { // the containers for all your galleries
			$(this).magnificPopup({
				delegate : 'a', // the selector for gallery item
				type : 'image',
				gallery : {
					enabled : true
				},
				mainClass : 'mfp-fade'
			});
		});
	</script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/templates/web/vendor/isotope/isotope.pkgd.min.js"/>"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/templates/web/vendor/sweetalert/sweetalert.min.js"/>"></script>
	<script>
		$('.js-addwish-b2').on('click', function(e) {
			e.preventDefault();
		});

		$('.js-addwish-b2').each(
				function() {
					var nameProduct = $(this).parent().parent().find(
							'.js-name-b2').html();
					$(this).on('click', function() {
						swal(nameProduct, "is added to wishlist !", "success");

						$(this).addClass('js-addedwish-b2');
						$(this).off('click');
					});
				});

		$('.js-addwish-detail').each(
				function() {
					var nameProduct = $(this).parent().parent().parent().find(
							'.js-name-detail').html();

					$(this).on('click', function() {
						swal(nameProduct, "is added to wishlist !", "success");

						$(this).addClass('js-addedwish-detail');
						$(this).off('click');
					});
				});

		/*---------------------------------------------*/

		$('.js-addcart-detail').each(
				function() {
					var nameProduct = $(this).parent().parent().parent()
							.parent().find('.js-name-detail').html();
					$(this).on('click', function() {
						swal(nameProduct, "is added to cart !", "success");
					});
				});
	</script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/templates/web/vendor/perfect-scrollbar/perfect-scrollbar.min.js"/>"></script>
	<script>
		$('.js-pscroll').each(function() {
			$(this).css('position', 'relative');
			$(this).css('overflow', 'hidden');
			var ps = new PerfectScrollbar(this, {
				wheelSpeed : 1,
				scrollingThreshold : 1000,
				wheelPropagation : false,
			});

			$(window).on('resize', function() {
				ps.update();
			})
		});
	</script>
</body>
</html>