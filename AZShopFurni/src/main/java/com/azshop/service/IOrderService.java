package com.azshop.service;

import java.util.List;

import com.azshop.models.OrderModel;

public interface IOrderService {
	List<OrderModel> listOrderByCustomerID(int customerID);
	void updateOrder (int orderID, int status);
	void confirmOrder (int orderID, int confirm);
}
