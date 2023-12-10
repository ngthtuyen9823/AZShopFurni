package com.azshop.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.service.IDetailService;
import com.azshop.service.impl.DetailServiceImpl;
@WebServlet(urlPatterns = "/home")
public class HomeController extends HttpServlet{
	
	IDetailService detailService = new DetailServiceImpl();
	private static final long serialVersionUID = 4317368494648713183L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<List<Object>> listBestSeller = detailService.listBestSeller();
		req.setAttribute("list", listBestSeller);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, resp);
	}
}
