package com.yas.talentshowvotingapp.model;

import java.util.ArrayList;
import java.util.List;

public final class Participant {

	private String eventId;
	private String itemId;
	private String participantId;
	private String participantName;
	private String refNo;
	private String groupName;
	private int voteCount;

	private List<Vote> votes = new ArrayList<Vote>();

	public Participant(String participantId, String participantName, String refNo, String groupName, int voteCount,
			List<Vote> votes) {
		super();
		this.participantId = participantId;
		this.participantName = participantName;
		this.refNo = refNo;
		this.groupName = groupName;
		this.voteCount = voteCount;
		this.votes = votes;
	}

	public Participant(String participantId, String participantName, String refNo, String groupName) {
		super();

		this.participantId = participantId;
		this.participantName = participantName;
		this.refNo = refNo;
		this.groupName = groupName;

	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getParticipantId() {
		return participantId;
	}

	public void setParticipantId(String participantId) {
		this.participantId = participantId;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

}
