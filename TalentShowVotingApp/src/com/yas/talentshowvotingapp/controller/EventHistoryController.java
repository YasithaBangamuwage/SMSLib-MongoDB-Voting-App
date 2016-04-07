package com.yas.talentshowvotingapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.yas.talentshowvotingapp.dao.DataManager;
import com.yas.talentshowvotingapp.model.Event;
import com.yas.talentshowvotingapp.model.Item;
import com.yas.talentshowvotingapp.model.Participant;
import com.yas.talentshowvotingapp.service.VotingAppService;
import com.yas.talentshowvotingapp.view.EventHistoryView;

public class EventHistoryController {

	private VotingAppService votingAppService = new DataManager();
	private EventHistoryView eventHistoryView;

	public EventHistoryController(EventHistoryView eventHistoryView) {
		super();
		this.eventHistoryView = eventHistoryView;
	}

	public Event getSelectedHistoryEvent(final String eventId) {

		Event event = votingAppService.getEvent(eventId);

		List<Participant> participants = votingAppService.getEventParticipants(eventId);

		List<Item> itemsWithParticipants = new ArrayList<Item>();

		for (Item item : event.getItems()) {

			item.getParticipants().clear();

			for (Participant participant : participants) {

				if (item.getItemId().equals(participant.getItemId())) {
					item.getParticipants().add(participant);
				}
			}
			itemsWithParticipants.add(item);
		}

		event.setItems(itemsWithParticipants);
		return event;
	}

	public EventHistoryView getEventHistoryView() {
		return eventHistoryView;
	}

	public void setEventHistoryView(EventHistoryView eventHistoryView) {
		this.eventHistoryView = eventHistoryView;
	}
}
