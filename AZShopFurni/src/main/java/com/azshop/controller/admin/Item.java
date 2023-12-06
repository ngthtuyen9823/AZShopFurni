package com.azshop.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.models.ItemModel;
import com.azshop.service.IItemService;
import com.azshop.service.impl.ItemServiceImpl;

@WebServlet(urlPatterns = { "/adminItem", "/insertItem", "/deleteItem", "/updateItem", "/viewItem" })
public class Item extends HttpServlet {

	IItemService item = new ItemServiceImpl();
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("adminItem")) {
			List(req, resp);
		} else if (url.contains("insertItem")) {
			insert(req, resp);
		} else if (url.contains("deleteItem")) {
			delete(req, resp);
		} else if (url.contains("updateItem")) {
			update(req,resp);
		} else if(url.contains("viewItem"))
		{
			view(req,resp);
		}
	}

	private void view(HttpServletRequest req, HttpServletResponse resp) {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("insertItem")) {
			insert(req, resp);
		} else if (url.contains("updateItem")) {
			update(req, resp);
		}
	}

	private void List(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ItemModel> listItem = item.findAll();
		req.setAttribute("listItem", listItem);
		req.getRequestDispatcher("/views/admin/item/ListItem.jsp").forward(req, resp);
	}

	private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int itemID = Integer.parseInt(req.getParameter("ItemID"));
		item.deleteItem(itemID);
		resp.sendRedirect("adminItem");
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int itemID = Integer.parseInt(req.getParameter("ItemID"));
		ItemModel model = item.findOne(itemID);
		req.setAttribute("item", model);
		req.getRequestDispatcher("/views/admin/item/insertItem.jsp");
	}
}
