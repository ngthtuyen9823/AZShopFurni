<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<body>
	<header>
		<!-- Heading -->
		<div class="container pt-5">
			<nav class="d-flex">
				<h6 class="mb-0">
					<a href="" class="link-dark" style="text-decoration: none;">Home</a>
					<span class="mx-2"> > </span> <a href="" class="link-dark"
						style="text-decoration: none;">${category.categoryName}</a> <span
						class="mx-2"> > </span> <a href="#" class="link-dark"
						style="text-decoration: none;">${product.productName}</a>
				</h6>
			</nav>
		</div>

		<!-- Heading -->
	</header>
	<!-- content -->
	<section class="py-5">
		<div class="container">
			<div class="row gx-5">
				<aside style="padding-right: 3rem;" class="col-lg-6">
					<div class="border rounded-4 mb-3 d-flex justify-content-center">
						<a id="mainImageLink" data-fslightbox="mygalley" class="rounded-4"
							target="_blank" data-type="image" href="#"> <img
							id="mainImage"
							style="max-width: 100%; max-height: 100vh; margin: auto;"
							class="rounded-4 fit" src="${product.listItem[0].image}" />
						</a>
					</div>
					<div class="d-flex justify-content-center mb-3 product-container">
						<c:forEach items="${product.listItem}" var="item" varStatus="loop">
							<div class="" style="flex: 0 0 auto;">
								<!-- Update onmouseover attribute here -->
								<a data-fslightbox="mygalley"
									class="border mx-1 rounded-2 item-thumb" target="_blank"
									data-type="image"
									onmouseover="changeMainImage('${item.image}')"
									style="cursor: pointer;"> <img width="100" height="100"
									class="rounded-2" src="${item.image}" />
								</a>
							</div>
						</c:forEach>
					</div>
				</aside>

				<main class="col-lg-6">
					<div class="ps-lg-3">
						<h3 class="title text-dark">${product.productName}</h3>
						<div class="d-flex flex-row my-3">
							<div class="text-warning mb-1 me-2">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fas fa-star-half-alt"></i> <span class="ms-1">
									${product.avgRating} </span>
							</div>
							<span style="padding-left: 1rem;" class="text-muted">${product.numOfRating}
								ratings | ${product.soldTotal} sold</span>
						</div>
						<div class="mb-3">
							<span class="h5"> <fmt:formatNumber type="currency"
									value="${product.displayedPromotionPrice}" currencyCode="VND"
									pattern="#,##0 VND" var="formattedPrice" />${formattedPrice}
							</span> <span style="text-decoration: line-through; color: #999;">
								<fmt:formatNumber type="currency"
									value="${product.displayedOriginalPrice}" currencyCode="VND"
									pattern="#,##0 VND" var="formattedOriginalPrice" />${formattedOriginalPrice}
							</span>
						</div>
						<div class="row">
							<dt class="col-3">Material</dt>
							<dd class="col-9">${product.material}</dd>
							<dt class="col-3">Brand</dt>
							<dd class="col-9">${supplier.supplierName}</dd>
							<dt class="col-3">Origin</dt>
							<dd class="col-9">${product.origin}</dd>
						</div>
						<div class="row">
							<dt class="col-3">Item</dt>
							<dd class="col-9">
								<div style="display: block;" class="btn-group" role="group"
									aria-label="Basic outlined example">
									<c:forEach items="${product.listItem}" var="item"
										varStatus="loop">
										<button type="button" id="${item.itemID}"
											value="${item.itemID}"
											style="border-color: #bdc3c7; border-style: solid; margin: 6px; padding: 12px">${item.itemID}
											${item.color}</button>
									</c:forEach>
								</div>
							</dd>
						</div>
						<hr />
						<div class="row mb-3 input-group">

							<label
								style="font-weight: 700; margin-left: 1rem; margin-right: 3rem;"
								class="mb-2">Quantity </label>
							<button class="px-3" type="button" id="button-addon1"
								data-mdb-ripple-color="dark" onclick="updateQuantity(-1)">
								<i class="fas fa-minus"></i>
							</button>
							<input type="text" style="flex: 0.2 1 auto;"
								class="form-control text-center border border-secondary"
								id="quantityInput" placeholder="1" aria-label="example"
								aria-describedby="button-addon1" />
							<button class="px-3" type="button" id="button-addon2"
								data-mdb-ripple-color="dark" onclick="updateQuantity(1)">
								<i class="fas fa-plus"></i>
							</button>
						</div>
						<div class="mt-5 row">
							<dd class="col-5">

								<form id="addToOrderForm" action="/products" method="post">
									<a href="#" style="width: 100%; padding: 1rem;"
										class="mr-1 btn btn-warning shadow-0"> Buy now </a>


								</form>
							</dd>
							<dd class="col-5">
								<form id="addToCartForm" action="/products" method="post">
									<input type="hidden" name="itemID" id="selectedItemID" value="">
									<input type="hidden" name="quantity" id="selectedQuantity"
										value="1"> <a href="#"
										style="width: 100%; padding: 1rem;"
										class="btn btn-primary shadow-0"> <i
										class="me-1 fa fa-shopping-basket"></i> Add to cart
									</a>

								</form>
							</dd>
						</div>


					</div>
				</main>
			</div>
		</div>
	</section>
	<!-- content -->
	<section class="product">
		<h2 class="product-category">sản phẩm cùng loại</h2>
		<button class="pre-btn">
			<img src="images/arrow.png" alt="">
		</button>
		<button class="nxt-btn">
			<img src="images/arrow.png" alt="">
		</button>
		<div class="product-container">
			<c:forEach items="${cateProList}" var="item" varStatus="loop">
				<div class="product-card">
					<div class="product-image">
						<span class="discount-tag">50%</span> <img
							src="${item.displayedImage}" class="product-thumb" alt="">
					</div>
					<div class="product-info">
						<h2 class="product-brand">${item.productName}</h2>
						<p class="product-short-description">${item.description}</p>
						<span class="price">${item.displayedPromotionPrice}đ</span><span
							class="actual-price">${item.displayedOriginalPrice}</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
