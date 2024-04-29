package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.dao.CashDonationDao;
import com.model.CashDonation;
import com.utility.DBConnection;

public class CashDonationDaoImpl implements CashDonationDao {

	@Override
	public int recordDonation(CashDonation donation, int donationId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "insert into cash_donation (cash_id, donation_date, donation_amount, donation_id) values"
				+ "(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, donation.getCashDonationId());
		pstmt.setString(2, donation.getDonationDate());
		pstmt.setDouble(3, donation.getDonationAmount());
		pstmt.setInt(4, donationId);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

}
