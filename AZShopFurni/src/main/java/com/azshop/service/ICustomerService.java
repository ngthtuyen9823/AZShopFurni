package com.azshop.service;

import java.util.List;

import com.azshop.models.UserModel;

public interface ICustomerService {
	List<UserModel> getAllCustomer();
	UserModel getOneCustomer(int id);
	boolean insertCustomer(UserModel customerMd);
	boolean updateCustomer(UserModel customerMd);
	boolean deleteCustomer(UserModel customerMd);
	int createCustomerID();
}
