package com.service;

import java.sql.SQLException;
import com.dao.DonationDao;
import com.daoimpl.DonationDaoImpl;
import com.model.Donation;

public class DonationService {
	DonationDao donationDao = new DonationDaoImpl();

	public int recordDonation(Donation donation) throws SQLException {
		return donationDao.recordDonation(donation);
	}

}
