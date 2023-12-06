package com.azshop.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azshop.models.AccountModel;
import com.azshop.models.UserModel;
import com.azshop.service.IAccountService;
import com.azshop.service.ICustomerService;
import com.azshop.service.impl.AccountServiceImpl;
import com.azshop.service.impl.CustomerServiceImpl;

import other.City;
import other.SendMail;

@WebServlet(urlPatterns = { "/testcustomer", "/testseller", "/testshipper", "/testadmin" })
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IAccountService accService = new AccountServiceImpl();
	ICustomerService cusService = new CustomerServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		printWriter.println("ID" + user.getUserID());
	}
	
}

