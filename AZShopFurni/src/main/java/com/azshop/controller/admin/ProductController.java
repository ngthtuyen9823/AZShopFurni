package com.azshop.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

@WebServlet(urlPatterns = { "/adminProduct", "/admininsertProduct", "/admindeleteProduct", "/adminupdateProduct"})
public class ProductController extends HttpServlet {
	IProductService prod = new ProductServiceImpl();
	ICategoryDAO cate = new CategoryDAOImpl();
	ISupplierDAO supp = new SupplierDAOImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("admininsertProduct")) {
			insert(req, resp);
		} else if (url.contains("admindeleteProduct")) {
			delete(req, resp);
		} else if (url.contains("adminupdateProduct")) {
			update(req, resp);
		} else if(url.contains("adminProduct"))
		{	
			List(req,resp);
		}
	}

	
	private void List (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> listcate = cate.findAll();
		List<ProductModel> listProduct  = prod.findAllProduct();
		List<SupplierModel> listSupplier = supp.findAll();
		req.setAttribute("listSupplier", listSupplier);
		req.setAttribute("listProduct", listProduct);
		req.setAttribute("listCate", listcate);
		req.getRequestDispatcher("/views/admin/product/ListProduct.jsp").forward(req, resp);	
}
	private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> listcate = new ArrayList<CategoryModel>();
		for (CategoryModel list : cate.findAll()) {
			if (list.getParentCategoryID() != 0) {
				listcate.add(list);
			}
		}
		req.setAttribute("listCategory", listcate);
		req.setAttribute("listSupplier", supp.findAll());
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/insertProduct.jsp");
		rd.forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productID = Integer.parseInt(req.getParameter("ProductID"));
		// System.out.println(productID);
		prod.deleteProduct(productID);
		resp.sendRedirect("adminProduct");
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> listcate = new ArrayList<CategoryModel>();
		for (CategoryModel list : cate.findAll()) {
			if (list.getParentCategoryID() != 0) {
				listcate.add(list);
			}
		}
		int productID = Integer.parseInt(req.getParameter("ProductID"));
		req.setAttribute("Product", prod.findOneProduct(productID));
		req.setAttribute("listCategory", listcate);
		req.setAttribute("listSupplier", supp.findAll());
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/updateProduct.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("admininsertProduct")) {
			postinsert(req, resp);
			
		} else if (url.contains("adminupdateProduct")) {
			postupdate(req, resp);
		}
	}


	private void postupdate(HttpServletRequest req, HttpServletResponse resp)throws IOException {
		int productID = Integer.parseInt(req.getParameter("productID"));
		String productName = req.getParameter("productName");
		String description = req.getParameter("description");
		String origin = req.getParameter("origin");
		int supplierID = Integer.parseInt(req.getParameter("supplier"));
		int categoryID = Integer.parseInt(req.getParameter("category"));
		String material = req.getParameter("material");

		ProductModel Pro = new ProductModel();
		Pro.setProductID(productID);
		Pro.setProductName(productName);
		Pro.setDescription(description);
		Pro.setOrigin(origin);
		Pro.setSupplierID(supplierID);
		Pro.setCategoryID(categoryID);
		Pro.setMaterial(material);

		prod.updateProduct(Pro);
		resp.sendRedirect("adminProduct");
		
	}


	private void postinsert(HttpServletRequest req, HttpServletResponse resp)throws IOException {
		
		String productName = req.getParameter("productName"); 
		String description = req.getParameter("description"); 
		String origin = req.getParameter("origin"); 
		int supplierID = Integer.parseInt(req.getParameter("supplier")); 
		int categoryID = Integer.parseInt(req.getParameter("category")); 
		String material = req.getParameter("material"); 
		 
		int id = prod.CreateProductID(categoryID); 
		ProductModel Pro = new ProductModel(); 
		Pro.setProductID(id); 
		Pro.setProductName(productName); 
		Pro.setDescription(description); 
		Pro.setOrigin(origin); 
		Pro.setSupplierID(supplierID); 
		Pro.setCategoryID(categoryID); 
		Pro.setMaterial(material); 
 
		prod.insertProduct(Pro); 
		resp.sendRedirect("adminProduct"); 
	}
}
