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

@WebServlet(urlPatterns = { "/login", "/testcustomer", "/testseller", "/testshipper", "/testadmin", "/signup",
		"/verification", "/resend" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IAccountService accService = new AccountServiceImpl();
	ICustomerService cusService = new CustomerServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("login"))
			showPageLogin(req, resp);
		else if (url.contains("signup"))
			showPageSignup(req, resp);
		else if (url.contains("verification"))
			showVerificationPage(req, resp);
		else if (url.contains("resend")) {
			sendVerificationEmail(req);
			showVerificationPage(req, resp);
		}

		else
			Home(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("login"))
			checkLogin(req, resp);
		else if (url.contains("signup"))
			insertAcc(req, resp);
		else if (url.contains("verification"))
			verificationEmail(req, resp);
	}

	private void showPageLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/login.jsp");
		rd.forward(req, resp);
	}

	private void showPageSignup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> listcity = City.BAC_CAN.getListCity();
		req.setAttribute("listcity", listcity);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/signup.jsp");
		rd.forward(req, resp);
	}

	private void showVerificationPage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/verification.jsp");
		rd.forward(req, resp);
	}

	private void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		int type = accService.getTypeAccount(username, password);
		if (type == -1) {
			req.setAttribute("mess", "Tài khoản hoặc mật khẩu chưa đúng");
			req.setAttribute("username", username);
			showPageLogin(req, resp);
		} else {
			Cookie cookie = new Cookie("userID", String.valueOf(accService.getUserIDAccountByName(username)));
			cookie.setMaxAge(30);
			resp.addCookie(cookie);
			String url = null;
			if (type == 0)
				url = "testcustomer";
			else if (type == 1)
				url = "testseller";
			else if (type == 2)
				url = "testshipper";
			else if (type == 3)
				url = "testadmin";
			resp.sendRedirect(url);
		}
	}


	private void insertAcc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		try {
			cusService.checkValidInfoCustomer(req.getParameter("firstname"), req.getParameter("lastname"),
					req.getParameter("address"), req.getParameter("gender"), req.getParameter("phone"),
					req.getParameter("dob"), req.getParameter("area"), req.getParameter("email"),
					req.getParameter("usernamesignup"), req.getParameter("passsignup"), req.getParameter("passcheck"));
			req.removeAttribute("exception");

			UserModel user = new UserModel();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			user.setUserID(cusService.createCustomerID());
			user.setFirstName(req.getParameter("firstname"));
			user.setLastName(req.getParameter("lastname"));
			user.setEmail(req.getParameter("email"));
			user.setPhone(req.getParameter("phone"));
			user.setArea(req.getParameter("area"));
			user.setAddress(req.getParameter("address"));
			user.setGender(Integer.parseInt(req.getParameter("gender")));
			user.setDob(formatter.parse(req.getParameter("dob")));

			AccountModel acc = new AccountModel();
			acc.setUserID(user.getUserID());
			acc.setUserName(req.getParameter("usernamesignup"));
			acc.setPassword(req.getParameter("passsignup"));

			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			session.setAttribute("acc", acc);

			sendVerificationEmail(req);

			resp.sendRedirect("verification");

		} catch (IllegalArgumentException e) {
			req.setAttribute("exception", e.getMessage());
			req.setAttribute("usernamesignup", req.getParameter("usernamesignup"));
			req.setAttribute("firstname", req.getParameter("firstname"));
			req.setAttribute("lastname", req.getParameter("lastname"));
			req.setAttribute("email", req.getParameter("email"));
			req.setAttribute("phone", req.getParameter("phone"));
			req.setAttribute("area", req.getParameter("area"));
			req.setAttribute("address", req.getParameter("address"));
			req.setAttribute("gender", req.getParameter("gender"));
			req.setAttribute("dob", req.getParameter("dob"));

			showPageSignup(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void Home(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();

		String userID = "";
		Cookie[] cookie = req.getCookies();
		for (Cookie c : cookie) {
			if (c.getName().equals("userID")) {
				userID = c.getValue();
			}
		}
		if (userID.equals("")) {
			resp.sendRedirect("login");
		}
		printWriter.println("ID" + userID);
	}

	private void verificationEmail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String verification = (String) session.getAttribute("verification");
		String usercode = req.getParameter("usercode");
		if (verification.equals(usercode)) {
			UserModel user = (UserModel) session.getAttribute("user");
			AccountModel acc = (AccountModel) session.getAttribute("acc");
			System.out.println(user.getFirstName() + acc.getUserName());
			cusService.insertCustomer(user);
			accService.insertAccount(acc);
			session.invalidate();
			resp.sendRedirect("login");
		} else {
			req.setAttribute("mess", "Mã xác thực chưa đúng");
			showVerificationPage(req, resp);
		}
	}

	private void sendVerificationEmail(HttpServletRequest req) {
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		Random rnd = new Random();
		String verification = String.valueOf(rnd.nextInt(100000, 999999));
		SendMail.sendMail(user.getEmail(), verification);
		session.setAttribute("verification", verification);
	}

}
