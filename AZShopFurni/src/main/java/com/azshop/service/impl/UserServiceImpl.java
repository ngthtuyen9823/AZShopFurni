package com.azshop.service.impl;

import com.azshop.dao.IUserDAO;
import com.azshop.dao.impl.UserDAOImpl;
import com.azshop.models.AccountModel;
import com.azshop.models.UserModel;
import com.azshop.service.IUserService;

public class UserServiceImpl implements IUserService {
	IUserDAO userDAO = new UserDAOImpl();	
	
	@Override
	public UserModel getInfoUser(int userID) {
		return userDAO.getInfoUser(userID);
	}

	@Override
	public void updateUser(UserModel user) {
		 userDAO.updateUser(user);
	}
	
	@Override
	public AccountModel getInfAccount(int userID) {
		return userDAO.getInfAccount(userID);
	}

	@Override
	public void updateAccount(AccountModel account) {
		userDAO.updateAccount(account);
	}
	
	@Override
	public boolean checkPassword(String oldPassword, String password) {
		if(oldPassword.equals(password)) {
			return true;
		}
		else return false;
	}
}
