package com.azshop.service;

import com.azshop.models.AccountModel;
import com.azshop.models.UserModel;

public interface IUserService {
	UserModel getInfoUser(int userID);
	void updateUser(UserModel userMd);
	AccountModel getInfAccount(int userID);
	void updateAccount(AccountModel accountMd);
	boolean checkPassword(String oldPassword, String newPassword);
}
