package com.azshop.controller.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azshop.models.CategoryModel;
import com.azshop.models.ProductModel;
import com.azshop.models.SearchHistoryModel;
import com.azshop.models.SupplierModel;
import com.azshop.models.UserModel;
import com.azshop.service.ICategoryService;
import com.azshop.service.IProductService;
import com.azshop.service.ISearchHistoryService;
import com.azshop.service.ISupplierService;
import com.azshop.service.impl.CategoryServiceImpl;
import com.azshop.service.impl.ProductServiceImpl;
import com.azshop.service.impl.SearchHistoryServiceImpl;
import com.azshop.service.impl.SupplierServiceImpl;

@WebServlet(urlPatterns = { "/products" ,"/search"})
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IProductService productService = new ProductServiceImpl();
	ICategoryService categoryService = new CategoryServiceImpl();
	ISupplierService supplierService = new SupplierServiceImpl();
	ISearchHistoryService searchHistoryService=new SearchHistoryServiceImpl();
	RequestDispatcher rd = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		showHistorySearch(req, resp);
		String url = req.getRequestURI().toString();
		if (url.contains("products")) {
			String idString = req.getParameter("id");
			if (idString != null) {
				int id = Integer.parseInt(req.getParameter("id"));
				ProductModel productModel = productService.findOne(id);
				CategoryModel categoryModel = categoryService.findOne(productModel.getCategoryID());
				SupplierModel supplierModel = supplierService.findOne(productModel.getSupplierID());
				List<ProductModel> cateProList = productService.findByCategoryID(categoryModel.getCategoryID());

				req.setAttribute("cateProList", cateProList);
				req.setAttribute("product", productModel);
				req.setAttribute("category", categoryModel);
				req.setAttribute("supplier", supplierModel);

				rd = req.getRequestDispatcher("/views/web/products/productdetail.jsp");
			} else {
				String cateIdString = req.getParameter("cateId");
				String pageString = req.getParameter("page");
				int page = pageString != null ? Integer.parseInt(pageString) : 1;
				int pageSize = 12;
				List<ProductModel> listProduct = new ArrayList<ProductModel>();
				List<CategoryModel> listRootCategory = categoryService.getRootCategories();

				if (cateIdString != null) {
					int cateId = Integer.parseInt(cateIdString);
					List<CategoryModel> listCateChild = categoryService.geChidlCategories(cateId);
					CategoryModel categoryModel = categoryService.findOne(cateId);
					CategoryModel rootCategory = categoryService.findRootCategoryByCategoryId(cateId);
					listProduct = productService.findByCategoryID(cateId);

					req.setAttribute("childCategories", listCateChild);
					req.setAttribute("category", categoryModel);
					req.setAttribute("rootcategory", rootCategory);
				} else {
					listProduct = productService.findAll();
				}

				req.setAttribute("cateId", cateIdString);
				String filterPrice = req.getParameter("price");
				String filterRating = req.getParameter("rating");
				String sortProduct = req.getParameter("sort");
				listProduct=filterAndSortProduct(listProduct, filterPrice, filterRating, sortProduct);

				int totalPage = listProduct.size() > 0 ? listProduct.size() / pageSize : 0;
				int start = (page - 1) * pageSize;
				int end = Math.min(start + pageSize, listProduct.size());

				req.setAttribute("price", filterPrice);
				req.setAttribute("sort", sortProduct);
				req.setAttribute("rating", filterRating);

				req.setAttribute("products", listProduct.subList(start, end));
				req.setAttribute("page", page);
				req.setAttribute("totalPage", totalPage);
				req.setAttribute("rootCategories", listRootCategory);

				rd = req.getRequestDispatcher("/views/web/products/products.jsp");
			}

			rd.forward(req, resp);
		}else if (url.contains("/search")) {
			List<ProductModel> listProduct = new ArrayList<ProductModel>();
			String keyword = req.getParameter("keyword");
			HttpSession session=req.getSession();
			if(keyword != null) {
				if(session!=null && session.getAttribute("user")!=null) {
					UserModel user=(UserModel) session.getAttribute("user");
					SearchHistoryModel historySearch=new SearchHistoryModel();
					historySearch.setCustomerID(user.getUserID());
					historySearch.setCreatedAt(new Timestamp(new Date().getTime()));
					historySearch.setHistory(keyword);
					searchHistoryService.insertSearchHistory(historySearch);
				}
				listProduct = productService.searchProductByName(keyword);

			}
			String filterPrice = req.getParameter("price");
			String filterRating = req.getParameter("rating");
			String sortProduct = req.getParameter("sort");
			listProduct=filterAndSortProduct(listProduct, filterPrice, filterRating, sortProduct);
		
			req.setAttribute("keyword", keyword);
			req.setAttribute("price", filterPrice);
			req.setAttribute("sort", sortProduct);
			req.setAttribute("rating", filterRating);
			req.setAttribute("products", listProduct);
			req.getRequestDispatcher("/views/web/products/products.jsp").forward(req, resp);
		}
	}

	private void showHistorySearch(HttpServletRequest req,HttpServletResponse resp ) throws ServletException, IOException {
		HttpSession session=req.getSession();
		if(session!=null && session.getAttribute("user")!=null) {
			UserModel user=(UserModel) session.getAttribute("user");
			List<SearchHistoryModel> searchHistory=searchHistoryService.getHistorySearchByCID(user.getUserID());
			req.setAttribute("history", searchHistory);
		}
	}
	private List<ProductModel> filterAndSortProduct(List<ProductModel> listProduct, String filterPrice, String rating, String sortProduct){
		if(filterPrice!=null && !filterPrice.isEmpty()) {
			listProduct=filterByPrice(listProduct, filterPrice);
		}
		if (rating != null && !rating.isEmpty()) {
			listProduct = filterByRating(listProduct, rating);
		}
		if (sortProduct != null && !sortProduct.isEmpty()) {
			listProduct = sortProduct(listProduct, sortProduct);
		}
		return listProduct;
	}
	private List<ProductModel> filterByPrice(List<ProductModel> listProduct, String priceRange) {
		String[] priceRangeValue = priceRange.split("-");
		int minPrice = Integer.parseInt(priceRangeValue[0]);
		int maxPrice = Integer.parseInt(priceRangeValue[1]);
		return listProduct.stream().filter(ProductModel -> ProductModel.getDisplayedOriginalPrice() >= minPrice
				&& ProductModel.getDisplayedOriginalPrice() <= maxPrice).collect(Collectors.toList());

	}

	private List<ProductModel> filterByRating(List<ProductModel> listProduct, String rating) {
		Double rate = Double.parseDouble(rating);
		return listProduct.stream().filter(ProductModel -> ProductModel.getAvgRating() >= rate)
				.collect(Collectors.toList());
	}

	private List<ProductModel> sortProduct(List<ProductModel> listProduct, String sortProduct) {
		if (sortProduct.equals("asc")) {
			Collections.sort(listProduct, Comparator.comparing(ProductModel::getDisplayedOriginalPrice));
		} else {
			Collections.sort(listProduct, Comparator.comparing(ProductModel::getDisplayedOriginalPrice).reversed());
		}
		return listProduct;
	}
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI().toString();
		if (url.contains("addToCart")) {
			addToOrder(req, resp);
		}
	}

	protected void addToOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CartModel cart = new CartModel();
		// Get the parameters from the request
		int itemID = Integer.parseInt(req.getParameter("itemID"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		System.out.println(itemID);
		System.out.println(quantity);
		cart.setCustomerID(100001);
		cart.setItemID(itemID);
		cart.setQuantity(quantity);
		cartService.insert(cart);

	}
}
