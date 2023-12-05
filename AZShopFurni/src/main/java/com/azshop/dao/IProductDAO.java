package com.azshop.dao;

import java.util.List;

import com.azshop.models.ProductModel;


public interface IProductDAO {
	List<ProductModel> findAll();
	List<ProductModel> findAllOfCategory(int Id);
	List<ProductModel> findByCategoryID(int cateId);
	List<ProductModel> findWithCount(int count);
	ProductModel findOne(int id);
	void insertProduct (ProductModel model);
	void deleteProduct (int ProId);
	void updateProduct (ProductModel model);
}