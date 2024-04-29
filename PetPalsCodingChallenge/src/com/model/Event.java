package com.model;

public class Event {
	private int eventId;
	private String eventName;
	private String eventDate;
	private String eventAddress;
	private int participantId;
	private int petId;

	public Event() {
		super();
	}

	public Event(int eventId, String eventName, String eventDate, String eventAddress, int participantId, int petId) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventAddress = eventAddress;
		this.participantId = participantId;
		this.petId = petId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventAddress() {
		return eventAddress;
	}

	public void setEventAddress(String eventAddress) {
		this.eventAddress = eventAddress;
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", eventDate=" + eventDate + ", eventAddress="
				+ eventAddress + ", participantId=" + participantId + ", petId=" + petId + "]";
	}
}
