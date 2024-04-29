package com.dao;

import java.sql.SQLException;

import com.model.CashDonation;

public interface CashDonationDao {

	int recordDonation(CashDonation donation, int donationId) throws SQLException;

}
