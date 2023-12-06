<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<body>
	<div class="container padding-bottom-3x mb-1">
		<!-- Shopping Cart-->
		<div class="table-responsive shopping-cart">
			<table class="table">
				<thead>
					<tr>
						<th>Product Name</th>
						<th class="text-center">Unit Price</th>
						<th class="text-center">Quantity</th>
						<th class="text-center">Total Price</th>
						<th class="text-center"><a
							class="btn btn-sm btn-outline-danger" href="#">Clear Cart</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" items="${carts}">
						<tr>
							<td>
								<div class="product-item">
									<a class="product-thumb" href="#"><img
										src="https://www.bootdey.com/image/220x180/FF0000/000000"
										alt="Product"></a>
									<div class="product-info">
										<h4 class="product-title">
											<a href="#">Unionbay Park</a>
										</h4>
										<span><em>Size:</em> 10.5</span><span><em>Color:</em>
											Dark Blue</span>
									</div>
								</div>
							</td>

							<td class="text-center text-lg text-medium">$43.90</td>
							<td class="text-center">
								<div class="input-group" style="justify-content: center;">
									<button class="px-3" type="button" id="button-addon1"
										data-mdb-ripple-color="dark" onclick="updateQuantity(-1)">
										<i class="fas fa-minus"></i>
									</button>
									<input type="text" style="flex: 0.2 1 auto;"
										class="form-control text-center border border-secondary"
										id="quantityInput" placeholder="${i.quantity}"
										aria-label="example" aria-describedby="button-addon1" />
									<button class="px-3" type="button" id="button-addon2"
										data-mdb-ripple-color="dark" onclick="updateQuantity(1)">
										<i class="fas fa-plus"></i>
									</button>
								</div>
							</td>
							<td class="text-center text-lg text-medium">$18.00</td>
							<td class="text-center"><a class="remove-from-cart" href="#"
								data-toggle="tooltip" title="" data-original-title="Remove item"><i
									class="fa fa-trash"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="shopping-cart-footer">
			<div class="column">
				<form class="coupon-form" method="post">
					<input class="form-control form-control-sm" type="text"
						placeholder="Coupon code" required="">
					<button class="btn btn-outline-primary btn-sm" type="submit">Apply
						Coupon</button>
				</form>
			</div>
			<div class="column text-lg">
				Subtotal: <span class="text-medium">$289.68</span>
			</div>
		</div>
		<div class="shopping-cart-footer">
			<div class="column">
				<a class="btn btn-outline-secondary" href="#"><i
					class="icon-arrow-left"></i>&nbsp;Back to Shopping</a>
			</div>
			<div class="column">
				<a class="btn btn-primary" href="#" data-toast=""
					data-toast-type="success" data-toast-position="topRight"
					data-toast-icon="icon-circle-check" data-toast-title="Your cart"
					data-toast-message="is updated successfully!">Update Cart</a><a
					class="btn btn-success" href="#">Checkout</a>
			</div>
		</div>
	</div>
</body>
