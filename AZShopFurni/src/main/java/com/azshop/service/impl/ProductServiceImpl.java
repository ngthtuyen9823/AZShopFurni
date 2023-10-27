package com.azshop.service.impl;

import java.util.List;

import com.azshop.dao.IProductDAO;
import com.azshop.dao.impl.ProductDAOImpl;
import com.azshop.models.ProductModel;
import com.azshop.service.IProductService;

public class ProductServiceImpl implements IProductService{

	IProductDAO productDAO = new ProductDAOImpl();
	
	@Override
	public List<ProductModel> findAll() {
		return productDAO.findAll();
	}

	@Override
	public List<ProductModel> findByCategoryID(int cateId) {
		return productDAO.findByCategoryID(cateId);
	}

	@Override
	public List<ProductModel> findWithCount(int count) {
		return productDAO.findWithCount(count);
	}

	@Override
	public ProductModel findOne(int id) {
		return productDAO.findOne(id);
	}

}
