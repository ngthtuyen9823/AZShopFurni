package com.azshop.utils;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
	public static void showMessage(HttpServletRequest request, String typeMessage) {
		String messageResponse = "";
		String alert = "";
		if (typeMessage.equals("delSuccess")) {
			messageResponse = "Delete success";
			alert = "success";
		} else if (typeMessage.equals("delFail")) {
			messageResponse = "Delete fail";
			alert = "danger";
		} else if (typeMessage.equals("addSuccess")) {
			messageResponse = "Inserted success";
			alert = "success";
		} else if (typeMessage.equals("addFail")) {
			messageResponse = "Inserted fail";
			alert = "danger";
		} else if (typeMessage.equals("updateSuccess")) {
			messageResponse = "Update success";
			alert = "success";
		} else if (typeMessage.equals("updateFail")) {
			messageResponse = "Update fail";
			alert = "danger";
		}
		request.setAttribute("message", messageResponse);
		request.setAttribute("alert", alert);
	}
}
