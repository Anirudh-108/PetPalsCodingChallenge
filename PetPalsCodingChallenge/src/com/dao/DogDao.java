package com.dao;

import java.sql.SQLException;
import com.model.Dog;

public interface DogDao {
	int addDog(Dog dog) throws SQLException;
}
