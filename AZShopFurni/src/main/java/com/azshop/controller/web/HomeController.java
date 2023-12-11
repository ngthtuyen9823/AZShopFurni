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
import com.azshop.service.ICartService;
import com.azshop.service.IDetailService;
import com.azshop.service.impl.CartServiceImpl;
import com.azshop.service.impl.DetailServiceImpl;

@WebServlet(urlPatterns = "/home")
public class HomeController extends HttpServlet {

	IDetailService detailService = new DetailServiceImpl();
	ICartService cartService = new CartServiceImpl();
	private static final long serialVersionUID = 4317368494648713183L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		if (session.getAttribute("user") != null) {
			UserModel user = (UserModel) session.getAttribute("user");
			List<CartModel> listCart = cartService.findByCustomerId(user.getUserID());

			int subTotal = 0;
			for (CartModel cart : listCart) {
				subTotal += cart.getTotalPrice();
			}

			req.setAttribute("carts", listCart);
			req.setAttribute("subTotal", subTotal);
		}
		List<List<Object>> listBestSeller = detailService.listBestSeller();
		req.setAttribute("list", listBestSeller);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, resp);
	}
}
