package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.dao.IAccountDAO;
import com.azshop.models.AccountModel;

import com.azshop.connection.DBConnection;
public class AccountDAOImpl implements IAccountDAO{

	@Override
	public List<AccountModel> getAllAccount() {
		String sql = "SELECT * FROM ACCOUNT";
		List<AccountModel> listAccount = new ArrayList<>();
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				AccountModel account = new AccountModel();
				account.setUserID(rs.getInt(1));
				account.setUserName(rs.getString(2));
				account.setPassword(rs.getString(3));
				listAccount.add(account);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}		
		return listAccount;
	}

	@Override
	public AccountModel getOneAccount(int id) {
		String sql = "SELECT * FROM ACCOUNT WHERE USERID=?";
		AccountModel account = new AccountModel();
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{				
				account.setUserID(rs.getInt(1));
				account.setUserName(rs.getString(2));
				account.setPassword(rs.getString(3));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}		
		return account;
	}

	@Override
	public boolean insertAccount(AccountModel account) {
		String sql = "INSERT INTO `AZShop`.`ACCOUNT` (`UserID`, `UserName`, `Password`) VALUES (?, ?,?);";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, account.getUserID());
			ps.setString(2, account.getUserName());
			ps.setString(3,account.getPassword());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	@Override
	public boolean updateAccount(AccountModel account) {
		String sql = "UPDATE `AZShop`.`ACCOUNT` SET `UserName` = ?, `Password` = ? WHERE (`UserID` = ?)";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account.getUserName());
			ps.setString(2,account.getPassword());
			ps.setInt(3, account.getUserID());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteAccount(AccountModel account) {
		String sql = "DELETE FROM `AZShop`.`ACCOUNT` WHERE (`UserID` = ?)";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, account.getUserID());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}



}
