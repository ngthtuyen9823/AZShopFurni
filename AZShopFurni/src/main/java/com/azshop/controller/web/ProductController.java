package com.azshop.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.models.ProductModel;
import com.azshop.service.IProductService;
import com.azshop.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/products/getproduct", "/products"})
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		
		if (url.contains("getproduct")) {
			int id = Integer.parseInt(req.getParameter("id"));
			ProductModel model = productService.findOne(id);
			req.setAttribute("product", model);
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/products/product.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
