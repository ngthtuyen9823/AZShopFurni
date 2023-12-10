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
		}
		request.setAttribute("message", messageResponse);
		request.setAttribute("alert", alert);
	}
}
