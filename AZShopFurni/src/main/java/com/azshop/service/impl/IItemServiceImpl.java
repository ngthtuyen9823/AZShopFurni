package com.azshop.service.impl;

import java.util.List;

import com.azshop.dao.IItemDAO;
import com.azshop.dao.impl.ItemDAOImpl;
import com.azshop.models.ItemModel;
import com.azshop.service.IItemService;

public class IItemServiceImpl implements IItemService{
	IItemDAO itemDAO = new ItemDAOImpl();

	@Override
	public List<ItemModel> findAll() {
		return itemDAO.findAll();
	}

	@Override
	public List<ItemModel> findByProductID(int productID) {
		return itemDAO.findByProductID(productID);
	}

	@Override
	public ItemModel findOne(int id) {
		return itemDAO.findOne(id);
	}

	@Override
	public void insertItem(ItemModel model) {
		insertItem(model);
	}

	@Override
	public void deleteItem(int IteID) {
		deleteItem(IteID);
	}

	@Override
	public void updateItem(ItemModel model) {
		updateItem(model);
	}

}
