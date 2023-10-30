package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.connection.DBConnection;
import com.azshop.dao.ICustomerDAO;
import com.azshop.models.AccountModel;
import com.azshop.models.UserModel;

public class CustomerDAOImpl implements ICustomerDAO {

	@Override
	public List<UserModel> getAllCustomer() {
		String sql = "SELECT * FROM USER WHERE Type=0";
		List<UserModel> listCustomer = new ArrayList<>();
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel customer = new UserModel();
				customer.setUserID(rs.getInt(1));
				customer.setFirstName(rs.getString(2));
				customer.setLastName(rs.getString(3));
				customer.setAddress(rs.getString(4));
				customer.setGender(rs.getInt(5));
				customer.setPhone(rs.getString(6));
				customer.setDob(rs.getDate(7));
				customer.setCid(rs.getString(8));
				customer.setAvatar(rs.getString(9));
				customer.setType(rs.getInt(10));
				customer.setKpi(rs.getInt(11));
				customer.setArea(rs.getString(12));
				customer.setEmail(rs.getString(13));
				listCustomer.add(customer);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return listCustomer;
	}

	@Override
	public UserModel getOneCustomer(int id) {
		String sql = "SELECT * FROM USER WHERE UserID = ?";
		UserModel customer = new UserModel();
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer.setUserID(rs.getInt(1));
				customer.setFirstName(rs.getString(2));
				customer.setLastName(rs.getString(3));
				customer.setAddress(rs.getString(4));
				customer.setGender(rs.getInt(5));
				customer.setPhone(rs.getString(6));
				customer.setDob(rs.getDate(7));
				customer.setCid(rs.getString(8));
				customer.setAvatar(rs.getString(9));
				customer.setType(rs.getInt(10));
				customer.setKpi(rs.getInt(11));
				customer.setArea(rs.getString(12));
				customer.setEmail(rs.getString(13));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return customer;
	}

	@Override
	public boolean insertCustomer(UserModel customerMd) {
		String sql = "INSERT INTO USER VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? , ? , ? , ? , ?)";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customerMd.getUserID());
			ps.setString(2, customerMd.getFirstName());
			ps.setString(3, customerMd.getLastName());
			ps.setString(4, customerMd.getAddress());
			ps.setInt(5, customerMd.getGender());
			ps.setString(6, customerMd.getPhone());
			ps.setDate(7, (Date) customerMd.getDob());
			ps.setString(8, customerMd.getCid());
			ps.setString(9, customerMd.getAvatar());
			ps.setInt(10, customerMd.getType());
			ps.setInt(11,customerMd.getKpi());
			ps.setString(12, customerMd.getArea());
			ps.setString(13, customerMd.getEmail());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

		return true;
	}

	@Override
	public boolean updateCustomer(UserModel customerMd) {
		String sql = "UPDATE USER SET FirstName = ?, LastName = ?, Address = ?, Gender = ?, "
				+ "Phone = ?, DoB = ?, Cid = ?, Avatar = ? , Email = ?WHERE UserID = ?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, customerMd.getFirstName());
			ps.setString(2, customerMd.getLastName());
			ps.setString(3, customerMd.getAddress());
			ps.setInt(4, customerMd.getGender());
			ps.setString(5, customerMd.getPhone());
			ps.setDate(6, (Date) customerMd.getDob());
			ps.setString(7, customerMd.getCid());
			ps.setString(8, customerMd.getAvatar());
			ps.setString(9, customerMd.getEmail());
			ps.setInt(10, customerMd.getUserID());
			ps.executeUpdate();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCustomer(UserModel customerMd) {		
		String sql = "DELETE FROM `AZShop`.`USER` WHERE (`UserID` = ?)";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customerMd.getUserID());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

}
