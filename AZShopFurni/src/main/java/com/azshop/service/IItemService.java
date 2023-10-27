package com.azshop.service;

import java.util.List;

import com.azshop.models.ItemModel;

public interface IItemService {
	List<ItemModel> findAll();
	List<ItemModel> findByProductID(int productID);
	ItemModel findOne(int id);
}
