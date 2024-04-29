package com.service;

import java.sql.SQLException;
import com.dao.CatDao;
import com.daoimpl.CatDaoImpl;
import com.model.Cat;

public class CatService {
	CatDao catDao=new CatDaoImpl();
	public int save(Cat cat) throws SQLException {
		return catDao.addCat(cat);
	}

}
