package com.azshop.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.models.CartModel;

import com.azshop.service.ICartService;
import com.azshop.service.impl.CartServiceImpl;

@WebServlet({ "/carts", "/addToCart", "/buyNow", "/deleteCart", "/deleteCarts" })
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICartService cartService = new CartServiceImpl();
	RequestDispatcher rd = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI().toString();

		if (url.contains("carts")) {
			getAllCart(req, resp);
		} else if (url.contains("deleteCarts")) {
			deleteCarts(req, resp);
		} else if (url.contains("deleteCart")) {
			deleteCart(req, resp);
		}
	}

	private void deleteCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int customerID = Integer.parseInt(req.getParameter("customerID"));
		int itemID = Integer.parseInt(req.getParameter("itemID"));

		cartService.delete(customerID, itemID);
		resp.sendRedirect("carts");
	}

	private void deleteCarts(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		cartService.deleteAll();
		resp.sendRedirect("carts");
	}

	private void getAllCart(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<CartModel> listCart = cartService.findAll();
		int subTotal = 0;

		for (CartModel cart : listCart) {
			subTotal += cart.getTotalPrice();
		}

		req.setAttribute("carts", listCart);
		req.setAttribute("subTotal", subTotal);

		rd = req.getRequestDispatcher("/views/web/carts/carts.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CartModel cart = new CartModel();
		CartModel oldCart = new CartModel();

		int customerID = 100001; // note
		int itemID = Integer.parseInt(req.getParameter("selectedItemID"));
		int quantity = Integer.parseInt(req.getParameter("selectedQuantity"));

		cart.setCustomerID(customerID);
		cart.setItemID(itemID);

		oldCart = cartService.findOne(customerID, itemID);

		if (oldCart.getQuantity() != 0) {
			cart.setQuantity(quantity + oldCart.getQuantity());
			System.out.println("oldcart" + oldCart);
			cartService.update(cart);
		} else {
			cart.setQuantity(quantity);
			System.out.println(cart);
			cartService.insert(cart);
		}
		resp.getWriter().write("Item added to cart successfully");
		resp.sendRedirect("carts");
	}
}
