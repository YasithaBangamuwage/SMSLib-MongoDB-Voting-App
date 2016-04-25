package com.yas.talentshowvotingapp.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.yas.talentshowvotingapp.dao.DataManager;
import com.yas.talentshowvotingapp.model.Event;
import com.yas.talentshowvotingapp.model.Item;
import com.yas.talentshowvotingapp.model.Participant;
import com.yas.talentshowvotingapp.service.VotingAppService;
import com.yas.talentshowvotingapp.view.ParticipantView;

public class ParticipantContoller {

	private List<Participant> participantList = new ArrayList<Participant>();
	private VotingAppService votingAppService = new DataManager();
	private ParticipantView participantView;

	public ParticipantContoller(ParticipantView participantView) {
		super();
		this.participantView = participantView;
	}

	public List<Participant> getParticipantList() {
		return participantList;
	}

	public void setParticipantList(List<Participant> participantList) {
		this.participantList = participantList;
	}

	public VotingAppService getVotingAppService() {
		return votingAppService;
	}

	public void setVotingAppService(VotingAppService votingAppService) {
		this.votingAppService = votingAppService;
	}

	public ParticipantView getParticipantView() {
		return participantView;
	}

	public void setParticipantView(ParticipantView participantView) {
		this.participantView = participantView;
	}

	public void addParticipant(final String itemId, Participant participant) {

		// if (isRefNoIsExsits(participant)) {
		// update participant eventid and itemid
		participant.setEventId(AppController.getAppController().getEventController().getEvent().getEventId());
		participant.setItemId(itemId);

		// add participant into db
		votingAppService.addParticipant(participant);

		this.participantList.clear();
		this.participantList = votingAppService
				.getEventParticipants(AppController.getAppController().getEventController().getEvent().getEventId());

		// update with latest event data

		updateActiveEventWithParticipants(getParticipantList(),
				AppController.getAppController().getEventController().getLatestActiveEvent());
		// }

	}

	public void updateParticipant(final String itemId, Participant participant) {

		participant.setItemId(itemId);

		votingAppService.updateParticipant(participant);

		// update with latest event data

		this.participantList.clear();
		this.participantList = votingAppService
				.getEventParticipants(AppController.getAppController().getEventController().getEvent().getEventId());

		// update with latest event data

		updateActiveEventWithParticipants(getParticipantList(),
				AppController.getAppController().getEventController().getLatestActiveEvent());

	}

	public void updateActiveEventWithParticipants(final List<Participant> participants, final Event event) {

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
		AppController.getAppController().getEventController().getEvent().getItems().clear();

		AppController.getAppController().getEventController().getEvent().setItems(itemsWithParticipants);
	}

	public boolean isRefNoIsExsits(Participant newParticipant) {

		for (Participant participant : getParticipantList()) {
			if (participant.getRefNo().equals(newParticipant.getRefNo())) {
				return true;
			}
		}
		return false;
	}

}
