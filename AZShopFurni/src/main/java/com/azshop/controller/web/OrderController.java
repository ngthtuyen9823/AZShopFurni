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

import com.azshop.models.OrderModel;
import com.azshop.service.IOrderService;
import com.azshop.service.impl.OrderServiceImpl;

@WebServlet(urlPatterns = { "/listOrder", "/customerConfirm" })
@MultipartConfig
public class OrderController extends HttpServlet{

	IOrderService orderService = new OrderServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("listOrder")) {
			listOrder(req, resp);
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
               // orderService.updateOrder(orderID, 5);
                listOrder(req, resp);
            } else if ("confirmOrder".equals(act)) {
            	//orderService.confirmOrder(orderID, 1);
            	listOrder(req, resp);
            } else if ("rateOrder".equals(conf)) {
            	//adasd
            }
		}
	}
	
	private void listOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//int customerID = Integer.parseInt(req.getParameter("UserID"));
		//List<OrderModel> listOrder = orderService.listOrder(120007);
		
		//req.setAttribute("listOrder", listOrder);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/listOrder.jsp");
		rd.forward(req, resp);
	}
}
