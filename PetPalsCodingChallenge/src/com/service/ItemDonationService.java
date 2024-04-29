package com.service;

import java.sql.SQLException;
import com.dao.ItemDonationDao;
import com.daoimpl.ItemDonationDaoImpl;
import com.model.ItemDonation;

public class ItemDonationService {
	ItemDonationDao itemDonationDao = new ItemDonationDaoImpl();

	public int recordDonation(ItemDonation itemDonation,int donationId) throws SQLException {
		return itemDonationDao.recordDonation(itemDonation,donationId);
	}

}
