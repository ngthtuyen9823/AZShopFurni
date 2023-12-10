package com.azshop.utils;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
	public static void showMessage(HttpServletRequest request, String typeMessage) {
		String messageResponse = "";
		String alert = "";
		if (typeMessage.equals("delSuccess")) {
			messageResponse = "Xóa thành công";
			alert = "success";
		} else if (typeMessage.equals("delFail")) {
			messageResponse = "Xóa thất bại";
			alert = "danger";
		} else if (typeMessage.equals("addSuccess")) {
			messageResponse = "Thêm thành công";
			alert = "success";
		} else if (typeMessage.equals("addFail")) {
			messageResponse = "Thêm thất bại";
			alert = "danger";
		} else if (typeMessage.equals("updateSuccess")) {
			messageResponse = "Cập nhật thành công";
			alert = "success";
		} else if (typeMessage.equals("updateFail")) {
			messageResponse = "Cập nhật thất bại";
			alert = "danger";
		} else if(typeMessage.equals("updateAccountTrue")) {
			messageResponse = "Thay đổi mật khẩu thành công";
			alert = "success";
		}
		else if (typeMessage.equals("updateAccountFail")) {
			messageResponse = "Mật khẩu cũ không đúng. Vui lòng nhập lại";
			alert = "danger";
		}
		request.setAttribute("message", messageResponse);
		request.setAttribute("alert", alert);
	}
}
