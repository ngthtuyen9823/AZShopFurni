package com.azshop.service;

import java.util.List;

import com.azshop.models.ProductModel;

public interface IProductService {
	List<ProductModel> findAll();
	List<ProductModel> findByCategoryID(int cateId);
	List<ProductModel> findWithCount(int count);
	ProductModel findOne(int id);
}