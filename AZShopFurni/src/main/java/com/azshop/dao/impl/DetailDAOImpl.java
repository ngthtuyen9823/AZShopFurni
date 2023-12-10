package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.connection.DBConnection;
import com.azshop.dao.IDetailDAO;
import com.azshop.models.DetailModel;
import com.azshop.models.ItemModel;
import com.azshop.models.ProductModel;

public class DetailDAOImpl implements IDetailDAO{
	@Override
	public List<DetailModel> listDetail(int orderID) {
		List<DetailModel> listDetail = new ArrayList<DetailModel>();
		String sql =  "SELECT  P.ProductID,P.Description, I.ItemID, O.OrderID, P.ProductName, I.Color, I.Size, D.Quantity, I.OriginalPrice, I.PromotionPrice, IM.Image\r\n"
					+ "FROM PRODUCT AS P \r\n"
					+ "			INNER JOIN ITEM I ON P.ProductID = I.ProductID \r\n"
					+ "			INNER JOIN DETAIL D on I.ItemID = D.ItemID\r\n"
					+ "			INNER JOIN `ORDER` O on O.OrderID = D.OrderID\r\n"
					+ "    		INNER JOIN (SELECT MIN(II.ItemImageID) AS ItemImageID, II.ItemID, MIN(II.Image) AS Image\r\n"
					+ "						FROM ITEMIMAGE II, ITEM IT\r\n"
					+ "						WHERE II.ItemID = IT.ItemID\r\n"
					+ "						GROUP BY II.ItemID) IM ON IM.ItemID = I.ItemID \r\n"
					+ "WHERE O.OrderID = ?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderID);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				DetailModel detail = new DetailModel();
				detail.getProduct().setProductID(rs.getInt(1));
				detail.getProduct().setDescription(rs.getString(2));
				detail.setItemID(rs.getInt(3));
				detail.setOrderID(rs.getInt(4));
				detail.getProduct().setProductName(rs.getString(5));
				detail.getItem().setColor(rs.getString(6));
				detail.getItem().setSize(rs.getString(7));
				detail.setQuantity(rs.getInt(8));
				detail.getItem().setOriginalPrice(rs.getInt(9));
				detail.getItem().setPromotionPrice(rs.getInt(10));
				detail.getItem().setImage(rs.getString(11));
				
				listDetail.add(detail);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listDetail;
	}

	
}