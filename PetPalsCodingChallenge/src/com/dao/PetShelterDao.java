package com.dao;

import java.sql.SQLException;
import java.util.List;
import com.model.Pet;

public interface PetShelterDao {
	int addPet(Pet pet) throws SQLException;
	int removePet(int petId) throws SQLException;
	List<Pet> listAvailablePets() throws SQLException;
}
