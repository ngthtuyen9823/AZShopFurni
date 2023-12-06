package com.azshop.models;

import java.util.Date;

public class OrderModel {
	private int orderID;
	private Date orderDate;
	private String address;
	private int status;
	private int transportFee;
	private int discount;
	private int totalMoney;
	private String note;
	private int deliveryTime;
	private int customerConfirmation;
	private int customerID;
	private int sellerID;
	private int shipperID;
	
	private int productID;
	private int itemID;
	private String productName;
	private String color;
	private String size;
	private int quantity;
	private int originalPrice;
	private int promotionPrice;
	private String image;
	
	
	public OrderModel(int orderID, Date orderDate, String address, int status, int transportFee, int discount,
			int totalMoney, String note, int deliveryTime, int customerConfirmation, int customerID, int sellerID,
			int shipperID, int productID, int itemID, String productName, String color, String size, int quantity,
			int originalPrice, int promotionPrice, String image) {
		super();
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.address = address;
		this.status = status;
		this.transportFee = transportFee;
		this.discount = discount;
		this.totalMoney = totalMoney;
		this.note = note;
		this.deliveryTime = deliveryTime;
		this.customerConfirmation = customerConfirmation;
		this.customerID = customerID;
		this.sellerID = sellerID;
		this.shipperID = shipperID;
		this.productID = productID;
		this.itemID = itemID;
		this.productName = productName;
		this.color = color;
		this.size = size;
		this.quantity = quantity;
		this.originalPrice = originalPrice;
		this.promotionPrice = promotionPrice;
		this.image = image;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OrderModel() {
		super();
	}
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(int originalPrice) {
		this.originalPrice = originalPrice;
	}
	public int getPromotionPrice() {
		return promotionPrice;
	}
	public void setPromotionPrice(int promotionPrice) {
		this.promotionPrice = promotionPrice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTransportFee() {
		return transportFee;
	}
	public void setTransportFee(int transportFee) {
		this.transportFee = transportFee;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public int getCustomerConfirmation() {
		return customerConfirmation;
	}
	public void setCustomerConfirmation(int customerConfirmation) {
		this.customerConfirmation = customerConfirmation;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getSellerID() {
		return sellerID;
	}
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	public int getShipperID() {
		return shipperID;
	}
	public void setShipperID(int shipperID) {
		this.shipperID = shipperID;
	}
	@Override
	public String toString() {
		return "OrderModel [orderID=" + orderID + ", orderDate=" + orderDate + ", address=" + address + ", status="
				+ status + ", transportFee=" + transportFee + ", discount=" + discount + ", totalMoney=" + totalMoney
				+ ", note=" + note + ", deliveryTime=" + deliveryTime + ", customerConfirmation=" + customerConfirmation
				+ ", customerID=" + customerID + ", sellerID=" + sellerID + ", shipperID=" + shipperID + "]";
	}
	
}
