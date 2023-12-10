package com.azshop.service;

import java.util.List;

import com.azshop.models.OrderModel;

public interface IOrderService {
	List<OrderModel> listOrderByCustomerID(int customerID);
	OrderModel getOrderByOrderID(int orderID);
	void updateOrder (int orderID, int status);
	void updateOrder (OrderModel order);
	void confirmOrder (int orderID, int confirm);
	public List<OrderModel> findNeedShipByArea(String area);
	public List<OrderModel> findShipingByShipperID(int ShipperID);
	public List<OrderModel> findHisDeliveryByShipperID(int ShipperID);
	public OrderModel findShipByID(int OrderID);
}
