package com.azshop.models;

import com.google.api.client.util.DateTime;

public class SearchHistoryModel {
	private int customerID;
	private DateTime createdAt;
	private String history;
	public SearchHistoryModel() {
		super();
	}
	public SearchHistoryModel(int customerID, DateTime createdAt, String history) {
		super();
		this.customerID = customerID;
		this.createdAt = createdAt;
		this.history = history;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public DateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
}
