package com.azshop.dao;

import java.util.List;

import com.azshop.models.CategoryModel;



public interface ICategoryDAO {
	List<CategoryModel> findAll();
	CategoryModel findOne(int id);
	void insert(CategoryModel model);
	void update(CategoryModel model);
	void delete(int id);
}