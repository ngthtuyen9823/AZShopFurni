package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.azshop.connection.DBConnection;
import com.azshop.dao.IUserDAO;
import com.azshop.models.AccountModel;
import com.azshop.models.UserModel;

public class UserDAOImpl implements IUserDAO {

	@Override
	public UserModel getInfoUser(int userID) {
		UserModel userMd = new UserModel();
		String sql = "SELECT * FROM USER WHERE UserID = ?";
		
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				userMd.setUserID(rs.getInt("UserID"));
				userMd.setFirstName(rs.getString("FirstName"));
				userMd.setLastName(rs.getString("LastName"));
				userMd.setAddress(rs.getString("Address"));
				userMd.setGender(rs.getInt("Gender"));
				userMd.setPhone(rs.getString("Phone"));
				userMd.setDob(rs.getDate("Dob"));
				userMd.setCid(rs.getString("Cid"));
				userMd.setAvatar(rs.getString("Avatar"));
				userMd.setType(rs.getInt("Type"));
				userMd.setKpi(rs.getInt("KPI"));
				userMd.setArea(rs.getString("Area"));
				userMd.setEmail(rs.getString("Email"));
			}
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return userMd;
	}

	@Override
	public void updateUser(UserModel userMd) {
		String sql = "UPDATE USER SET FirstName = ?, LastName = ?, Address = ?, Gender = ?, "
					+ "Phone = ?, DoB = ?, Cid = ?, Avatar = ? WHERE UserID = ?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userMd.getFirstName());
			ps.setString(2, userMd.getLastName());
			ps.setString(3, userMd.getAddress());
			ps.setInt(4, userMd.getGender());
			ps.setString(5, userMd.getPhone());
			ps.setDate(6, (Date) userMd.getDob());
			ps.setString(7, userMd.getCid());
			ps.setString(8, userMd.getAvatar());
			ps.setInt(9, userMd.getUserID());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public AccountModel getInfAccount(int userID) {
		AccountModel accountMd = new AccountModel();
		String sql = "SELECT * FROM ACCOUNT WHERE USERID= ? ";
		
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userID);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{				
				accountMd.setUserID(rs.getInt("UserID"));
				accountMd.setUserName(rs.getString("UserName"));
				accountMd.setPassword(rs.getString("Password"));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}		
		return accountMd;
	}

	@Override
	public void updateAccount(AccountModel accountMd) {
		String sql = "UPDATE ACCOUNT SET Password = ? WHERE UserID = ?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, accountMd.getPassword());
			ps.setInt(2, accountMd.getUserID());
			ps.executeUpdate();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
