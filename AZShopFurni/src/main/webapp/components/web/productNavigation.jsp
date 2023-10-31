<%@page import="com.azshop.models.submodels.CategoryLevelModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, java.util.List"%>
<%@ page import="com.azshop.service.ICategoryService" %>
<%@ page import="com.azshop.service.impl.CategoryServiceImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	// Access the shared value from the ServletContext
	Object listCategoryLevel = application.getAttribute("listCategoryLevel");
	if (listCategoryLevel == null) {
		ICategoryService categoryService = new CategoryServiceImpl();
		List<CategoryLevelModel> listCategoryLevels = categoryService.getCategoryLevels();
		getServletContext().setAttribute("listCategoryLevel", listCategoryLevels);
	}
	%>

	<nav id="main_navbar">
		<nav class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="/products"
				id="navbarDropdown" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> Product </a>
			<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
				<c:forEach items="${listCategoryLevel}" var="category"
					varStatus="loop">
					<li><c:set var="hasChildren"
							value="${not empty category.childrens}" /> <a
						class="dropdown-item ${hasChildren ? 'dropdown-toggle' : ''}"
						href="<c:url value='/products?cateId=${category.categoryID}'/>"
						id="navbarDropdown${loop.index}" role="button"
						data-toggle="${hasChildren ? 'dropdown' : ''}"
						aria-haspopup="${hasChildren ? 'true' : ''}"
						aria-expanded="${hasChildren ? 'false' : ''}">
							${category.categoryName} </a> <c:if test="${hasChildren}">
							<ul class="dropdown-menu"
								aria-labelledby="navbarDropdown${loop.index}">
								<c:forEach items="${category.childrens}" var="childCategory">
									<li><a class="dropdown-item" href="#">${childCategory.categoryName}</a>
									</li>
								</c:forEach>
							</ul>
						</c:if></li>
				</c:forEach>
			</ul>

		</nav>
	</nav>

	<script>
		$(function() {
			$('#main_navbar').bootnavbar();
		})
	</script>

</body>
</html>