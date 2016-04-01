package com.yas.talentshowvotingapp.controller;

import com.yas.talentshowvotingapp.other.AppStatus;
import com.yas.talentshowvotingapp.view.AppDashboardView;
import com.yas.talentshowvotingapp.view.EventView;
import com.yas.talentshowvotingapp.view.ItemView;
import com.yas.talentshowvotingapp.view.ParticipantView;

public class AppController {

	public static AppController instance;
	private AppMainWindowController appMainWindowController;
	private AppDashboardView appDashboardView;
	private EventController eventController;
	private ItemController itemController;
	private ParticipantContoller participantContoller;
	private DashBoardController dashBoardController;
	private AppStatus appStatus;

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

	public AppDashboardView getAppDashboardView() {
		if (appDashboardView == null) {
			appDashboardView = new AppDashboardView();
			return appDashboardView;

		}
		return appDashboardView;
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

		if (!this.appStatus.equals(AppStatus.EVENT_CREATING)) {
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

	public DashBoardController getDashBoardController() {
		if (dashBoardController == null) {
			dashBoardController = new DashBoardController(new AppDashboardView());
			return dashBoardController;

		}

		return dashBoardController;
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

	}

	public AppStatus getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(AppStatus appStatus) {
		this.appStatus = appStatus;
	}

}
