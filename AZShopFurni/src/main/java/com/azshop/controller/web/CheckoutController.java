package com.azshop.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azshop.models.CartModel;
import com.azshop.models.UserModel;
import com.azshop.models.VoucherModel;
import com.azshop.service.ICartService;
import com.azshop.service.IVoucherService;
import com.azshop.service.impl.CartServiceImpl;
import com.azshop.service.impl.VoucherServiceImpl;

@WebServlet({ "/checkout" })
public class CheckoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;
	ICartService cartService = new CartServiceImpl();
	IVoucherService voucherService = new VoucherServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);

		if (session == null || session.getAttribute("user") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		String voucherIdString = req.getParameter("voucherId");
		UserModel user = (UserModel) session.getAttribute("user");
		List<CartModel> listCart = cartService.findByCustomerId(user.getUserID());
		List<VoucherModel> listVoucher = voucherService.findAllVoucherOfCustomer(user.getUserID());

		double totalCost = 0.0;
		for (CartModel cart : listCart) {
			totalCost += cart.getTotalPrice() * cart.getQuantity();
		}
		req.setAttribute("rawPrice", totalCost);
		req.setAttribute("totalCost", totalCost);

		if (voucherIdString != null) {
			int voucherId = Integer.parseInt(voucherIdString);
			VoucherModel voucher = voucherService.findOne(voucherId);

			if (totalCost < voucher.getMinimumPrice()) {
				req.setAttribute("voucherErrorMessage",
						"Giá trị tối thiểu đơn hàng phải đạt " + voucher.getMinimumPrice());
			}
			else {
				double discount = totalCost * voucher.getDiscount() / 100;
				totalCost -= discount;
				req.setAttribute("discount", discount);
				req.setAttribute("totalCost", totalCost);
			}
		}

		req.setAttribute("listVoucher", listVoucher);
		req.setAttribute("user", user);
		req.setAttribute("listCart", listCart);

		rd = req.getRequestDispatcher("/views/web/checkout.jsp");
		rd.forward(req, resp);
	}
}
