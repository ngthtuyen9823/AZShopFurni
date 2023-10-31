<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav
	class="custom-navbar navbar navbar navbar-expand-md navbar-dark bg-dark"
	arial-label="Furni navigation bar">
	<div class="container">
		<a class="navbar-brand" href="#">AZ Shop<span>.</span></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarsFurni" aria-controls="navbarsFurni"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarsFurni">
			<ul class="custom-navbar-nav navbar-nav ms-auto mb-2 mb-md-0">
				<li class="nav-item "><a class="nav-link" href="#">Home</a></li>
				<li>
					<%@ include file="/components/web/productNavigation.jsp"%>
				</li>
				<li class="active"><a class="nav-link" href="#">About us</a></li>
				<li><a class="nav-link" href="#">Services</a></li>
				<li><a class="nav-link" href="#">Blog</a></li>
				<li><a class="nav-link" href="#">Contact us</a></li>
			</ul>
			<ul class="custom-navbar-cta navbar-nav mb-2 mb-md-0 ms-5">
				<li><a class="nav-link" href="#"><img
						src="<c:url value="/images/user.svg"/>"></a></li>
				<li><a class="nav-link" href="#"><img
						src="<c:url value="/images/cart.svg"/>"></a></li>
			</ul>
		</div>
	</div>
</nav>