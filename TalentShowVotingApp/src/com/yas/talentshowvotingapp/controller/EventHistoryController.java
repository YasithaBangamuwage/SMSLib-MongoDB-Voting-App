package com.yas.talentshowvotingapp.controller;

import com.yas.talentshowvotingapp.dao.DataManager;
import com.yas.talentshowvotingapp.service.VotingAppService;
import com.yas.talentshowvotingapp.view.EventHistoryView;

public class EventHistoryController {

	private VotingAppService votingAppService = new DataManager();
	private EventHistoryView eventHistoryView;

	public EventHistoryController(EventHistoryView eventHistoryView) {
		super();
		this.eventHistoryView = eventHistoryView;
	}

	public EventHistoryView getEventHistoryView() {
		return eventHistoryView;
	}

	public void setEventHistoryView(EventHistoryView eventHistoryView) {
		this.eventHistoryView = eventHistoryView;
	}
}
