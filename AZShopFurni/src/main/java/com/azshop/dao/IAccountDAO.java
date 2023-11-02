package com.azshop.dao;

import java.util.List;

import com.azshop.models.AccountModel;

public interface IAccountDAO {
	List<AccountModel> getAllAccount();
	AccountModel getOneAccount(int id); 
	boolean insertAccount(AccountModel account); 
	boolean updateAccount(AccountModel account); 
	boolean deleteAccount(AccountModel account); 
	int getTypeAccount(int id);
	int getUserIDAccountByNameAndPass(String username,String password);
	int getUserIDAccountByName(String username);
}
