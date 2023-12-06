package com.azshop.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.dao.ICategoryDAO;
import com.azshop.dao.ISupplierDAO;
import com.azshop.dao.impl.CategoryDAOImpl;
import com.azshop.dao.impl.SupplierDAOImpl;
import com.azshop.models.CategoryModel;
import com.azshop.models.ProductModel;
import com.azshop.models.SupplierModel;
import com.azshop.service.IProductService;
import com.azshop.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/adminProduct"})
public class ProductController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IProductService ProSer = new ProductServiceImpl();
	ICategoryDAO cateser = new CategoryDAOImpl();
	ISupplierDAO suppser = new SupplierDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			List<CategoryModel> listcate = cateser.findAll();
			List<ProductModel> listProduct  = ProSer.findAll();
			List<SupplierModel> listSupplier = suppser.findAll();
			req.setAttribute("listSupplier", listSupplier);
			req.setAttribute("listProduct", listProduct);
			req.setAttribute("listCate", listcate);
			req.getRequestDispatcher("/views/admin/product/product.jsp").forward(req, resp);
			
	}
}
