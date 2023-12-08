package com.azshop.service;

import java.util.List;

import com.azshop.models.OrderModel;

public interface IOrderService {
	List<OrderModel> findAllOrder();
	OrderModel findByOrderID(int orderID);
	OrderModel getOrderByOrderID(int orderID);
	List<OrderModel> findHisOrder(int sellerID);
	void updateStatusOrder(int orderID, int sellerID, int status);
	List<OrderModel> findOrderBySeller();
	void confirmOrder(int orderID, int confirm);
	List<OrderModel> listOrderByCustomerID(int customerID);
	void updateOrder (OrderModel order);
	void deleteOrder (int orderID);
}
