package com.azshop.service.impl;

import java.util.List;

import com.azshop.dao.ICustomerDAO;
import com.azshop.dao.impl.CustomerDAOImpl;
import com.azshop.models.UserModel;
import com.azshop.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {
	ICustomerDAO customerDao = new CustomerDAOImpl();

	@Override
	public List<UserModel> getAllCustomer() {
		return customerDao.getAllCustomer();
	}

	@Override
	public UserModel getOneCustomer(int id) {
		return customerDao.getOneCustomer(id);
	}

	@Override
	public boolean insertCustomer(UserModel customerMd) {
		return customerDao.insertCustomer(customerMd);
	}

	@Override
	public boolean updateCustomer(UserModel customerMd) {
		return customerDao.updateCustomer(customerMd);
	}

	@Override
	public boolean deleteCustomer(UserModel customerMd) {
		return customerDao.deleteCustomer(customerMd);
	}

	@Override
	public int createCustomerID() {
		 List<UserModel> listCustomer = customerDao.getAllCustomer();
		    int id = listCustomer.get(listCustomer.size() - 1).getUserID();System.out.println(id+1);
		    return id+1;
	}

}
