package com.dao;

import java.sql.SQLException;

import com.model.ItemDonation;

public interface ItemDonationDao {

	int recordDonation(ItemDonation donation,int donationId) throws SQLException;

}
