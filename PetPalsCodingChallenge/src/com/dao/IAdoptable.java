package com.dao;

import java.sql.SQLException;
import java.util.List;
import com.model.Event;
import com.model.Participant;
import com.model.Pet;

public interface IAdoptable {
	Pet adoptPet(int petId) throws SQLException;
	int registerParticipant(Participant partcipant) throws SQLException;
	List<Participant> getAllPartcipants() throws SQLException;
	int hostEvent(Event event) throws SQLException;
}
