package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Pet;

public interface PetDao {
	int addPet(Pet pet) throws SQLException;
	List<Pet> getAllPets() throws SQLException;
	int removePetById(int petId) throws SQLException;
	List<Pet> getAllAvailablePets() throws SQLException;
}
