package com.azshop.controller.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.models.UserModel;
import com.azshop.service.IShipperService;
import com.azshop.service.impl.ShipperServiceImpl;

@WebServlet(urlPatterns = { "/adminShipper", "/adminUpdateShipper", "/adminDeleteShipper", "/adminInsertShipper" })
public class ShipperController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IShipperService shipperService = new ShipperServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("adminShipper")) {
			findAllShipper(req, resp);
		} else if (url.contains("adminUpdateShipper")) {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");

			int id = Integer.parseInt(req.getParameter("userID"));

			UserModel model = shipperService.findOne(id);

			req.setAttribute("shipper", model);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/shipper/updateShipper.jsp");
			rd.forward(req, resp);
		} else if (url.contains("adminDeleteShipper")) {
			int id = Integer.parseInt(req.getParameter("userID"));

			shipperService.deleteShipper(id);
			req.setAttribute("message", "Da xoa thanh cong");

			RequestDispatcher rd = req.getRequestDispatcher("adminShipper");
			rd.forward(req, resp);

		} else if (url.contains("adminInsertShipper")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/shipper/addShipper.jsp");
			rd.forward(req, resp);
		}
	}

	private void findAllShipper(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserModel> listShipper = shipperService.findAllShipper();
		req.setAttribute("listshipper", listShipper);

		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/shipper/listShipper.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();

		if (url.contains("adminUpdateShipper")) {
			updateShipper(req, resp);
		} else if (url.contains("adminInsertShipper")) {
			insertShipper(req, resp);
		}
	}

	private void insertShipper(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// thiet lap ngon ngu
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		// nhan du lieu tu form
		int id = shipperService.createShipperID();
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String address = req.getParameter("address");
		int gender = Integer.parseInt(req.getParameter("gender"));
		String phone = req.getParameter("phone");
		String avatar = req.getParameter("avatar");
		String cid = req.getParameter("cid");
		String area = req.getParameter("area");
		String dobString = req.getParameter("dob");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng của ngày tháng
		Date dob = null;
		try {
			dob = sdf.parse(dobString); // Chuyển đổi kiểu chuỗi thành kiểu Date
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// dua du lieu vao model
		UserModel newUser = new UserModel();
		newUser.setUserID(id);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setGender(gender);
		newUser.setAvatar(avatar);
		newUser.setAddress(address);
		newUser.setPhone(phone);
		newUser.setDob(dob);
		newUser.setCid(cid);
		newUser.setArea(area);
		// goi pt insert trong service
		shipperService.insertShipper(newUser);
		// tra ve view
		resp.sendRedirect(req.getContextPath() + "/adminShipper");
	}

	private void updateShipper(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// thiet lap ngon ngu
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		// nhan du lieu tu form
		int id = Integer.parseInt(req.getParameter("userID"));
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String address = req.getParameter("address");
		int gender = Integer.parseInt(req.getParameter("gender"));
		String phone = req.getParameter("phone");
		String avatar = req.getParameter("avatar");
		String cid = req.getParameter("cid");
		String area = req.getParameter("area");
		String dobString = req.getParameter("dob");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng của ngày tháng
		Date dob = null;
		try {
			dob = sdf.parse(dobString); // Chuyển đổi kiểu chuỗi thành kiểu Date
		} catch (ParseException e) {
			e.printStackTrace();
		}

		UserModel newUser = new UserModel();
		newUser.setUserID(id);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setGender(gender);
		newUser.setAvatar(avatar);
		newUser.setAddress(address);
		newUser.setPhone(phone);
		newUser.setDob(dob);
		newUser.setCid(cid);
		newUser.setArea(area);

		shipperService.updateShipper(newUser);

		resp.sendRedirect(req.getContextPath() + "/adminShipper");

	}
}
