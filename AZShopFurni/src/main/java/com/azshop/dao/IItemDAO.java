package com.azshop.dao;

import java.util.List;

import com.azshop.models.ItemModel;

public interface IItemDAO {
	List<ItemModel> findAll();
	List<ItemModel> findByProductID(int productID);
	ItemModel findOneByProductID(int productID);
	ItemModel findOne(int id);
	int findDisplayedPromotionPrice(int productID);
	int findDisplayedOriginalPrice(int productID);
}