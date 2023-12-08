<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

	<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
		<div class="sb-sidenav-menu">
			<div class="nav">
				<div class="sb-sidenav-menu-heading">Core</div>
				<a class="nav-link" href="<c:url value='/adminHome'/>">
					<div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
					Dashboard
				</a>
				<div class="sb-sidenav-menu-heading">Management</div>
				<a class="nav-link" href="adminAccount"> <div class="sb-nav-link-icon"><i class="bi bi-person-vcard-fill"></i>
					</div> Account
				</a> 
				<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
					data-bs-target="#collapseLayouts" aria-expanded="false"
					aria-controls="collapseLayouts">
					<div class="sb-nav-link-icon">
						<i class="bi bi-people"></i>
					</div> User
					<div class="sb-sidenav-collapse-arrow">
						<i class="fas fa-angle-down"></i>
					</div>
				</a>
				<div class="collapse" id="collapseLayouts"
					aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
					<nav class="sb-sidenav-menu-nested nav">
						<a class="nav-link" href="<c:url value='/adminCustomer'/>">Customer</a>
						<a class="nav-link" href="<c:url value='/adminSeller'/>">Seller</a>
						<a class="nav-link" href="<c:url value='/adminShipper'/>">Shipper</a>
					</nav>

				</div>
				<a class="nav-link" href="adminProduct"> <div class="sb-nav-link-icon"><i class="bi bi-diagram-2"></i>
					</div> Product
				</a> 
				<a class="nav-link" href="adminVoucher"> <div class="sb-nav-link-icon"><i class="bi bi-nvme"></i>
					</div> Voucher
				</a> 
				<a class="nav-link" href="adminKPI"> <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i>
					</div> KPI
				</a> 
				<div class="sb-sidenav-menu-heading">Addons</div>
				<a class="nav-link" href="charts.html"> <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i>
					</div> Charts
				</a> 
				<a class="nav-link" href="tables.html">
					<div class="sb-nav-link-icon">
						<i class="fas fa-table"></i>
					</div> Tables
				</a>

			</a>
		
			
		</div>

		<div class="sb-sidenav-footer">
			<div class="small">Logged in as:</div>
			Admin
		</div>
	</nav>

