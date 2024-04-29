package com.service;

import java.sql.SQLException;
import java.util.List;
import com.dao.ParticipantDao;
import com.daoimpl.ParticipantDaoImpl;
import com.model.Participant;

public class ParticipantService {
	ParticipantDao participantDao = new ParticipantDaoImpl();

	public int addParticipant(Participant participant) throws SQLException {
		return participantDao.addParticipant(participant);
	}

	public List<Participant> getAllParticipants() throws SQLException{
		return participantDao.getAllParticipants();
	}
}
