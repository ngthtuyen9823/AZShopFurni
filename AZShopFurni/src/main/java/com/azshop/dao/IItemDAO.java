package com.azshop.dao;

import java.util.List;

import com.azshop.models.ItemModel;

public interface IItemDAO {
	List<ItemModel> findAll();
	List<ItemModel> findByProductID(int productID);
	ItemModel findOne(int id);
}