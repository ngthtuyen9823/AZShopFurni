package com.azshop.service.impl;

import java.util.List;

import com.azshop.dao.IOrderDAO;
import com.azshop.dao.impl.OrderDAOImpl;
import com.azshop.models.OrderModel;
import com.azshop.service.IOrderService;

public class OrderServiceImpl implements IOrderService{
	
	IOrderDAO orderDAO = new OrderDAOImpl();
	@Override
	public List<OrderModel> listOrder(int customerID) {
		return orderDAO.listOrder(customerID);
	}
	@Override
	public void updateOrder(int orderID, int status) {
		orderDAO.updateOrder(orderID, status);
	}
	@Override
	public void confirmOrder(int orderID, int confirm) {
		orderDAO.confirmOrder(orderID, confirm);
	}
}
