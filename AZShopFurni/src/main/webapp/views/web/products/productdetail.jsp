<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<header>
	<div class="container pt-5">
		<nav class="d-flex">
			<h6 class="mb-0">
				<a href="" class="link-dark" style="text-decoration: none;">Home</a>
				<span class="mx-2"> > </span> <a href="" class="link-dark"
					style="text-decoration: none;">${product.categoryName}</a> <span
					class="mx-2"> > </span> <a href="#" class="link-dark"
					style="text-decoration: none;">${product.productName}</a>
			</h6>
		</nav>
	</div>
</header>
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
							<a data-fslightbox="mygalley"
								class="border mx-1 rounded-2 item-thumb" target="_blank"
								data-type="image" onmouseover="changeMainImage('${item.image}')"
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
						<dd class="col-9">${product.supplierName}</dd>
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
								<div id="errorContainer" style="color: red;"></div>
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
							<form id="buyNowForm" action="buyNow" method="post">
								<div>
									<input type="hidden" name="selectedItemID" id="selectedItemID"
										value=""> <input type="hidden" name="selectedQuantity"
										id="selectedQuantity" value="1">
								</div>
								<div class="text-center">
									<input type="submit" value="Buy now"
										style="width: 100%; padding: 1rem; cursor: pointer;"
										class="mr-1 btn btn-warning shadow-0" readonly
										onmouseover="this.style.cursor='pointer';"
										onmouseout="this.style.cursor='default';" />
								</div>
							</form>
						</dd>
						<dd class="col-5">
							<form id="addToCartForm" action="#" method="post">
								<div class="text-center">
									<input onclick="addToCart()"
										style="width: 100%; padding: 1rem; cursor: pointer;"
										class="btn btn-primary shadow-0" value="Add to cart" readonly
										onmouseover="this.style.cursor='pointer';"
										onmouseout="this.style.cursor='default';" />
								</div>
							</form>
						</dd>
					</div>
				</div>
			</main>
		</div>
	</div>
</section>

<section
	style="box-shadow: 0 -1px 0px 1px rgba(0, 0, 0, 0.1); background-color: #FFFFFF;"
	class="content-item" id="comments">
	<div class="container" style="padding: 20px;">

		<h3 style="margin-bottom: 20px;">Product Ratings</h3>

		<div id="reviews" class="review-section"
			style="border-bottom: none; padding-bottom: 15px; padding-top: 0; display: flex; justify-content: space-between;">

			<div class="col-md-6">
				<table class="stars-counters" style="width: 100%;">
					<tbody>
						<tr>
							<td>
								<button
									class="fit-button fit-button-color-blue fit-button-fill-ghost fit-button-size-medium stars-filter">5
									Stars</button>
							</td>
							<td class="progress-bar-container">
								<div
									class="fit-progressbar fit-progressbar-bar star-progress-bar">
									<div class="fit-progressbar-background">
										<span class="progress-fill" style="width: 97.2973%;"></span>
									</div>
								</div>
							</td>
							<td class="star-num">(36)</td>
						</tr>
						<!-- Add similar rows for other star ratings -->
					</tbody>
				</table>
			</div>
		</div>

		<!-- Iterate over the detailList and display media items -->
		<c:forEach items="${detailList}" var="item" varStatus="loop">
			<div class="media"
				style="margin-top: 20px; border: 1px solid #ccc; padding: 15px; border-radius: 5px;">

				<a class="pull-left" href="#"><img class="media-object"
					src="${item.avatar}" alt=""
					style="border-radius: 50%; width: 80px; height: 80px;"></a>
				<div class="media-body">
					<h4 class="media-heading">${item.name}</h4>
					<p>${item.content}</p>
					<ul class="list-unstyled list-inline media-detail pull-left">
						<li><i class="fa fa-calendar"></i>${item.evaluationDate}</li>
					</ul>
					<ul class="list-unstyled list-inline media-detail pull-right">
						<li class=""><a href="">Reply</a></li>
					</ul>
				</div>
			</div>
		</c:forEach>

		<!-- Review Form -->
		<div class="review-form" style="margin-top: 20px; padding: 20px;">
			<form>
				<h3 style="margin-bottom: 25px;">Add new Comment</h3>

				<fieldset>
					<div class="row">
						<div class="col-sm-3 col-lg-1 hidden-xs">
							<img style="width: 50px; border-radius: 50%;"
								class="img-responsive"
								src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="">
						</div>
						<div class="form-group col-xs-12 col-sm-9 col-lg-10">
							<textarea
								style="width: 100%; padding: 15px; box-sizing: border-box; font-size: 1.2rem; height: 150px"
								class="form-control" id="message" placeholder="Your message"
								required=""></textarea>
						</div>
				</fieldset>
				<button type="submit"
					style="margin-top: 10px; padding: 10px; background-color: #4CAF50; color: #fff; border: none; cursor: pointer;"
					class="btn btn-normal pull-right">Submit</button>
			</form>
		</div>
	</div>
</section>

<!-- content -->
<section class="product">
	<h2 class="product-category">sản phẩm liên quan</h2>
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
					<a href="<c:url value='/products?id=${item.productID}' />"
						class="product-image"> <span class="discount-tag">50%</span> <img
						src="${item.displayedImage}" class="product-thumb" alt="">
					</a>
				</div>
				<div class="product-info">
					<h2 class="product-brand">${item.productName}</h2>
					<p class="product-short-description">${item.description}</p>
					<span class="price"><fmt:formatNumber type="currency"
							value="${item.displayedPromotionPrice}" currencyCode="VND"
							pattern="#,##0 VND" var="formattedPrice" />${formattedPrice}</span><span
						class="actual-price"><fmt:formatNumber type="currency"
							value="${item.displayedOriginalPrice}" currencyCode="VND"
							pattern="#,##0 VND" var="formattedPrice" />${formattedPrice}</span>
				</div>
			</div>
		</c:forEach>
	</div>
</section>