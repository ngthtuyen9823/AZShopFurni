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

import com.azshop.models.OrderModel;
import com.azshop.models.UserModel;
import com.azshop.service.IOrderService;
import com.azshop.service.impl.OrderServiceImpl;

@WebServlet(urlPatterns = { "/listOrder", "/customerConfirm", "/detailOrder" })
@MultipartConfig
public class OrderController extends HttpServlet {

	IOrderService orderService = new OrderServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("user") != null) {
			String url = req.getRequestURI().toString();
			if (url.contains("listOrder")) {
				listOrder(req, resp);
			} else if (url.contains("detailOrder")) {
				detailOrder(req, resp);
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("customerConfirm")) {
			String act = req.getParameter("action");
			String conf = req.getParameter("confirm");
			int orderID = Integer.parseInt(req.getParameter("orderID"));
			if ("cancelOrder".equals(act)) {
				orderService.updateOrder(orderID, 5);
				listOrder(req, resp);
			} else if ("confirmOrder".equals(act)) {
				orderService.confirmOrder(orderID, 1);
				listOrder(req, resp);
			} else if ("confirmDetailOrder".equals(act)) {
				orderService.confirmOrder(orderID, 1);
				detailOrder(req, resp);
			} else if ("cancelDetailOrder".equals(act)) {
				orderService.updateOrder(orderID, 5);
				detailOrder(req, resp);
			} else if ("rateOrder".equals(conf)) {
				// adasd
			}
		}
	}

	private void listOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		UserModel user = (UserModel) session.getAttribute("user");
		List<OrderModel> listOrder = orderService.listOrderByCustomerID(user.getUserID());
		
		req.setAttribute("listOrder", listOrder);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/order/listOrder.jsp");
		rd.forward(req, resp);
	}
	
	private void detailOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int orderID = Integer.parseInt(req.getParameter("orderID"));
		
		OrderModel order = orderService.getOrderByOrderID(orderID);
		req.setAttribute("order", order);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/order/detailOrder.jsp");
		rd.forward(req, resp);
	}
}
