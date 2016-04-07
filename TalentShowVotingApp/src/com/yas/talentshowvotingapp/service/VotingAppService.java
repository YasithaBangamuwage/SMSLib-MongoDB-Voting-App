package com.yas.talentshowvotingapp.service;

import java.util.Date;
import java.util.List;

import com.yas.talentshowvotingapp.model.Event;
import com.yas.talentshowvotingapp.model.Item;
import com.yas.talentshowvotingapp.model.Participant;
import com.yas.talentshowvotingapp.model.ParticipantWrapper;

public interface VotingAppService {

	void addEvent(final Event event);

	Event getLatestActiveEvent();

	void addItem(final Event event, final Item item);

	void UpdateItem(final String eventId, final Item item);

	void deleteItem(String eventId, final String itemId);

	void setEventActiveMode(String eventId, boolean isActive);
	
	void addParticipant( Participant participant);
	
	List<Participant> getEventParticipants(final String eventId);
	
	void updateParticipant( final Participant participant);
	
	void addVoteToParticipant(final List<ParticipantWrapper> participantWrapperList);
	
	void setEventEndDate(final String eventId, final Date endDate);

	Event getEvent(final String eventId);
	
	List<Event> getAllEvents();
	
}
