package com.azshop.models;

public class AccountModel {
	private int userID;
	private String accountName;
	private String password;
	public AccountModel() {
		super();
	}
	public AccountModel(int userID, String accountName, String password) {
		super();
		this.userID = userID;
		this.accountName = accountName;
		this.password = password;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
