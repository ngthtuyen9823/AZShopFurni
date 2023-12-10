package com.azshop.service.impl;

import java.util.List;

import com.azshop.dao.IDetailDAO;
import com.azshop.dao.IOrderDAO;
import com.azshop.dao.impl.DetailDAOImpl;
import com.azshop.dao.impl.OrderDAOImpl;
import com.azshop.models.OrderModel;
import com.azshop.service.IOrderService;

public class OrderServiceImpl implements IOrderService{
	IOrderDAO orderDAO = new OrderDAOImpl();
	IDetailDAO detailDAO =new DetailDAOImpl();
	@Override
	public List<OrderModel> listOrderByCustomerID(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirmOrder(int orderID, int confirm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderModel> findOrderBySeller() {
		List<OrderModel> list = orderDAO.findOrderBySeller();
		list.forEach(order -> order.setDetails(detailDAO.listDetail(order.getOrderID())));
		return list;
	}

	@Override
	public void updateStatusOrder(int orderID,int sellerID, int status) {
		orderDAO.updateStatusOrder(orderID,sellerID, status);
	}

	@Override
	public List<OrderModel> findHisOrder(int sellerID) {
		List<OrderModel> list = orderDAO.findHisOrder(sellerID);
		list.forEach(order -> order.setDetails(detailDAO.listDetail(order.getOrderID())));
		return list;
	}

	@Override
	public OrderModel getOrderByOrderID(int orderID) {
		OrderModel order=orderDAO.getOrderByOrderID(orderID);
		order.setDetails(detailDAO.listDetail(order.getOrderID()));
		return order;
	}
	
	
	@Override
	public List<OrderModel> findAllOrder() {
		return orderDAO.findAllOrder();
	}
	@Override
	public void updateOrder(OrderModel order) {
		// TODO Auto-generated method stub
		orderDAO.updateOrder(order);
		
	}
	@Override
	public void deleteOrder(int orderID) {
		// TODO Auto-generated method stub
		orderDAO.deleteOrder(orderID);
		
	}
	@Override
	public OrderModel findByOrderID(int orderID) {
		// TODO Auto-generated method stub
		return orderDAO.findByOrderID(orderID);
	}
	
	
}
