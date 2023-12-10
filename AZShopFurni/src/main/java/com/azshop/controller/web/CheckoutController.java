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
import com.azshop.service.impl.CartServiceImpl;

@WebServlet({ "/checkout" })
public class CheckoutController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;
	ICartService cartService = new CartServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		
		if (session == null || session.getAttribute("user") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		} 
		UserModel user = (UserModel) session.getAttribute("user");
		List<CartModel> listCart = cartService.findByCustomerId(user.getUserID());
		
		for (CartModel a: listCart) {
			System.out.println(a.toString());
		}
		
		req.setAttribute("user", user);
		req.setAttribute("listCart", listCart);
		rd = req.getRequestDispatcher("/views/web/checkout.jsp");
		rd.forward(req, resp);
	}
}
