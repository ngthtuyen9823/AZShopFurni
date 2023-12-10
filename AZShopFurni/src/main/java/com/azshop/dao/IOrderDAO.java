package com.azshop.dao;

import java.util.List;

import com.azshop.models.OrderModel;

public interface IOrderDAO {
	List<OrderModel> listOrderByCustomerID(int customerID);
	OrderModel getOrderByOrderID(int orderID);
	List<OrderModel> findAllOrder();
	OrderModel findByOrderID(int orderID);
	void updateOrder (OrderModel order);
	void deleteOrder (int orderID);
	void updateStatusOrder (int orderID, int status);
	void confirmOrder (int orderID, int confirm);
	List<OrderModel> findHisOrder(int sellerID);
	List<OrderModel> findOrderBySeller();
	void updateStatusOrder(int OrderID,int sellerID, int status);
	OrderModel getOrderByID(int orderID);
}
