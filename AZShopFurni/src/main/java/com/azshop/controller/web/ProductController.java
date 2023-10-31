package com.azshop.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.models.CategoryModel;
import com.azshop.models.ProductModel;
import com.azshop.models.SupplierModel;
import com.azshop.models.submodels.CategoryLevelModel;
import com.azshop.service.ICategoryService;
import com.azshop.service.IProductService;
import com.azshop.service.ISupplierService;
import com.azshop.service.impl.CategoryServiceImpl;
import com.azshop.service.impl.ProductServiceImpl;
import com.azshop.service.impl.SupplierServiceImpl;

@WebServlet(urlPatterns = { "/products"})
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IProductService productService = new ProductServiceImpl();
	ICategoryService categoryService = new CategoryServiceImpl();
	ISupplierService supplierService = new SupplierServiceImpl();
	RequestDispatcher rd = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI().toString();
		if (url.contains("products")) {
			String idString = req.getParameter("id");
			
			if(idString != null) {
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
			}
			else {
				rd = req.getRequestDispatcher("/views/web/products/products.jsp");
			}
			
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
