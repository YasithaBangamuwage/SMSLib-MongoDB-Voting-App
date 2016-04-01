package com.yas.talentshowvotingapp.model;

import java.util.List;

public final class Item {

	private String itemId;
	private String itemInfo;
	private String name;
	private boolean isGroup;
	private List<Participant> participants;



	public Item(String itemId, String itemInfo, String name, boolean isGroup, List<Participant> participants) {
		super();
		this.itemId = itemId;
		this.itemInfo = itemInfo;
		this.name = name;
		this.isGroup = isGroup;
		this.participants = participants;
	}

	public Item(String itemId, String itemInfo, String name, boolean isGroup) {
		super();
		this.itemId = itemId;
		this.itemInfo = itemInfo;
		this.name = name;
		this.isGroup = isGroup;
	}

	public boolean isGroup() {
		return isGroup;
	}

	public void setGroup(boolean isGroup) {
		this.isGroup = isGroup;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

}
