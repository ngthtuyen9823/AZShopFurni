package com.azshop.service;

import java.util.List;

import com.azshop.models.OrderModel;

public interface IOrderService {
	List<OrderModel> listOrder(int customerID);
}
