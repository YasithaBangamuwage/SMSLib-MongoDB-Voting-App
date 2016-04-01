package com.yas.talentshowvotingapp.service;

import java.util.List;

import com.yas.talentshowvotingapp.model.Event;
import com.yas.talentshowvotingapp.model.Item;
import com.yas.talentshowvotingapp.model.Participant;
import com.yas.talentshowvotingapp.model.ParticipantWrapper;
import com.yas.talentshowvotingapp.model.Vote;

public interface VotingAppService {

	void addEvent(final Event event);

	Event getLatestActiveEvent();

	void addItem(final Event event, final Item item);

	void UpdateItem(final String eventId, final Item item);

	void deleteItem(String eventId, final String itemId);

	void setEventActiveMode(String eventId, boolean isActive);
	
	void addParticipant( Participant participant);
	
	List<Participant> getEventParticipants(final String eventId);
	
	void updateParticipant( Participant participant);
	
	void addVoteToParticipant(final List<ParticipantWrapper> participantWrapperList);
	
	

	
	
}
