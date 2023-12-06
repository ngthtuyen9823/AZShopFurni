package com.azshop.service;

import java.util.List;

import com.azshop.models.CartModel;

public interface ICartService {
	void insert(CartModel model);

	void update(CartModel model);

	void delete(int customerID, int itemID);

	void deleteAll();

	CartModel findOne(int customerID, int itemID);

	List<CartModel> findAll();
}
