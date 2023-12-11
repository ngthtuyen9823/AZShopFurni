<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/templates/web/css/product.css"/>'
	rel="stylesheet" />
</head>

<body>
	<!-- Product -->
	<section class="bg0 p-t-23 p-b-130">
		<div class="container">
			<div class="p-b-10">
				<h3 class="ltext-103 cl5">Product Overview</h3>
			</div>
			<div class="flex-w flex-sb-m p-b-52">
				<div class="flex-w flex-l-m filter-tope-group m-tb-10">
					<a href="<c:url value='/products'/>"
						class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5 ${rootcategory.categoryID == null ? 'how-active1' : ''}"
						data-filter="*">All Products</a>

					<c:forEach items="${rootCategories}" var="item">
						<a href="<c:url value='/products?cateId=${item.categoryID}'/>"
							class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5 ${rootcategory.categoryID == item.categoryID ? 'how-active1' : ''}"
							data-filter="*">${item.categoryName}</a>
					</c:forEach>
				</div>
				<div class="flex-w flex-c-m m-tb-10">
					<div
						class="flex-c-m stext-106 cl6 size-104 bor4 pointer hov-btn3 trans-04 m-r-8 m-tb-4 js-show-filter">
						<i
							class="icon-filter cl2 m-r-6 fs-15 trans-04 zmdi zmdi-filter-list"></i>
						<i
							class="icon-close-filter cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"></i>
						Filter
					</div>
					<div
						class="flex-c-m stext-106 cl6 size-105 bor4 pointer hov-btn3 trans-04 m-tb-4 js-show-search">
						<i class="icon-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-search"></i>
						<i
							class="icon-close-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"></i>
						Search
					</div>
				</div>
				<!-- Search product -->
				<form class="dis-none panel-search w-full p-t-10 p-b-15"
					action="${pageContext.request.contextPath}/search" method="get">
					<div class="dis-none panel-search w-full p-t-10 p-b-15">
						<div class="bor8 dis-flex p-l-15">
							<button class="size-113 flex-c-m fs-16 cl2 hov-cl1 trans-04 ">
								<i class="zmdi zmdi-search"></i>
							</button>
							<input class="mtext-107 cl2 size-114 plh2 p-r-15" type="text"
								name="keyword" placeholder="Search">
						</div>
					</div>
				</form>
				<!-- Filter -->
				<div class="dis-none panel-filter w-full p-t-10">
					<div
						class="wrap-filter flex-w bg6 w-full p-lr-40 p-t-27 p-lr-15-sm">
						<div class="filter-col1 p-r-15 p-b-27">
							<div class="mtext-102 cl2 p-b-15">Sort By</div>
							<ul>
								<!-- <li class="p-b-6"><a href="#"
									class="filter-link stext-106 trans-04"> Popularity </a></li> -->

								<!-- <li class="p-b-6"><a href="#"
									class="filter-link stext-106 trans-04 filter-link-active">
										Newness </a></li> -->

								<li class="p-b-6"><button onclick=" changSort('asc')"
										class="filter-link stext-106 trans-04 ${sort == 'asc' ? 'filter-link-active' : ''}">
										Price: Low to High</button></li>

								<li class="p-b-6"><button onclick=" changSort('desc')"
										class="filter-link stext-106 trans-04 ${sort == 'desc' ? 'filter-link-active' : ''}">Price:
										High to Low</button></li>
							</ul>
						</div>
						<div class="filter-col2 p-r-15 p-b-27">
							<div class="mtext-102 cl2 p-b-15">Price</div>
							<ul>
								<li class="p-b-6"><button onclick=" changPrice('')"
										class="filter-link stext-106 trans-04 ${price == '' ? 'filter-link-active' : ''}">All</button></li>
								<li class="p-b-6"><button
										onclick=" changPrice('0-1000000')"
										class="filter-link stext-106 trans-04 ${price == '0-1000000' ? 'filter-link-active' : ''}">Dưới
										1 triệu</button></li>

								<li class="p-b-6"><button
										onclick=" changPrice('1000000-5000000')"
										class="filter-link stext-106 trans-04 ${price == '1000000-5000000' ? 'filter-link-active' : ''}">Từ
										1-5 triệu</button></li>

								<li class="p-b-6"><button
										onclick=" changPrice('5000000-10000000')"
										class="filter-link stext-106 trans-04 ${price == '5000000-10000000' ? 'filter-link-active' : ''}">Từ
										5-10 triệu</button></li>
								<li class="p-b-6"><button
										onclick=" changPrice('10000000-50000000')"
										class="filter-link stext-106 trans-04 ${price == '10000000-50000000' ? 'filter-link-active' : ''}">Trên
										10 triệu</button></li>
							</ul>
						</div>
						<div class="filter-col2 p-r-15 p-b-27">
							<div class="mtext-102 cl2 p-b-15">Rating</div>
							<ul>
								<li class="p-b-6">
									<button onclick="changeRating('5')"
										class="filter-link stext-106 trans-04 ${rating == '5' ? 'filter-link-active' : ''}">
										<i class="fas fa-star" style="color: gold;"></i><i
											class="fas fa-star" style="color: gold;"></i><i
											class="fas fa-star" style="color: gold;"></i><i
											class="fas fa-star" style="color: gold;"></i><i
											class="fas fa-star" style="color: gold;"></i>
									</button>
								</li>
								<li class="p-b-6">
									<button onclick="changeRating('4')"
										class="filter-link stext-106 trans-04 ${rating == '4' ? 'filter-link-active' : ''}">
										<i class="fas fa-star" style="color: gold;"></i><i
											class="fas fa-star" style="color: gold;"></i><i
											class="fas fa-star" style="color: gold;"></i><i
											class="fas fa-star" style="color: gold;"></i><i
											class="fa fa-star"></i> trở lên
									</button>
								</li>
								<li class="p-b-6">
									<button onclick="changeRating('3')"
										class="filter-link stext-106 trans-04 ${rating == '3' ? 'filter-link-active' : ''}">
										<i class="fas fa-star" style="color: gold;"></i><i
											class="fas fa-star" style="color: gold;"></i><i
											class="fas fa-star" style="color: gold;"></i><i
											class="fa fa-star"></i><i class="fa fa-star"></i> trở lên
									</button>
								</li>
								<li class="p-b-6">
									<button onclick="changeRating('2')"
										class="filter-link stext-106 trans-04 ${rating == '2' ? 'filter-link-active' : ''}">
										<i class="fas fa-star" style="color: gold;"></i><i
											class="fas fa-star" style="color: gold;"></i><i
											class="fa fa-star"></i><i class="fa fa-star"></i><i
											class="fa fa-star"></i> trở lên
									</button>
								</li>
								<li class="p-b-6">
									<button onclick="changeRating('1')"
										class="filter-link stext-106 trans-04 ${rating == '1' ? 'filter-link-active' : ''}">
										<i class="fas fa-star" style="color: gold;"></i><i
											class="fa fa-star"></i><i class="fa fa-star"></i><i
											class="fa fa-star"></i><i class="fa fa-star"></i> trở lên
									</button>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<!-- List Category -->
			<c:if test="${childCategories.size() > 0}">
				<div class="cate-container">
					<span class="stext-105 cl3 weight-600">${category.categoryName}
						Collection</span>
					<div class="row isotope-grid cate-grid">
						<c:forEach items="${childCategories}" var="item">
							<div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item ">
								<div class="block2">
									<div class="block2-pic hov-img0 category-image-size"
										data-label="New">
										<img src="${item.image}" alt="IMG-CATEGORY"> <a
											href="<c:url value='/products?cateId=${item.categoryID}'/>"
											class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04">
											View </a>
									</div>

									<div class="block2-txt flex-w flex-t p-t-14">
										<div class="block2-txt-child1 flex-col-l ">
											<a
												href="<c:url value='/products?cateId=${item.categoryID}'/>"
												class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
												${item.categoryName} </a>
										</div>

									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

			</c:if>

			<!-- List Products -->
			<div class="row isotope-grid">
				<c:if test="${products.size() > 0}">
					<c:forEach items="${products}" var="item">
						<div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item ">
							<div class="block2">
								<div class="block2-pic hov-img0 label-new product-image-size"
									data-label="New">
									<img src="${item.displayedImage}" alt="IMG-PRODUCT"> <a
										href='<c:url value="/products?id=${item.productID}"/>'
										class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04">
										View</a>
								</div>

								<div class="block2-txt flex-w flex-t p-t-14">
									<div class="block2-txt-child1 flex-col-l ">
										<a href='<c:url value="/products?id=${item.productID}"/>'
											class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
											${item.productName} </a> <span class="stext-105 cl3">
											${item.description} </span> <span class="stext-105 cl3 weight-600">
											<fmt:formatNumber type="currency"
												value="${item.displayedOriginalPrice}" currencyCode="VND"
												pattern="#,##0 VND" var="formattedPrice" />
											${formattedPrice}
										</span> <span class="stext-105 cl3"> <i class="fas fa-star"
											style="${item.avgRating >= 1 ? 'color: gold;' : ''}"></i> <i
											class="fas fa-star"
											style="${item.avgRating >= 2 ? 'color: gold;' : ''}"></i> <i
											class="fas fa-star"
											style="${item.avgRating >= 3 ? 'color: gold;' : ''}"></i> <i
											class="fas fa-star"
											style="${item.avgRating >= 4 ? 'color: gold;' : ''}"></i> <i
											class="fas fa-star"
											style="${item.avgRating >= 5 ? 'color: gold;' : ''}"></i>
										</span>
									</div>

									<div class="block2-txt-child2 flex-r p-t-3">
										<a href="#"
											class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
											<img class="icon-heart1 dis-block trans-04" alt="ICON"
											src='https://storage.googleapis.com/web-budget/Image/icons/icon-heart-01.png' />
											<img class="icon-heart2 dis-block trans-04 ab-t-l" alt="ICON"
											src='https://storage.googleapis.com/web-budget/Image/icons/icon-heart-02.png' />
										</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>

					<!-- Pagination -->
					<div class="flex-c-m flex-w w-full p-t-38">
						<!-- Generate pagination links dynamically based on the totalPage -->
						<c:forEach begin="1" end="${totalPage}" varStatus="loop">
							<button onclick="changePage('${loop.index}')"
								class="flex-c-m how-pagination1 trans-04 m-all-7 ${page == loop.index ? 'active-pagination1' : ''}">${loop.index}</button>
						</c:forEach>
					</div>
				</c:if>
			</div>
		</div>
	</section>

	<script>
		var params = {
			keyword : "${keyword}",
			cateId : "${cateId}",
			sort : "${sort}",
			price : "${price}",
			rating : "${rating}",
			page : "${page}",
		};
		function run() {
			var url = "?"
					+ Object.keys(params).map(
							function(key) {
								if (params[key] !== null
										&& params[key] !== undefined
										&& params[key] !== "") {
									return encodeURIComponent(key) + '='
											+ encodeURIComponent(params[key]);
								}
							}).filter(Boolean).join('&');

			window.location.href = url;
		}

		function changPrice(price) {
			params["price"] = price;
			params["page"] = 1
			run(0);
		}

		function changSort(sort) {
			params["sort"] = sort;
			params["page"] = 1
			run(0);
		}
		function changeRating(rating) {
			params["rating"] = rating;
			params["page"] = 1
			run(0);
		}

		function changePage(page) {
			params["page"] = page
			run(0);
		}
	</script>

</body>

</html>