package com.azshop.dao;

import java.util.List;

import com.azshop.models.OrderModel;

public interface IOrderDAO {
	List<OrderModel> findAllOrder();
	OrderModel findByOrderID(int orderID);
	void updateOrder (OrderModel order);
	void deleteOrder (int orderID);
	List<OrderModel> listOrderByCustomerID(int customerID);
	void updateOrder (int orderID, int status);
	void confirmOrder (int orderID, int confirm);
	OrderModel getOrderByOrderID(int orderID);
	List<OrderModel> findHisOrder(int sellerID);
	List<OrderModel> findOrderBySeller();
	void updateStatusOrder(int OrderID,int sellerID, int status);
}
