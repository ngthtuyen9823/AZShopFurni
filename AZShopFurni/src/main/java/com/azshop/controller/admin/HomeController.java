package com.azshop.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.checkerframework.checker.units.qual.m;

import com.azshop.bean.MyItem;
import com.azshop.models.OrderModel;
import com.azshop.service.IOrderService;
import com.azshop.service.IPaymentService;
import com.azshop.service.IReportService;
import com.azshop.service.IUserService;
import com.azshop.service.impl.OrderServiceImpl;
import com.azshop.service.impl.PaymentServiceImpl;
import com.azshop.service.impl.ReportServiceImpl;
import com.azshop.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/adminHome"})
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	IReportService reportService = new ReportServiceImpl();
	IOrderService orderService = new OrderServiceImpl();
	IUserService userService = new UserServiceImpl();
	IPaymentService paymentService = new PaymentServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		HttpSession session = req.getSession(true);
		List<OrderModel> listOrder = orderService.findAllOrder();
		List<OrderModel> listOrder1 = new ArrayList<>();
		Date currentDate = new Date();
		if (url.contains("adminHome")) {
			Date date = new Date();
	        List<MyItem> listItem = reportService.reportReceipt(date, 7);
	        req.setAttribute("listReceipt", listItem);
	        
	        int sumTotal = 0;
	        List<List<Object>> listTotal = reportService.reportTotalMoneyInMonth();
	        for (List<Object> list : listTotal) {
				sumTotal += (long) list.get(1);
			}
	        Calendar calendar = Calendar.getInstance();
			calendar.setTime(currentDate); // Đặt ngày trong tuần về ngày đầu tiên (Chủ Nhật) và trừ đi số ngày đã qua
											// trong tuần
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			calendar.add(Calendar.DATE, -calendar.get(Calendar.DAY_OF_WEEK)); // Lấy ngày đầu tiên của tuần
			Date firstDayOfWeek = calendar.getTime();
			for (OrderModel list : listOrder) {
				if (list.getOrderDate().compareTo(firstDayOfWeek) > 0)
					listOrder1.add(list);
			}
			int chDG = listOrder1.stream().filter(OrderModel -> OrderModel.getStatus() == 2).collect(Collectors.toList())
					.size();
			int dVC = listOrder1.stream().filter(OrderModel -> OrderModel.getStatus() == 3).collect(Collectors.toList())
					.size();
			int thCong = listOrder1.stream().filter(OrderModel -> OrderModel.getStatus() == 4).collect(Collectors.toList())
					.size();
			int daHuy = listOrder1.stream().filter(OrderModel -> OrderModel.getStatus() == 5).collect(Collectors.toList())
					.size();
			session.setAttribute("chDG", chDG);
			session.setAttribute("dVC", dVC);
			session.setAttribute("thCong", thCong);
			session.setAttribute("daHuy", daHuy);
			
	        req.setAttribute("sumTotal", sumTotal);
	        req.setAttribute("listPayMentInMonth", listTotal);
	        
	        
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/home.jsp");
			rd.forward(req, resp);
		}
	}
}
