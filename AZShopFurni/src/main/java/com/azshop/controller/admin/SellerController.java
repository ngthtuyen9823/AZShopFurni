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
import com.azshop.service.ISellerService;
import com.azshop.service.impl.SellerServiceImpl;

@WebServlet(urlPatterns = { "/adminHome", "/adminSeller", "/adminUpdateSeller", "/adminDeleteSeller",
		"/adminInsertSeller" })
public class SellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ISellerService sellerService = new SellerServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("adminHome")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/home.jsp");
			rd.forward(req, resp);
		} else if (url.contains("adminSeller")) {
			findAllSeller(req, resp);
		} else if (url.contains("adminUpdateSeller")) {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");

			int id = Integer.parseInt(req.getParameter("userID"));

			UserModel model = sellerService.findOne(id);

			req.setAttribute("seller", model);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/seller/updateSeller.jsp");
			rd.forward(req, resp);
		} else if (url.contains("adminDeleteSeller")) {
			int id = Integer.parseInt(req.getParameter("userID"));
			
			sellerService.deleteSeller(id);
			req.setAttribute("message", "Da xoa thanh cong");

			RequestDispatcher rd = req.getRequestDispatcher("adminSeller");
			rd.forward(req, resp);

		} else if (url.contains("adminInsertSeller")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/seller/addSeller.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();

		if (url.contains("adminUpdateSeller")) {
			updateSeller(req, resp);
		} else if (url.contains("adminInsertSeller")) {
			insertSeller(req, resp);
		}
	}

	private void insertSeller(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// thiet lap ngon ngu
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		// nhan du lieu tu form
		int id = sellerService.createSellerID();
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String address = req.getParameter("address");
		int gender = Integer.parseInt(req.getParameter("gender"));
		String phone = req.getParameter("phone");
		String avatar = req.getParameter("avatar");
		String cid = req.getParameter("cid");
		int kpi = Integer.parseInt(req.getParameter("kpi"));
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
		newUser.setKpi(kpi);
		// goi pt insert trong service
		sellerService.insertSeller(newUser);
		// tra ve view
		resp.sendRedirect(req.getContextPath() + "/adminSeller");

	}

	private void updateSeller(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
		int kpi = Integer.parseInt(req.getParameter("kpi"));
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
		newUser.setKpi(kpi);

		sellerService.updateSeller(newUser);

		resp.sendRedirect(req.getContextPath() + "/adminSeller");
	}

	private void findAllSeller(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserModel> listseller = sellerService.findAllSeller();
		req.setAttribute("listseller", listseller);

		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/seller/listSeller.jsp");
		rd.forward(req, resp);
	}
}