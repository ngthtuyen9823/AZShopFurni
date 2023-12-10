package com.azshop.service.impl;

import java.util.List;

import com.azshop.dao.IDetailDAO;
import com.azshop.dao.IOrderDAO;
import com.azshop.dao.impl.DetailDAOImpl;
import com.azshop.dao.impl.OrderDAOImpl;
import com.azshop.models.OrderModel;
import com.azshop.service.IOrderService;

public class OrderServiceImpl implements IOrderService {

	IOrderDAO orderDAO = new OrderDAOImpl();
	IDetailDAO detailDAO = new DetailDAOImpl();

	@Override
	public List<OrderModel> listOrderByCustomerID(int customerID) {
		List<OrderModel> list = orderDAO.listOrderByCustomerID(customerID);
		list.forEach(order -> order.setDetails(detailDAO.listDetail(order.getOrderID())));
		return list;
	}

	@Override
	public void updateOrder(int orderID, int status) {
		orderDAO.updateOrder(orderID, status);
	}

	@Override
	public void confirmOrder(int orderID, int confirm) {
		orderDAO.confirmOrder(orderID, confirm);
	}

	@Override
	public OrderModel getOrderByOrderID(int orderID) {
		OrderModel order = orderDAO.getOrderByOrderID(orderID);
		order.setDetails(detailDAO.listDetail(order.getOrderID()));
		return order;
	}

	@Override
	public OrderModel insertOrder(OrderModel order) {
		return orderDAO.insertOrder(order);
	}
}
