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
	
	public static void main(String[] args) {
		IOrderService orderSer = new  OrderServiceImpl();
		List<OrderModel> list = orderSer.listOrderByCustomerID(120007);
		list.forEach(o -> {
			System.out.println(o);
			o.getDetails().forEach(d -> System.out.println(d));
			});
		
	}
}
