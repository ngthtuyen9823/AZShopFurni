package com.azshop.models;

import java.util.Date;

public class DetailModel {
	private int itemID;
	private int orderID;
	private int quantity;
	private String link;
	private String content;
	private Date evaluationDate;
	private int rating;
	private String avatar;
	private String name;

	
	private ItemModel item = new ItemModel();
	private ProductModel product = new ProductModel();
	private OrderModel order = new OrderModel();
	
	public DetailModel() {
		super();
	}

	public DetailModel(int itemID, int orderID, int quantity, String link, String content, Date evaluationDate,
			int rating, String avatar, String name) {
		super();
		this.itemID = itemID;
		this.orderID = orderID;
		this.quantity = quantity;
		this.link = link;
		this.content = content;
		this.evaluationDate = evaluationDate;
		this.rating = rating;
		this.avatar = avatar;
		this.name = name;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public DateTime getEvaluationDate() {
		return evaluationDate;
	}
	public void setEvaluationDate(DateTime evaluationDate) {
		this.evaluationDate = evaluationDate;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "DetailModel [itemID=" + itemID + ", orderID=" + orderID + ", quantity=" + quantity + ", link=" + link
				+ ", content=" + content + ", evaluationDate=" + evaluationDate + ", rating=" + rating + ",avatar="
				+ avatar + " name, " + name + "]";
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
