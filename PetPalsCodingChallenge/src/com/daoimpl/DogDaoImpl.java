package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dao.DogDao;
import com.model.Dog;
import com.utility.DBConnection;

public class DogDaoImpl implements DogDao {

	@Override
	public int addDog(Dog dog) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "insert into dog (dog_id, dog_breed, pet_id) values" + "(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, dog.getDogId());
		pstmt.setString(2, dog.getDogBreed());
		pstmt.setInt(3, dog.getPetId());
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

}
