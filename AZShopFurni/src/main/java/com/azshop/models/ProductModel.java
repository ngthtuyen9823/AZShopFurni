package com.azshop.models;

public class ProductModel {
	private int productID;
	private int productName;
	private String description;
	private String origin;
	private int supplierID;
	private int categoryID;
	private String material;
	public ProductModel(int productID, int productName, String description, String origin, int supplierID,
			int categoryID, String material) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.description = description;
		this.origin = origin;
		this.supplierID = supplierID;
		this.categoryID = categoryID;
		this.material = material;
	}
	public ProductModel() {
		super();
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getProductName() {
		return productName;
	}
	public void setProductName(int productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
}
