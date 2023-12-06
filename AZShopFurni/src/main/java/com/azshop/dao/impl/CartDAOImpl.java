package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.connection.DBConnection;
import com.azshop.dao.ICartDAO;
import com.azshop.models.CartModel;
import com.azshop.models.CategoryModel;

public class CartDAOImpl implements ICartDAO {
	Connection conn = null;

	@Override
	public void insert(CartModel model) {
		String sql = "Insert into CART (CustomerID, ItemID, Quantity) values (?,?,?)";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getCustomerID());
			ps.setInt(2, model.getItemID());
			ps.setInt(3, model.getQuantity());
			System.out.print(model);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(CartModel model) {
		String sql = "Update CART set Quantity = ? where CustomerID=? and ItemID=?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getQuantity());
			ps.setInt(2, model.getCustomerID());
			ps.setInt(3, model.getItemID());

			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int customerID, int itemID) {
		String sql = "Delete from CART where CustomerID=? and ItemID=?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customerID);
			ps.setInt(2, itemID);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAll() {
		String sql = "Truncate table CART";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public CartModel findOne(int customerID, int itemID) {
		CartModel cart = new CartModel();
		String sql = "Select * from CART where CustomerID=? and ItemID=?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, customerID);
			ps.setInt(2, itemID);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cart.setCustomerID(rs.getInt("CustomerID"));
				cart.setItemID(rs.getInt("ItemID"));
				cart.setQuantity(rs.getInt("Quantity"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}

	@Override
	public List<CartModel> findAll() {
		List<CartModel> listCart = new ArrayList<CartModel>();
		String sql = "Select c.*, i.Color, i.Size, i.PromotionPrice, p.ProductName, i.PromotionPrice * c.Quantity as TotalPrice\r\n"
				+ "from CART c\r\n" + "join ITEM i\r\n" + "on c.ItemID = i.ItemID\r\n" + "join PRODUCT p\r\n"
				+ "on i.ProductID = p.ProductID";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartModel cart = new CartModel();
				cart.setCustomerID(rs.getInt("CustomerID"));
				cart.setItemID(rs.getInt("ItemID"));
				cart.setQuantity(rs.getInt("Quantity"));
				cart.setColor(rs.getString("Color"));
				cart.setSize(rs.getString("Size"));
				cart.setPromotionPrice(rs.getInt("PromotionPrice"));
				cart.setProductName(rs.getString("ProductName"));
				cart.setTotalPrice(rs.getInt("TotalPrice"));
				listCart.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCart;
	}

	public static void main(String[] args) {
		// Test the CartDAOImpl methods
		CartDAOImpl cartDAO = new CartDAOImpl();

		// Delete
//		cartDAO.delete(100001, 10100101);

		// Insert
//		CartModel newCart = new CartModel();
//		newCart.setCustomerID(100001);
//		newCart.setItemID(10100101);
//		newCart.setQuantity(3);
//		cartDAO.insert(newCart);

		// Update
//		CartModel existingCart = cartDAO.findOne(100001, 10100101);
//		if (existingCart != null) {
//			existingCart.setQuantity(existingCart.getQuantity() + 1);
//			cartDAO.update(existingCart);
//		}
//
//		// FindOne
//		CartModel foundCart = cartDAO.findOne(100001, 10100101);
//		if (foundCart != null) {
//			System.out.println("Found Cart: " + foundCart.getCustomerID() + ", " + foundCart.getItemID() + ", "
//					+ foundCart.getQuantity());
//		} else {
//			System.out.println("Cart not found.");
//		}

//		// FindAll
		System.out.println("All Carts:");
		for (CartModel cart : cartDAO.findAll()) {
			System.out.println(cart);
		}
	}

}