package com.yas.talentshowvotingapp.controller;

import java.util.Date;

import com.yas.talentshowvotingapp.dao.DataManager;
import com.yas.talentshowvotingapp.model.Event;
import com.yas.talentshowvotingapp.service.VotingAppService;
import com.yas.talentshowvotingapp.view.EventView;

public class EventController {

	private Event event;
	private VotingAppService votingAppService = new DataManager();
	private EventView eventView;

	public EventView getEventView() {
		return eventView;
	}

	public void setEventView(EventView eventView) {
		this.eventView = eventView;
	}

	public EventController(EventView eventView) {
		super();
		this.eventView = eventView;
	}

	public void addEvent(final Event event) {
		// add event
		votingAppService.addEvent(event);
		// set running active event into controller
		// this event will access through all the application.
		setEvent(event);

	}

	public Event getLatestActiveEvent() {

		setEvent(votingAppService.getLatestActiveEvent());

		return this.event;
	}

	public void setEventActiveMode(boolean isActive) {
		votingAppService.setEventActiveMode(this.event.getEventId(), isActive);
	}

	public void setEventEndDate(final Date endDate) {
		votingAppService.setEventEndDate(this.event.getEventId(), endDate);
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}
