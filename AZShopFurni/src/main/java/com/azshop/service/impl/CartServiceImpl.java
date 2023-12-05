package com.azshop.service.impl;

import com.azshop.dao.ICartDAO;
import com.azshop.dao.impl.CartDAOImpl;

import com.azshop.models.CartModel;

import com.azshop.service.ICartService;

public class CartServiceImpl implements ICartService {

	ICartDAO cartDAO = new CartDAOImpl();

	@Override
	public void insert(CartModel model) {
		cartDAO.insert(model);

	}

}
