package com.azshop.controller.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.models.AccountModel;
import com.azshop.models.UserModel;
import com.azshop.service.IUserService;
import com.azshop.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/infoUser", "/updateUser", "/updateAccount" })
public class PersonalInformationController extends HttpServlet {
	IUserService userService = new UserServiceImpl();
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("infoUser")){
			getInfUser(req, resp);
		}
		else if(url.contains("updateUser")){
			updateInfUser(req, resp);
		} else if(url.contains("updateAccount")) {
			updateInfAccount(req,resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI().toString();
		if(url.contains("updateUser")) {
			createUserModel(req, resp);
		} else if(url.contains("updateAccount")) {
			createAccountModel(req,resp);
		}
		resp.sendRedirect("infoUser");
	}
	
	private void getInfUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserModel userMd = userService.getInfoUser(110001);
		
		req.setAttribute("userModel", userMd);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/infoUser.jsp");
		rd.forward(req, resp);
	}
	
	private void updateInfUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userID = Integer.parseInt(req.getParameter("userID"));
		UserModel userMd = userService.getInfoUser(userID);
		
		req.setAttribute("userModel", userMd);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/updateUser.jsp");
		rd.forward(req, resp);
	}
	
	private void updateInfAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userID = Integer.parseInt(req.getParameter("userID"));
		AccountModel accountMd = userService.getInfAccount(userID);
		
		req.setAttribute("accountModel", accountMd);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/updateAccount.jsp");
		rd.forward(req, resp);
	}
	
	private void createUserModel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

		int userID = Integer.parseInt(req.getParameter("UserID"));
		String firstName = req.getParameter("FirstName");
		String lastName = req.getParameter("LastName");
		String address = req.getParameter("Address");
		System.out.println(userID);
		int gender = Integer.parseInt(req.getParameter("Gender"));
		String phone = req.getParameter("Phone");
		Date dob = null;
		try {
			dob = formatter.parse( req.getParameter("Dob"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String cid = req.getParameter("Cid");
		int type = Integer.parseInt(req.getParameter("Type"));
		int kpi = Integer.parseInt(req.getParameter("KPI"));
		String area = req.getParameter("Area");
		String avatar = req.getParameter("Avatar");
		String email = req.getParameter("Email");
		
		UserModel userMd = new UserModel(userID, firstName, lastName, address, gender, 
										 phone, dob, cid, type, kpi, area, avatar, email);
		userService.updateUser(userMd);
	}
	
	private void createAccountModel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userID = Integer.parseInt(req.getParameter("UserID"));
		String userName = req.getParameter("UserName");
		String oldPassword = req.getParameter("OldPassWord");
		String password = req.getParameter("Password");
		AccountModel accountMd = userService.getInfAccount(userID);
		System.out.println(oldPassword);
		if(userService.checkPassword(oldPassword, accountMd.getPassword())) {
			AccountModel newAccountMd = new AccountModel(userID, userName, password);
			userService.updateAccount(newAccountMd);
		} else {
		}
	}
}
