package com.azshop.models;

import com.google.api.client.util.DateTime;

public class PaymentModel {
	private int orderID;
	private int method;
	private DateTime time;
	private String bank;
	private String cardOwner;
	private String accountNumber;
	private int status;
	public PaymentModel() {
		super();
	}
	public PaymentModel(int orderID, int method, DateTime time, String bank, String cardOwner, String accountNumber,
			int status) {
		super();
		this.orderID = orderID;
		this.method = method;
		this.time = time;
		this.bank = bank;
		this.cardOwner = cardOwner;
		this.accountNumber = accountNumber;
		this.status = status;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getMethod() {
		return method;
	}
	public void setMethod(int method) {
		this.method = method;
	}
	public DateTime getTime() {
		return time;
	}
	public void setTime(DateTime time) {
		this.time = time;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getCardOwner() {
		return cardOwner;
	}
	public void setCardOwner(String cardOwner) {
		this.cardOwner = cardOwner;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
