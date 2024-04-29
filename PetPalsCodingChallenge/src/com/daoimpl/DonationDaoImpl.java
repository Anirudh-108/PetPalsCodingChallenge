package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.dao.DonationDao;
import com.model.Donation;
import com.utility.DBConnection;

public class DonationDaoImpl implements DonationDao {

	@Override
	public int recordDonation(Donation donation) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "insert into donation (donation_id, donor_name,pet_id) values" + "(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, donation.getDonorId());
		pstmt.setString(2, donation.getDonorName());
		pstmt.setInt(3, donation.getPetId());
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

}
