package com.yas.talentshowvotingapp.model;

import java.util.Date;
import java.util.List;

public final class Event {

	private String eventId;
	private Date startTime;

	private Date endTime;
	private String name;
	private String Organizer;
	private boolean isActive;
	private List<Item> items;

	public Event(String eventId, Date startTime, Date endTime, String name, String organizer, boolean isActive,
			List<Item> items) {
		super();
		this.eventId = eventId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.name = name;
		Organizer = organizer;
		this.isActive = isActive;
		this.items = items;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganizer() {
		return Organizer;
	}

	public void setOrganizer(String organizer) {
		Organizer = organizer;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
