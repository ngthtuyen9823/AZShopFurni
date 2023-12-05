package com.azshop.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.models.CartModel;
import com.azshop.service.ICartService;
import com.azshop.service.impl.CartServiceImpl;

@WebServlet("/addToCart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int itemID = Integer.parseInt(request.getParameter("itemID"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		ICartService cartService = new CartServiceImpl();
		CartModel cart = new CartModel();

		cart.setCustomerID(100001);
		cart.setItemID(itemID);
		cart.setQuantity(quantity);

		cartService.insert(cart);

		response.getWriter().write("Item added to cart successfully");
	}
}
