package com.service;

import java.sql.SQLException;

import com.dao.DogDao;
import com.daoimpl.DogDaoImpl;
import com.model.Dog;

public class DogService {
	DogDao dogDao=new DogDaoImpl();
	public int save(Dog dog) throws SQLException {
		return dogDao.addDog(dog);
	}

}
