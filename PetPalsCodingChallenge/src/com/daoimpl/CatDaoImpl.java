package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dao.CatDao;
import com.model.Cat;
import com.utility.DBConnection;

public class CatDaoImpl implements CatDao {

	@Override
	public int addCat(Cat cat) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "insert into cat (cat_id, cat_color, pet_id) values" + "(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, cat.getCatId());
		pstmt.setString(2, cat.getCatColor());
		pstmt.setInt(3, cat.getPetId());
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

}
