package com.dao;

import java.sql.SQLException;
import com.model.Donation;

public interface DonationDao {
	int recordDonation(Donation donation) throws SQLException;
}
