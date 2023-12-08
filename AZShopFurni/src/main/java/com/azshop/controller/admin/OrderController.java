package com.azshop.controller.admin;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azshop.bean.MyItem;
import com.azshop.models.DetailModel;
import com.azshop.models.OrderModel;
import com.azshop.models.PaymentModel;
import com.azshop.models.UserModel;
import com.azshop.service.IDetailService;
import com.azshop.service.IOrderService;
import com.azshop.service.IPaymentService;
import com.azshop.service.IReportService;
import com.azshop.service.IUserService;
import com.azshop.service.impl.DetailServiceImpl;
import com.azshop.service.impl.OrderServiceImpl;
import com.azshop.service.impl.PaymentServiceImpl;
import com.azshop.service.impl.ReportServiceImpl;
import com.azshop.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/adminOrder", "/adminUpdateOrder", "/aminDeleteOrder", "/adminFilterOrder" })
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IOrderService orderService = new OrderServiceImpl();
	IUserService userService = new UserServiceImpl();
	IPaymentService paymentService = new PaymentServiceImpl();
	IReportService reportService = new ReportServiceImpl();
	IDetailService detailService = new DetailServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(true);
		// session.getAttribute("listItem");
		session.getAttribute("listTotal");
		String url = req.getRequestURI().toString();
		if (url.contains("adminOrder")) {
			findAllOrder(req, resp);
		}else if(url.contains("adminUpdateOrder")) {
			updateOrder(req,resp);
		}
	}

	private void updateOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int orderID = Integer.parseInt(req.getParameter("orderID"));
		List<OrderModel> listOrder1 = orderService.findAllOrder();
		OrderModel order= listOrder1.stream().filter(OrderModel -> OrderModel.getOrderID()==orderID).findFirst().orElse(null);
		List<DetailModel> listdeDetailModels = detailService.listDetail(orderID);
		order.setDetails(listdeDetailModels);
		req.setAttribute("order", order);
		req.getRequestDispatcher("/views/admin/order/orderDetail.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI().toString();
		if (url.contains("adminFilterOrder")) {
			List<OrderModel> listOrder = orderService.findAllOrder();
			int forder = Integer.parseInt(req.getParameter("fOrderDate"));
			int fstatusOrder = Integer.parseInt(req.getParameter("fStatuOrder"));
			int fstatusPay = Integer.parseInt(req.getParameter("fStatuPayment"));
			if (forder != -1) {
				listOrder = filterByOrderDate(listOrder, fstatusPay);
			}
			if (fstatusOrder != -1) {
				listOrder = filterByOrderStatus(listOrder, fstatusOrder);
			}
			if (fstatusPay != -1) {
				listOrder = filterByPaymentStatus(listOrder, fstatusPay);
			}
			req.setAttribute("listOrder", listOrder);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/order/order.jsp");
			rd.forward(req, resp);
		}else if (url.contains("adminUpdateOrder"))
		{
			int orderID = Integer.parseInt(req.getParameter("orderID"));
			int ustatusOrder = Integer.parseInt(req.getParameter("uStatuOrder"));
			int ustatusPay = Integer.parseInt(req.getParameter("uStatuPayment"));
			OrderModel order = orderService.findByOrderID(orderID);
			order.setStatus(ustatusOrder);
			orderService.updateOrder(order);
			PaymentModel pay =paymentService.findPaymentByID(orderID);
			pay.setStatus(ustatusPay);
			paymentService.updatePayment(pay);
			resp.sendRedirect("adminOrder");
		}
	}

	private List<OrderModel> filterByOrderDate(List<OrderModel> list, int daysAgo) {
		long millisInDay = 24 * 60 * 60 * 1000; // Số mili giây trong một ngày
		long currentTimeInMillis = System.currentTimeMillis();
		long daysAgoInMillis = daysAgo * millisInDay;
		long thresholdTime = currentTimeInMillis - daysAgoInMillis;
		return list.stream().filter(order -> order.getOrderDate().getTime() >= thresholdTime)
				.collect(Collectors.toList());
	}

	private List<OrderModel> filterByOrderStatus(List<OrderModel> list, int orderSta) {
		return list.stream().filter(OrderModel -> OrderModel.getStatus() == orderSta).collect(Collectors.toList());
	}

	private List<OrderModel> filterByPaymentStatus(List<OrderModel> list, int paySta) {
		return list.stream().filter(OrderModel -> OrderModel.getPayment().getStatus() == paySta)
				.collect(Collectors.toList());
	}

	private void findAllOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<OrderModel> listOrder1 = orderService.findAllOrder();
		req.setAttribute("listOrder", listOrder1);
		List<List<Object>> listTotal = reportService.reportTotalMoneyInMonth();
		HttpSession session = req.getSession(true);
		session.setAttribute("listPayMentInMonth", listTotal);
		int chXN = listOrder1.stream().filter(OrderModel -> OrderModel.getStatus() == 0).collect(Collectors.toList())
				.size();
		int daXN = listOrder1.stream().filter(OrderModel -> OrderModel.getStatus() == 1).collect(Collectors.toList())
				.size();
		int chDG = listOrder1.stream().filter(OrderModel -> OrderModel.getStatus() == 2).collect(Collectors.toList())
				.size();
		int dVC = listOrder1.stream().filter(OrderModel -> OrderModel.getStatus() == 3).collect(Collectors.toList())
				.size();
		int thCong = listOrder1.stream().filter(OrderModel -> OrderModel.getStatus() == 4).collect(Collectors.toList())
				.size();
		int daHuy = listOrder1.stream().filter(OrderModel -> OrderModel.getStatus() == 5).collect(Collectors.toList())
				.size();
		session.setAttribute("chXN", chXN);
		session.setAttribute("daXN", daXN);
		session.setAttribute("chDG", chDG);
		session.setAttribute("dVC", dVC);
		session.setAttribute("thCong", thCong);
		session.setAttribute("daHuy", daHuy);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/order/order.jsp");
		rd.forward(req, resp);
	}

}
