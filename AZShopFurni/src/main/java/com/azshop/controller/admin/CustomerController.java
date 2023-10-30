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
		resp.sendRedirect("adminCustomer");
	}

	private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int customerID = Integer.parseInt(req.getParameter("customerID"));
		UserModel customer = customerService.getOneCustomer(customerID);
		customerService.deleteCustomer(customer);
		resp.sendRedirect("adminCustomer");

	}

	private void getCustomerUpdate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int customerID = Integer.parseInt(req.getParameter("customerID"));
		UserModel customer = customerService.getOneCustomer(customerID);
		req.setAttribute("customer", customer);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/customerUpdate.jsp");
		rd.forward(req, resp);

	}

	private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String address = req.getParameter("address");
		int gender = Integer.parseInt(req.getParameter("gender"));
		String phone = req.getParameter("phone");
		Date dob = null;
		try {
			dob = formatter.parse(req.getParameter("dob"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String cid = req.getParameter("cid");
		int type = 0;
		Integer kpi = 0;
		String area = null;
		String avatar = req.getParameter("avatar");
		String email = req.getParameter("email");
		int customerID = Integer.parseInt(req.getParameter("customerID"));
		UserModel customerMd = new UserModel(customerID, firstName, lastName, address, gender, phone, dob, cid, type,
				kpi, area, avatar, email);
		customerService.updateCustomer(customerMd);

	}

	private void insertCustomer(HttpServletRequest req, HttpServletResponse resp) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String address = req.getParameter("address");
		int gender = Integer.parseInt(req.getParameter("gender"));
		String phone = req.getParameter("phone");
		Date dob = null;
		try {
			dob = formatter.parse(req.getParameter("dob"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(dob);
		String cid = req.getParameter("cid");
		int type = 0;
		Integer kpi = 0;
		String area = null;
		String avatar = req.getParameter("avatar");
		String email = req.getParameter("email");
		int customerID = customerService.createCustomerID();
		UserModel customerMd = new UserModel(customerID, firstName, lastName, address, gender, phone, dob, cid, type,
				kpi, area, avatar, email);
		boolean checkInsertCustomer = customerService.insertCustomer(customerMd);
		if (checkInsertCustomer) {
			AccountModel accountMd = new AccountModel(customerID, email, "12345");
			accountService.insertAccount(accountMd);
		}

	}

	private void getAllCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserModel> listCustomer = customerService.getAllCustomer();
		req.setAttribute("listCustomer", listCustomer);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/customer/customer.jsp");
		rd.forward(req, resp);

	}
}
