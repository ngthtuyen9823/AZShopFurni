package com.azshop.controller.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.azshop.models.AccountModel;
import com.azshop.models.UserModel;
import com.azshop.service.IUserService;
import com.azshop.service.impl.UserServiceImpl;

import Orther.UploadImage;

@WebServlet(urlPatterns = { "/infoUser", "/updateUser", "/updateAccount" })
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
//			int userID = Integer.parseInt(req.getParameter("UserID"));
//			Part filepart = req.getPart("image");
//			UploadImage.uploadImage("mysql-web", "web-budget","Image/Avatar/"+ userID + ".jpg",filepart.getInputStream());

//			if (ServletFileUpload.isMultipartContent(req)) {
//				FileItemFactory factory = new DiskFileItemFactory();
//				ServletFileUpload upload = new ServletFileUpload(factory);
//				try {
//					List<FileItem> items = upload.parseRequest(req);
//					for (FileItem item : items) {
//						if (!item.isFormField()) {
//							String fileName = item.getName();
//							String uploadDir = "D:/image/"; // Thay đổi đường dẫn tới thư mục tải lên của bạn
//							fullFilePath = uploadDir + fileName;
//							System.out.println("duong dan:  " + fullFilePath);
//							// Lưu tệp tải lên vào thư mục tải lên
//							File uploadedFile = new File(fullFilePath);
//							item.write(uploadedFile);
//						}
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}

			// UploadImage.uploadImage("mysql-web", "web-budget", userID+ ".jpg",
			// fullFilePath);
			createUserModel(req, resp);

		} else if (url.contains("updateAccount")) {
			createAccountModel(req, resp);
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
		System.out.println("ID:   " + userID);
		String firstName = req.getParameter("FirstName");
		String lastName = req.getParameter("LastName");
		String address = req.getParameter("Address");
		int gender = Integer.parseInt(req.getParameter("Gender"));
		String phone = req.getParameter("Phone");
		String dobString = req.getParameter("Dob");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng của ngày tháng
		Date dob = null;
		try {
			dob = sdf.parse(dobString); // Chuyển đổi kiểu chuỗi thành kiểu Date
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String cid = req.getParameter("Cid");
		int type = Integer.parseInt(req.getParameter("Type"));
		String email = req.getParameter("Email");
		int kpi = Integer.parseInt(req.getParameter("KPI"));
		String area = req.getParameter("Area");
		
		Part filepart = req.getPart("image");
		Random rnd = new Random();
		String rdCode = String.valueOf(rnd.nextInt(100, 999));
		UploadImage.uploadImage("mysql-web", "web-budget","Image/Avatar/"+ userID +rdCode+ ".jpg",filepart.getInputStream());
		
		String avatar = "https://storage.googleapis.com/web-budget/Image/Avatar/" + userID + rdCode + ".jpg";

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
}
