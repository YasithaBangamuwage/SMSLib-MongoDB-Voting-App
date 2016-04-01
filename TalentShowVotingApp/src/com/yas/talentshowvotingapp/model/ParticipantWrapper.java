package com.yas.talentshowvotingapp.model;

public class ParticipantWrapper {

	private Vote vote;
	private Participant UpdatedParticipant;

	public ParticipantWrapper(Vote vote, Participant updatedParticipant) {
		super();
		this.vote = vote;
		UpdatedParticipant = updatedParticipant;
	}

	public Vote getVote() {
		return vote;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}

	public Participant getUpdatedParticipant() {
		return UpdatedParticipant;
	}

	public void setUpdatedParticipant(Participant updatedParticipant) {
		UpdatedParticipant = updatedParticipant;
	}

}
