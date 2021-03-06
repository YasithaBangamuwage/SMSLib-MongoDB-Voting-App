package com.yas.talentshowvotingapp.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.yas.talentshowvotingapp.model.Event;
import com.yas.talentshowvotingapp.model.Item;
import com.yas.talentshowvotingapp.model.Participant;
import com.yas.talentshowvotingapp.model.ParticipantWrapper;
import com.yas.talentshowvotingapp.service.VotingAppService;

public class DataManager implements VotingAppService {

	final static Logger logger = Logger.getLogger(DataManager.class);

	@Override
	public void addEvent(Event event) {
		// add event to db
		DB userDB = MongoDBManager.getInstance();
		DBCollection dbCol = userDB.getCollection("event");
		Gson gson = new Gson();
		BasicDBObject obj = (BasicDBObject) JSON.parse(gson.toJson(event));
		dbCol.insert(obj);
		logger.info("Added event : " + event.getName());
	}

	@Override
	public Event getLatestActiveEvent() {

		DB userDB = MongoDBManager.getInstance();
		DBCollection dbCol = userDB.getCollection("event");

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("isActive", Boolean.TRUE);

		DBObject dbobj = dbCol.findOne(searchQuery);
		Event event = (new Gson()).fromJson(dbobj.toString(), Event.class);
		logger.info("getLatestActiveEvent : " + event.getName());
		return event;
	}

	@Override
	public void setEventActiveMode(String eventId, boolean isActive) {

		DB userDB = MongoDBManager.getInstance();
		DBCollection dbCol = userDB.getCollection("event");

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("eventId", eventId);
		BasicDBObject updateCommand = new BasicDBObject("$set", new BasicDBObject("isActive", isActive));

		dbCol.update(searchQuery, updateCommand);
		logger.info("setEventActiveMode : " + eventId + " - " + isActive);
	}

	@Override
	public void addItem(Event event, Item item) {

		DB userDB = MongoDBManager.getInstance();
		DBCollection dbCol = userDB.getCollection("event");

		Gson gson = new Gson();

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("eventId", event.getEventId());
		BasicDBObject newItem = (BasicDBObject) JSON.parse(gson.toJson(item));
		BasicDBObject updateCommand = new BasicDBObject("$push", new BasicDBObject("items", newItem));
		dbCol.update(searchQuery, updateCommand);

		logger.info("addItem : " + event.getEventId() + " - " + newItem.toString());

	}

	@Override
	public void UpdateItem(String eventId, Item item) {

		DB userDB = MongoDBManager.getInstance();
		DBCollection dbCol = userDB.getCollection("event");

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("eventId", eventId);
		searchQuery.put("items.itemId", item.getItemId());

		BasicDBObject updatedData = new BasicDBObject();
		updatedData.put("items.$.itemInfo", item.getItemInfo());
		updatedData.put("items.$.name", item.getName());
		updatedData.put("items.$.isGroup", item.isGroup());

		BasicDBObject updateCommand = new BasicDBObject("$set", updatedData);

		dbCol.update(searchQuery, updateCommand);

		logger.info("UpdateItem : " + eventId + " - " + updatedData);

	}

	@Override
	public void deleteItem(String eventId, String itemId) {

		DB userDB = MongoDBManager.getInstance();
		DBCollection dbCol = userDB.getCollection("event");

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("eventId", eventId);

		BasicDBObject deletingItem = new BasicDBObject();
		deletingItem.put("itemId", itemId);

		BasicDBObject updateCommand = new BasicDBObject();
		updateCommand.put("$pull", new BasicDBObject("items", deletingItem));

		dbCol.update(searchQuery, updateCommand);

		logger.info("deleteItem : " + eventId + " - " + updateCommand);
	}

	@Override
	public void addParticipant(Participant participant) {

		DB userDB = MongoDBManager.getInstance();
		DBCollection dbCol = userDB.getCollection("participants");
		Gson gson = new Gson();
		BasicDBObject obj = (BasicDBObject) JSON.parse(gson.toJson(participant));
		dbCol.insert(obj);

		logger.info("addParticipant : " + obj);
	}

