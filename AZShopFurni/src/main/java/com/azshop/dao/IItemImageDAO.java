package com.azshop.dao;

import java.util.List;

import com.azshop.models.ItemImageModel;

public interface IItemImageDAO {
	List<ItemImageModel> findByProductID(int productID);
}
