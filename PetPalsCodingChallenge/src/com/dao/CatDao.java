package com.dao;

import java.sql.SQLException;
import com.model.Cat;

public interface CatDao {
	int addCat(Cat cat) throws SQLException;
}
