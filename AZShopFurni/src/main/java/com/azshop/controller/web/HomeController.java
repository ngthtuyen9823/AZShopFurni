package com.azshop.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.models.submodels.CategoryLevelModel;
import com.azshop.service.ICategoryService;
import com.azshop.service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	ICategoryService categoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryLevelModel> listCategoryLevel = categoryService.getCategoryLevels();
		
		//*INFO: Initialize list category value one time
		getServletContext().setAttribute("listCategoryLevel", listCategoryLevel);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, resp);
		
	}

}
