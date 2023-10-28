package com.azshop.service.impl;

import com.azshop.dao.ICategoryDAO;
import com.azshop.dao.impl.CategoryDAOImpl;
import com.azshop.models.CategoryModel;
import com.azshop.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService{
	ICategoryDAO categoryDAO = new CategoryDAOImpl();

	@Override
	public CategoryModel findOne(int id) {
		return categoryDAO.findOne(id);
	}

}