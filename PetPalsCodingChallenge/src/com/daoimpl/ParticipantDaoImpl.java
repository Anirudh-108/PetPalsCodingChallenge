package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dao.ParticipantDao;
import com.model.Participant;
import com.utility.DBConnection;

public class ParticipantDaoImpl implements ParticipantDao {

	@Override
	public int addParticipant(Participant participant) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "insert into participant (participant_id, participant_name, participant_type) values" + "(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, participant.getPartcipantId());
		pstmt.setString(2, participant.getParticipantName());
		pstmt.setString(3, participant.getParticipantType());
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public List<Participant> getAllParticipants() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select * from participant";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Participant> list = new ArrayList<>();
		while (rs.next()) {
			int participantId = rs.getInt("participant_id");
			String participantName = rs.getString("participant_name");
			String participantType = rs.getString("participant_type");
			Participant participant = new Participant(participantId, participantName, participantType);
			list.add(participant);
		}
		DBConnection.dbClose();
		return list;
	}

}
