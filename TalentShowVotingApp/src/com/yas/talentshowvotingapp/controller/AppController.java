package com.yas.talentshowvotingapp.controller;

import com.yas.talentshowvotingapp.other.AppStatus;
import com.yas.talentshowvotingapp.service.VotingAppService;
import com.yas.talentshowvotingapp.view.AppDashboardView;
import com.yas.talentshowvotingapp.view.ConfigurationView;
import com.yas.talentshowvotingapp.view.EventHistoryView;
import com.yas.talentshowvotingapp.view.EventView;
import com.yas.talentshowvotingapp.view.ItemView;
import com.yas.talentshowvotingapp.view.ParticipantView;

public class AppController {

	public static AppController instance;
	private AppMainWindowController appMainWindowController;
	private EventController eventController;
	private ItemController itemController;
	private ParticipantContoller participantContoller;
	private DashBoardController dashBoardController;
	private AppStatus appStatus;
	private EventHistoryController eventHistoryController;
	private ConfigurationController configurationController;

	private AppController() {
	}

	public static AppController getAppController() {
		if (instance == null) {
			instance = new AppController();
			return instance;

		}
		return instance;
	}

	public AppMainWindowController getAppMainWindowController() {
		if (appMainWindowController == null) {
			appMainWindowController = new AppMainWindowController();
			return appMainWindowController;

		}
		return appMainWindowController;
	}

	public EventController getEventController() {
		if (eventController == null) {
			eventController = new EventController(new EventView());
			return eventController;

		}
		return eventController;
	}

	public ItemController getItemController() {
		if (itemController == null) {
			itemController = new ItemController(new ItemView());
			return itemController;

		}

		if (this.appStatus.equals(AppStatus.EVENT_CREATED) || this.appStatus.equals(AppStatus.EVENT_ONGOING)) {
			// display relevant items into item view table.
			itemController.getItemView()
					.updateItemTable(AppController.getAppController().getItemController().getItems());

		}

		return itemController;
	}

	public ParticipantContoller getParticipantContoller() {
		if (participantContoller == null) {
			participantContoller = new ParticipantContoller(new ParticipantView());
			return participantContoller;

		}

		return participantContoller;
	}

	public EventHistoryController getEventHistoryController() {
		if (eventHistoryController == null) {
			eventHistoryController = new EventHistoryController(new EventHistoryView());
			return eventHistoryController;
		}

		return eventHistoryController;
	}

	public DashBoardController getDashBoardController() {
		if (dashBoardController == null) {
			dashBoardController = new DashBoardController(new AppDashboardView());
			return dashBoardController;
		}

		return dashBoardController;
	}
	
	public ConfigurationController getConfigurationController() {
		if (configurationController == null) {
			configurationController = new ConfigurationController(new ConfigurationView());
			return configurationController;
		}

		return configurationController;
	}
	
	public void setAppToDefaultMode() {
		// update event object in db side to false.

		if (AppController.getAppController().getEventController().getEvent() != null) {
			getEventController().setEventActiveMode(Boolean.FALSE);
		}
		// set other controllers to null
		this.eventController = null;
		this.itemController = null;
		this.participantContoller = null;
		this.dashBoardController = null;
		this.eventHistoryController = null;

	}

	
	public AppStatus getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(AppStatus appStatus) {
		this.appStatus = appStatus;
	}

}
