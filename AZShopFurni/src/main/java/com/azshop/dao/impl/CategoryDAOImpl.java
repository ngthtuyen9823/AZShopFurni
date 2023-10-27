package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.azshop.connection.DBConnection;
import com.azshop.dao.ICategoryDAO;
import com.azshop.models.CategoryModel;

public class CategoryDAOImpl implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		return null;
	}

	@Override
	public CategoryModel findOne(int id) {
		CategoryModel category = new CategoryModel();
		String sql = "Select * from CATEGORY where CategoryID=?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				category = new CategoryModel();
				category.setCategoryID(rs.getInt("CategoryID"));
				category.setCategoryName(rs.getString("CategoryName"));
				category.setParentCategoryID(rs.getInt("ParentCategoryID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public void insert(CategoryModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CategoryModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		ICategoryDAO cateDAO = new CategoryDAOImpl();
		CategoryModel model = cateDAO.findOne(1);
		System.out.println(model);
	}
}
