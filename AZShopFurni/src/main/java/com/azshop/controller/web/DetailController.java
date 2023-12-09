package com.azshop.controller.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.models.DetailModel;
import com.azshop.service.IDetailService;

import com.azshop.service.impl.DetailServiceImpl;

@WebServlet("/submitReview")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDetailService detailService = new DetailServiceImpl();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int itemID = Integer.parseInt(req.getParameter("itemID"));
		int orderID = Integer.parseInt(req.getParameter("orderID"));
		int rating = Integer.parseInt(req.getParameter("rating"));
		String content = req.getParameter("content");

		DetailModel detail = new DetailModel();
		detail.setItemID(itemID);
		detail.setOrderID(orderID);
		detail.setRating(rating);
		detail.setContent(content);
		detail.setEvaluationDate(new Date());

		detailService.updateDetail(detail);

		resp.sendRedirect("products");
	}
}
