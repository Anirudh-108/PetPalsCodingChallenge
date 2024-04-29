package com.model;

public class Participant {
	private int partcipantId;
	private String participantName;
	private String participantType;

	public Participant() {
		super();
	}

	public Participant(int partcipantId, String participantName, String participantType) {
		super();
		this.partcipantId = partcipantId;
		this.participantName = participantName;
		this.participantType = participantType;
	}

	public int getPartcipantId() {
		return partcipantId;
	}

	public void setPartcipantId(int partcipantId) {
		this.partcipantId = partcipantId;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public String getParticipantType() {
		return participantType;
	}

	public void setParticipantType(String participantType) {
		this.participantType = participantType;
	}

	@Override
	public String toString() {
		return "Partcipants [partcipantId=" + partcipantId + ", participantName=" + participantName
				+ ", participantType=" + participantType + "]";
	}
}
