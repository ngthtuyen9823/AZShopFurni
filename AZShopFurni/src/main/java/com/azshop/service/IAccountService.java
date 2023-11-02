package com.azshop.service;

import java.util.List;

import com.azshop.models.AccountModel;

public interface IAccountService {
	List<AccountModel> getAllAccount();
	AccountModel getOneAccount(int id); 
	boolean insertAccount(AccountModel account); 
	boolean updateAccount(AccountModel account); 
	boolean deleteAccount(AccountModel account);  
	int getTypeAccount(String username,String password);
	int getUserIDAccountByName(String username);
}
