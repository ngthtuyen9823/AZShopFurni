package com.azshop.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.azshop.models.AccountModel;
import com.azshop.models.UserModel;
import com.azshop.service.IUserService;
import com.azshop.service.impl.UserServiceImpl;

import Orther.UploadImage;

@WebServlet(urlPatterns = { "/infoUser", "/updateUser", "/updateAccount", "/updateAvatar" })
@MultipartConfig
public class PersonalInformationController extends HttpServlet {
	IUserService userService = new UserServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("infoUser")) {
			getInfUser(req, resp);
		} else if (url.contains("updateUser")) {
			updateInfUser(req, resp);
		} else if (url.contains("updateAccount")) {
			updateInfAccount(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI().toString();
		if (url.contains("updateUser")) {
			createUserModel(req, resp);
		} else if (url.contains("updateAccount")) {
			createAccountModel(req, resp);
		} else if(url.contains("updateAvatar")) {
			updateAvatar(req, resp);
		}
		resp.sendRedirect("infoUser");
	}

	private void getInfUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserModel user = userService.getInfoUser(110001);

		req.setAttribute("userModel", user);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/infoUser.jsp");
		rd.forward(req, resp);
	}

	private void updateInfUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userID = Integer.parseInt(req.getParameter("userID"));
		UserModel user = userService.getInfoUser(userID);

		req.setAttribute("userModel", user);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/updateUser.jsp");
		rd.forward(req, resp);
	}

	private void updateInfAccount(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int userID = Integer.parseInt(req.getParameter("userID"));
		AccountModel account = userService.getInfAccount(userID);

		req.setAttribute("accountModel", account);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/updateAccount.jsp");
		rd.forward(req, resp);
	}

	private void createUserModel(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int userID = Integer.parseInt(req.getParameter("UserID"));
		String firstName = req.getParameter("FirstName");
		String lastName = req.getParameter("LastName");
		String address = req.getParameter("Address");
		int gender = Integer.parseInt(req.getParameter("Gender"));
		String phone = req.getParameter("Phone");
		String dobString = req.getParameter("Dob");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dob = null;
		try {
			dob = sdf.parse(dobString); 
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String cid = req.getParameter("Cid");
		int type = Integer.parseInt(req.getParameter("Type"));
		String email = req.getParameter("Email");
		int kpi = Integer.parseInt(req.getParameter("KPI"));
		String area = req.getParameter("Area");
		String avatar = req.getParameter("image");

		UserModel user = new UserModel();
		user.setUserID(userID);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAddress(address);
		user.setGender(gender);
		user.setPhone(phone);
		user.setDob(dob);
		user.setCid(cid);
		user.setType(type);
		user.setAvatar(avatar);
		user.setKpi(kpi);
		user.setArea(area);
		user.setEmail(email);

		userService.updateUser(user);
	}

	private void createAccountModel(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int userID = Integer.parseInt(req.getParameter("UserID"));
		String userName = req.getParameter("UserName");
		String oldPassword = req.getParameter("OldPassWord");
		String password = req.getParameter("Password");
		AccountModel account = userService.getInfAccount(userID);

		if (userService.checkPassword(oldPassword, account.getPassword())) {
			AccountModel newaccount = new AccountModel(userID, userName, password);
			userService.updateAccount(newaccount);
		} else {
			PrintWriter out = resp.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			req.getRequestDispatcher("/views/web/updateAccount.jsp").include(req, resp);
		}
	}
	
	private void updateAvatar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userID = Integer.parseInt(req.getParameter("UserID"));
		System.out.println(userID);
		Part filepart = req.getPart("image");
		Random rnd = new Random();
		String rdCode = String.valueOf(rnd.nextInt(100, 999));
		UploadImage.uploadImage("mysql-web", "web-budget","Image/Avatar/"+ userID +rdCode+ ".jpg",filepart.getInputStream());
		String avatar = "https://storage.googleapis.com/web-budget/Image/Avatar/" + userID + rdCode + ".jpg";
		
		userService.updateAvatar(userID, avatar);
		getInfUser(req, resp);
	}
}
