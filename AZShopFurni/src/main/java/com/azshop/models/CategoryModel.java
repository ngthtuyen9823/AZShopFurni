package com.azshop.models;

public class CategoryModel {
	private int categoryID;
	private String categoryName;
	private int parentCategoryID;
	public CategoryModel() {
		super();
	}
	public CategoryModel(int categoryID, String categoryName, int parentCategoryID) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.parentCategoryID = parentCategoryID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getParentCategoryID() {
		return parentCategoryID;
	}
	public void setParentCategoryID(int parentCategoryID) {
		this.parentCategoryID = parentCategoryID;
	}
	
}
