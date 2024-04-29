package com.service;

import java.sql.SQLException;
import com.dao.CashDonationDao;
import com.daoimpl.CashDonationDaoImpl;
import com.exception.InsufficientFundException;
import com.model.CashDonation;

public class CashDonationService {
	CashDonationDao cashDonationDao = new CashDonationDaoImpl();

	public int recordDonation(CashDonation cashDonation, int donationId)
			throws SQLException, InsufficientFundException {
		if (cashDonation.getDonationAmount() < 500)
			throw new InsufficientFundException("Please donate amount greater than Rs. 500");
		return cashDonationDao.recordDonation(cashDonation, donationId);
	}

}
