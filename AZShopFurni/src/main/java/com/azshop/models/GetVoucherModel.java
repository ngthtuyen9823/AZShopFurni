package com.azshop.models;

public class GetVoucherModel {
	private int voucherID;
	private int customerID;
	public GetVoucherModel() {
		super();
	}
	public GetVoucherModel(int voucherID, int customerID) {
		super();
		this.voucherID = voucherID;
		this.customerID = customerID;
	}
	public int getVoucherID() {
		return voucherID;
	}
	public void setVoucherID(int voucherID) {
		this.voucherID = voucherID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
}
