package com.azshop.service.impl;

import java.util.List;

import com.azshop.dao.IAccountDAO;
import com.azshop.dao.impl.AccountDAOImpl;
import com.azshop.models.AccountModel;
import com.azshop.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

	IAccountDAO accountDao = new AccountDAOImpl();
	
	@Override
	public List<AccountModel> getAllAccount() {
		return accountDao.getAllAccount();
	}

	@Override
	public AccountModel getOneAccount(int id) {
		return accountDao.getOneAccount(id);
	}
	@Override
	public boolean insertAccount(AccountModel account) {
		return accountDao.insertAccount(account);
		
	}

	@Override
	public boolean updateAccount(AccountModel account) {
		return accountDao.updateAccount(account);
		
	}

	@Override
	public boolean deleteAccount(AccountModel account) {
		return accountDao.deleteAccount(account);
		
	}

	@Override
	public int getTypeAccount(String username,String password) {
		int userID = accountDao.getUserIDAccountByNameAndPass(username, password);
		if(userID >= 0)
			return accountDao.getTypeAccount(userID);
		else
			return -1;
	}

	@Override
	public int getUserIDAccountByName(String username) {
		return accountDao.getUserIDAccountByName(username);
	}
}
