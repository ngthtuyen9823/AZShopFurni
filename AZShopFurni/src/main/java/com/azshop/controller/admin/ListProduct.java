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
import com.azshop.service.IProductService;
import com.azshop.service.impl.ProductServiceImpl;


@WebServlet(urlPatterns = {"/insert", "/delete", "/update"})
public class ListProduct extends HttpServlet{
	IProductService ProSer = new ProductServiceImpl();
	ICategoryDAO cate = new CategoryDAOImpl();
	ISupplierDAO supp = new SupplierDAOImpl();
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("insert"))
		{
			insert(req, resp);
		}
		else if(url.contains("delete"))
		{
			delete(req, resp);
		}
		else if(url.contains("update"))
		{
			update(req, resp);
		}	
	}
	private void insert (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		List <CategoryModel> listcate = new ArrayList<CategoryModel>();
		for( CategoryModel list : cate.findAll())
		{
			if(list.getParentCategoryID()!= 0)
			{
				listcate.add(list);
			}
		}
	    req.setAttribute("danhsachLoai", listcate);
	    req.setAttribute("danhsachncc", supp.findAll());
		RequestDispatcher rd = req.getRequestDispatcher("/views/listpro.jsp");
		rd.forward(req, resp);
	}
	private void delete (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}
	private void update (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String ten = req.getParameter("ten");
		String mota = req.getParameter("mota");
		String ngg = req.getParameter("ngg");
		int ncc =  Integer.parseInt(req.getParameter("ncc"));
		int loai = Integer.parseInt(req.getParameter("loai"));
		String ngl = req.getParameter("ngl");
		
		ProductModel Pro = new ProductModel();
		Pro.setProductName(ten);
		Pro.setDescription(mota);
		Pro.setOrigin(ngg);
		Pro.setSupplierID(ncc);
		Pro.setCategoryID(loai);
		Pro.setMaterial(ngl);
		
		ProSer.insertProduct(Pro);
	}

}
