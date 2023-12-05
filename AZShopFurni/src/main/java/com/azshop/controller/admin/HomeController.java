package com.azshop.controller.admin;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.bean.MyItem;
import com.azshop.service.IReportService;
import com.azshop.service.impl.ReportServiceImpl;

@WebServlet(urlPatterns = { "/adminHome" })
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	IReportService reportService = new ReportServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("adminHome")) {
			Date date = new Date();
	        List<MyItem> listItem = reportService.reportReceipt(date, 7);
	        req.setAttribute("listReceipt", listItem);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/home.jsp");
			rd.forward(req, resp);
		}
	}
}
