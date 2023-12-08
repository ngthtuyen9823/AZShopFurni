package com.azshop.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azshop.models.VoucherModel;
import com.azshop.service.IVoucherService;
import com.azshop.service.impl.VoucherServiceImpl;

@WebServlet(urlPatterns = { "/listVoucher" })
@MultipartConfig
public class VoucherController extends HttpServlet{

	IVoucherService voucherService = new VoucherServiceImpl();
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("user") != null) {
			String url = req.getRequestURI().toString();
			if (url.contains("listVoucher")) {
				listVoucher(req, resp);
			} 
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
	
	private void listVoucher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<VoucherModel> listVoucher = voucherService.findAllVoucher();
		
		req.setAttribute("listVoucher", listVoucher);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/voucher/listVoucher.jsp");
		rd.forward(req, resp);
	}
}