	@Override
	public List<Participant> getEventParticipants(String eventId) {

		List<Participant> participants = new ArrayList<Participant>();
		DB userDB = MongoDBManager.getInstance();
		DBCollection dbCol = userDB.getCollection("participants");

		BasicDBObject match = new BasicDBObject();
		match.put("eventId", eventId);
		DBCursor cursor = dbCol.find(match);

		logger.info("getEventParticipants : " + eventId + " - " + match);

		DBObject participant = null;

		while (cursor.hasNext()) {
			participant = (BasicDBObject) cursor.next();

			participants.add((new Gson()).fromJson(participant.toString(), Participant.class));

		}
		Collections.sort(participants);
		return participants;

	}

	@Override
	public void updateParticipant(Participant participant) {

		DB userDB = MongoDBManager.getInstance();
		DBCollection dbCol = userDB.getCollection("participants");

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("participantId", participant.getParticipantId());

		BasicDBObject updatedData = new BasicDBObject();
		updatedData.put("participantName", participant.getParticipantName());
		updatedData.put("refNo", participant.getRefNo());
		updatedData.put("groupName", participant.getGroupName());
		updatedData.put("itemId", participant.getItemId());

		BasicDBObject updateCommand = new BasicDBObject("$set", updatedData);

		dbCol.update(searchQuery, updateCommand);

		logger.info("updateParticipant : " + updatedData);

	}

	@Override
	public void addVoteToParticipant(List<ParticipantWrapper> participantWrapperList) {

		for (ParticipantWrapper participantWrapper : participantWrapperList) {

			DB userDB = MongoDBManager.getInstance();
			DBCollection dbCol = userDB.getCollection("participants");

			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("participantId", participantWrapper.getUpdatedParticipant().getParticipantId());

			BasicDBObject updatedData = new BasicDBObject();
			updatedData.put("voteCount", participantWrapper.getUpdatedParticipant().getVoteCount());

			BasicDBObject updateCommand = new BasicDBObject("$set", updatedData);

			dbCol.update(searchQuery, updateCommand);
			logger.info("addVoteToParticipant : " + searchQuery + " - " + updateCommand);

			Gson gson = new Gson();

			BasicDBObject newVote = (BasicDBObject) JSON.parse(gson.toJson(participantWrapper.getVote()));
			BasicDBObject updateCommand2 = new BasicDBObject("$push", new BasicDBObject("votes", newVote));
			dbCol.update(searchQuery, updateCommand2);
			logger.info("addVoteToParticipant : " + searchQuery + " - " + updateCommand);

		}

	}

	/*
	 * @Override public void setEventEndDate(String eventId, Date endDate) { DB
	 * userDB = MongoDBManager.getInstance(); DBCollection dbCol =
	 * userDB.getCollection("event");
	 * 
	 * BasicDBObject searchQuery = new BasicDBObject();
	 * searchQuery.put("eventId", eventId); BasicDBObject updateCommand = new
	 * BasicDBObject("$set", new BasicDBObject("endTime", endDate));
	 * 
	 * dbCol.update(searchQuery, updateCommand); logger.info(
	 * "setEventEndDate : " + searchQuery + " - " + updateCommand); }
	 */

	@Override
	public Event getEvent(String eventId) {

		DB userDB = MongoDBManager.getInstance();
		DBCollection dbCol = userDB.getCollection("event");

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("eventId", eventId);

		DBObject dbobj = dbCol.findOne(searchQuery);

		logger.info("getEvent : " + eventId + " - " + dbobj);
		return (new Gson()).fromJson(dbobj.toString(), Event.class);
	}

	@Override
	public List<Event> getAllEvents() {

		List<Event> events = new ArrayList<Event>();
		DB userDB = MongoDBManager.getInstance();
		DBCollection dbCol = userDB.getCollection("event");

		DBCursor cursor = dbCol.find();
		logger.info("getAllEvents : " + cursor.size());

		while (cursor.hasNext()) {

			events.add((new Gson()).fromJson(cursor.next().toString(), Event.class));

		}

		return events;
	}

	@Override
	public void setIsActiveFalseForEvents() {

		for (Event event : getAllEvents()) {
			setEventActiveMode(event.getEventId(), Boolean.FALSE);
		}
	}

	@Override
	public void setAsActiveEvent(String eventId) {
		setEventActiveMode(eventId, Boolean.TRUE);
		
	}

}
