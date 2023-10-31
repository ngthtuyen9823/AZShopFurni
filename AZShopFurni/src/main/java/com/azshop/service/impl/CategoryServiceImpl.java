package com.azshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.azshop.dao.ICategoryDAO;
import com.azshop.dao.impl.CategoryDAOImpl;
import com.azshop.models.CategoryModel;
import com.azshop.models.submodels.CategoryLevelModel;
import com.azshop.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
	ICategoryDAO categoryDAO = new CategoryDAOImpl();

	@Override
	public CategoryModel findOne(int id) {
		return categoryDAO.findOne(id);
	}

	@Override
	public List<CategoryLevelModel> getCategoryLevels() {
		List<CategoryModel> listCategory = categoryDAO.findAll();
		List<CategoryLevelModel> CategoryLevel = new ArrayList<CategoryLevelModel>();

		for (CategoryModel category : listCategory) {
			if (category.getParentCategoryID() == 0) {
				CategoryLevelModel categoryLevel = new CategoryLevelModel();
				categoryLevel.setCategoryID(category.getCategoryID());
				categoryLevel.setCategoryName(category.getCategoryName());
				categoryLevel.setChildrens(getChildren(listCategory, category.getCategoryID()));
				CategoryLevel.add(categoryLevel);
			}
		}

		return CategoryLevel;

	}

	private static List<CategoryLevelModel> getChildren(List<CategoryModel> data, int parentCategoryID) {
		List<CategoryLevelModel> children = new ArrayList<>();
		for (CategoryModel category : data) {
			if (category.getParentCategoryID() == parentCategoryID) {
				CategoryLevelModel newCateGoryDate = new CategoryLevelModel();
				newCateGoryDate.setCategoryID(category.getCategoryID());
				newCateGoryDate.setCategoryName(category.getCategoryName());
				newCateGoryDate.setParentCategoryID(category.getParentCategoryID());
				newCateGoryDate.setChildrens(new ArrayList<CategoryLevelModel>());
				
				children.add(newCateGoryDate);
				children.addAll(getChildren(data, category.getCategoryID()));
			}
		}

		return children;
	}

}