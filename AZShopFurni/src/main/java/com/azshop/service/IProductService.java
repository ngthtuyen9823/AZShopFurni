package com.azshop.service;

import java.util.List;

import com.azshop.models.ProductModel;

public interface IProductService {
	List<ProductModel> findAll();
	int CreateProductID (int Id);
	List<ProductModel> findByCategoryID(int cateId);
	List<ProductModel> findWithCount(int count);
	ProductModel findOne(int id);
	void insertProduct (ProductModel model);
	void deleteProduct (int ProId);
	void updateProduct (ProductModel model);
	List<ProductModel> searchProductByName(String key);
	List<ProductModel> filterByPrice(int minPrice, int maxPrice);
	List<ProductModel> filterByRating(int rate);
	List<ProductModel> sortByPrice();
}