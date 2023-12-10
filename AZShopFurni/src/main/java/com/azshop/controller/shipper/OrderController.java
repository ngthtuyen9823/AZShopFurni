package com.azshop.controller.shipper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azshop.models.OrderModel;
import com.azshop.models.UserModel;
import com.azshop.service.IOrderService;
import com.azshop.service.IShipperService;
import com.azshop.service.impl.OrderServiceImpl;
import com.azshop.service.impl.ShipperServiceImpl;

@WebServlet(urlPatterns = { "/shipper-list-need-ship", "/shipper-list-shipping", "/shipper-list-history-ship",
		"/shipper-detail-order", "/shipper-accept", "/shipper-complete" })
public class OrderController extends HttpServlet {

	IOrderService orderService = new OrderServiceImpl();
	IShipperService shipperDAO = new ShipperServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		UserModel shipper = shipperDAO.findOne(120001);
		HttpSession session1 = req.getSession(true);
		session1.setAttribute("user", shipper);

		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("user") != null) {
			UserModel user = (UserModel) session.getAttribute("user");
			List<OrderModel> listOrder = new ArrayList<OrderModel>();

			String url = req.getRequestURI().toString();
			if (url.contains("detail")) {
				showDetailPage(req, resp);

			} else if (url.contains("need")) {
				listOrder = orderService.findNeedShipByArea("");
				req.setAttribute("listOrder", listOrder);
				RequestDispatcher rd = req.getRequestDispatcher("/views/shipper/listNeedShipOrder.jsp");
				rd.forward(req, resp);

			} else if (url.contains("shipping")) {
				listOrder = orderService.findShipingByShipperID(user.getUserID());
				req.setAttribute("listOrder", listOrder);
				RequestDispatcher rd = req.getRequestDispatcher("/views/shipper/listShippingOrder.jsp");
				rd.forward(req, resp);

			} else if (url.contains("history")) {
				listOrder = orderService.findHisDeliveryByShipperID(user.getUserID());
				req.setAttribute("listOrder", listOrder);
				RequestDispatcher rd = req.getRequestDispatcher("/views/shipper/listHisShipOrder.jsp");
				rd.forward(req, resp);
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}

	}

	private void showDetailPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrderModel order = orderService.findShipByID(Integer.parseInt(req.getParameter("orderID")));
		req.setAttribute("order", order);
		RequestDispatcher rd = req.getRequestDispatcher("/views/shipper/detailOrder.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("user") != null) {
			UserModel user = (UserModel) session.getAttribute("user");
			OrderModel order = orderService.findShipByID(Integer.parseInt(req.getParameter("orderID")));

			String url = req.getRequestURI().toString();
			if (url.contains("accept")) {
				order.setShipperID(user.getUserID());
				orderService.updateOrder(order);
				resp.sendRedirect("shipper-list-need-ship");

			} else if (url.contains("complete")) {
				order.setStatus(4);
				order.setDeliveryTime(new Date());
				orderService.updateOrder(order);
				resp.sendRedirect("shipper-list-shipping");

			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
}