package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Participant;

public interface ParticipantDao {
	int addParticipant(Participant participant) throws SQLException;
	List<Participant> getAllParticipants() throws SQLException;
}
