package com.azshop.models;

public class CartModel {
	private int customerID;
	private int itemID;
	private int quantity;
	public CartModel() {
		super();
	}
	public CartModel(int customerID, int itemID, int quantity) {
		super();
		this.customerID = customerID;
		this.itemID = itemID;
		this.quantity = quantity;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
