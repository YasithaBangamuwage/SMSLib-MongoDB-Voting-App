package com.yas.talentshowvotingapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.yas.talentshowvotingapp.dao.DataManager;
import com.yas.talentshowvotingapp.model.Item;
import com.yas.talentshowvotingapp.model.Participant;
import com.yas.talentshowvotingapp.other.AppStatus;
import com.yas.talentshowvotingapp.service.VotingAppService;
import com.yas.talentshowvotingapp.view.ItemView;

public class ItemController {

	private List<Item> items = new ArrayList<Item>();

	private VotingAppService votingAppService = new DataManager();
	private ItemView itemView;

	public ItemView getItemView() {
		return itemView;
	}

	public void setItemView(ItemView itemView) {
		this.itemView = itemView;
	}

	public ItemController(ItemView itemView) {
		super();
		this.itemView = itemView;
	}

	public void addItem(Item item) {

		if (!isItemAllreadyExsits(item)) {

			// add item
			votingAppService.addItem(AppController.getAppController().getEventController().getEvent(), item);

			// set updated active event into appController.
			// load all items relevant to active event.
			items.clear();
			items.addAll(AppController.getAppController().getEventController().getLatestActiveEvent().getItems());
		}
	}

	public void updateItem(Item item) {

		
		votingAppService.UpdateItem(AppController.getAppController().getEventController().getEvent().getEventId(),
				item);
		// set updated active event into appController.
		// load all items relevant to active event.
		items.clear();
		items.addAll(AppController.getAppController().getEventController().getLatestActiveEvent().getItems());
		
	}

	public boolean isItemAllreadyExsits(Item newItem) {

		for (Item item : getItems()) {
			if (item.getName().equals(newItem.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean ccc(Item newItem) {

		for (Item item : getItems()) {
			if (item.getName().equals(newItem.getName()) && item.getItemId().equals(newItem.getItemId())) {
				
				return true;
			}
		}
		return false;
	}

	public Boolean deleteItem(final String itemId) {

		if (AppController.getAppController().getAppStatus().equals(AppStatus.EVENT_CREATING)) {

			votingAppService.deleteItem(AppController.getAppController().getEventController().getEvent().getEventId(),
					itemId);
			// set updated active event into appController.
			// load all items relevant to active event.
			items.clear();
			items.addAll(AppController.getAppController().getEventController().getLatestActiveEvent().getItems());
			return true;

		} else {
			// if any participants are in item
			// can not delete
			if (isParticipantsAvailable(itemId)) {
				return false;
			} else {
				votingAppService.deleteItem(
						AppController.getAppController().getEventController().getEvent().getEventId(), itemId);
				// set updated active event into appController.
				// load all items relevant to active event.
				items.clear();
				items.addAll(AppController.getAppController().getEventController().getLatestActiveEvent().getItems());
				return true;
			}
		}

	}

	private boolean isParticipantsAvailable(String itemId) {
		for (Item item : items) {
			if (item.getItemId().equals(itemId) && item.getParticipants().size() > 0) {
				return true;
			}
		}
		return false;
	}


	public VotingAppService getVotingAppService() {
		return votingAppService;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void setVotingAppService(VotingAppService votingAppService) {
		this.votingAppService = votingAppService;
	}

	/*
	 * public Item findItem(final int itemId) {
	 * 
	 * for (Item item : items) { if (item.getItemId() == itemId) { return item;
	 * } } return null; }
	 */
}
