package com.azshop.dao;

import java.util.List;

import com.azshop.models.OrderModel;

public interface IOrderDAO {
	List<OrderModel> listOrderByCustomerID(int customerID);
	void updateOrder (int orderID, int status);
	void confirmOrder (int orderID, int confirm);
}
