package com.azshop.models;

public class ItemImageModel {
	private int itemID;
	private String image;
	public ItemImageModel() {
		super();
	}
	public ItemImageModel(int itemID, String image) {
		super();
		this.itemID = itemID;
		this.image = image;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
