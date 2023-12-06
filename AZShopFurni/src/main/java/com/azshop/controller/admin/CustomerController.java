package com.azshop.controller.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.models.AccountModel;
import com.azshop.models.UserModel;
import com.azshop.service.IAccountService;
import com.azshop.service.ICustomerService;
import com.azshop.service.impl.AccountServiceImpl;
import com.azshop.service.impl.CustomerServiceImpl;
import com.azshop.utils.MessageUtil;

@WebServlet(urlPatterns = { "/adminCustomer", "/adminInsertCustomer", "/adminUpdateCustomer", "/adminDeleteCustomer" })
public class CustomerController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ICustomerService customerService = new CustomerServiceImpl();
	IAccountService accountService = new AccountServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI().toString();
		if (url.contains("adminCustomer")) {
			getAllCustomer(req, resp);
		} else if (url.contains("adminInsertCustomer")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/customerInsert.jsp");
			rd.forward(req, resp);
		} else if (url.contains("adminUpdateCustomer")) {
			getCustomerUpdate(req, resp);
		} else if (url.contains("adminDeleteCustomer")) {
			deleteCustomer(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI().toString();
		if (url.contains("adminInsertCustomer")) {
			insertCustomer(req, resp);
		} else if (url.contains("adminUpdateCustomer")) {
			updateCustomer(req, resp);
		}
	}

	private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		try {
			int customerID = Integer.parseInt(req.getParameter("customerID"));
			UserModel customer = customerService.getOneCustomer(customerID);
			customerService.deleteCustomer(customer);
			MessageUtil.showMessage(req, "delSuccess");
		} catch (Exception ex) {
			MessageUtil.showMessage(req, "delFail");
		}
		RequestDispatcher rd = req.getRequestDispatcher("adminCustomer");
		rd.forward(req, resp);

	}

	private void getCustomerUpdate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int customerID = Integer.parseInt(req.getParameter("customerID"));
		UserModel customer = customerService.getOneCustomer(customerID);
		req.setAttribute("customer", customer);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/customerUpdate.jsp");
		rd.forward(req, resp);

	}

	private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int customerID = Integer.parseInt(req.getParameter("customerID"));
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String address = req.getParameter("address");
			int gender = Integer.parseInt(req.getParameter("gender"));
			String phone = req.getParameter("phone");
			String avatar = req.getParameter("avatar");
			String cid = req.getParameter("cid");
			String email = req.getParameter("email");
			String dobString = req.getParameter("dob");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng của ngày tháng
			Date dob = null;
			try {
				dob = sdf.parse(dobString); // Chuyển đổi kiểu chuỗi thành kiểu Date
			} catch (ParseException e) {
				e.printStackTrace();
			}

			UserModel newUser = new UserModel();
			newUser.setUserID(customerID);
			newUser.setFirstName(firstName);
			newUser.setLastName(lastName);
			newUser.setGender(gender);
			newUser.setAvatar(avatar);
			newUser.setAddress(address);
			newUser.setPhone(phone);
			newUser.setDob(dob);
			newUser.setCid(cid);
			newUser.setEmail(email);
			customerService.updateCustomer(newUser);
			MessageUtil.showMessage(req, "updateSuccess");
		} catch (Exception ex) {
			MessageUtil.showMessage(req, "updateFail");
		}
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/customerInsert.jsp");
		rd.forward(req, resp);
	}

	private void insertCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int customerID = customerService.createCustomerID();
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String address = req.getParameter("address");
			int gender = Integer.parseInt(req.getParameter("gender"));
			String phone = req.getParameter("phone");
			String avatar = req.getParameter("avatar");
			String cid = req.getParameter("cid");
			String email = req.getParameter("email");
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
			newUser.setUserID(customerID);
			newUser.setFirstName(firstName);
			newUser.setLastName(lastName);
			newUser.setGender(gender);
			newUser.setAvatar(avatar);
			newUser.setAddress(address);
			newUser.setPhone(phone);
			newUser.setDob(dob);
			newUser.setCid(cid);
			newUser.setEmail(email);

			boolean checkInsertCustomer = customerService.insertCustomer(newUser);
			if (checkInsertCustomer) {
				AccountModel accountMd = new AccountModel(customerID, "User" + customerID, "12345");
				accountService.insertAccount(accountMd);
			}
			MessageUtil.showMessage(req, "addSuccess");
		} catch (Exception ex) {
			MessageUtil.showMessage(req, "addFail");
		}
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/customerInsert.jsp");
		rd.forward(req, resp);

	}

	private void getAllCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserModel> listCustomer = customerService.getAllCustomer();
		req.setAttribute("listCustomer", listCustomer);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/customer.jsp");
		rd.forward(req, resp);

	}
}
