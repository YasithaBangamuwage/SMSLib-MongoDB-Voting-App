package com.yas.talentshowvotingapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.smslib.InboundMessage;

import com.yas.talentshowvotingapp.dao.DataManager;
import com.yas.talentshowvotingapp.model.Event;
import com.yas.talentshowvotingapp.model.Participant;
import com.yas.talentshowvotingapp.model.ParticipantWrapper;
import com.yas.talentshowvotingapp.model.Vote;
import com.yas.talentshowvotingapp.service.VoteCounter;
import com.yas.talentshowvotingapp.service.VotingAppService;
import com.yas.talentshowvotingapp.view.AppDashboardView;

public class DashBoardController {

	private VotingAppService votingAppService = new DataManager();
	private AppDashboardView appDashboardView;
	private VoteCounter voteCounter;

	public VoteCounter getVoteCounter() {

		if (voteCounter == null) {
			voteCounter = new VoteCounter();
		}
		return voteCounter;
	}

	public void setVoteCounter(VoteCounter voteCounter) {
		this.voteCounter = voteCounter;
	}

	public DashBoardController(AppDashboardView appDashboardView) {
		super();
		this.appDashboardView = appDashboardView;
	}

	public VotingAppService getVotingAppService() {
		return votingAppService;
	}

	public void setVotingAppService(VotingAppService votingAppService) {
		this.votingAppService = votingAppService;
	}

	public AppDashboardView getAppDashboardView() {
		return appDashboardView;
	}

	public void setAppDashboardView(AppDashboardView appDashboardView) {
		this.appDashboardView = appDashboardView;
	}

	public void managingVotes() {
		// current event
		Event event = AppController.getAppController().getEventController().getEvent();

		List<Participant> participants = votingAppService.getEventParticipants(event.getEventId());

		List<ParticipantWrapper> participantWrapperList = new ArrayList<ParticipantWrapper>();

		List<InboundMessage> msgList = getVoteCounter().readVoteMessages();

		boolean isParticipantFound = false;

		for (InboundMessage inboundMessage : msgList) {

			isParticipantFound = false;

			if (isInt(inboundMessage.getText())) {

				for (Participant participant : participants) {

					// participant have the vote
					if (participant.getRefNo().equals(inboundMessage.getText())) {

						boolean alreadyVoted = Boolean.FALSE;

						for (Vote vote : participant.getVotes()) {

							if (vote.getSenderNumber().equals(inboundMessage.getOriginator())) {
								alreadyVoted = Boolean.TRUE;
								break;
							}
						}

						for (ParticipantWrapper wrapper : participantWrapperList) {

							if (wrapper.getUpdatedParticipant().getParticipantId()
									.equals(participant.getParticipantId())
									&& wrapper.getVote().getSenderNumber().equals(inboundMessage.getOriginator())) {
								alreadyVoted = Boolean.TRUE;
								break;
							}
						}

						if (!alreadyVoted) {

							isParticipantFound = true;

							participant.setVoteCount(participant.getVoteCount() + 1);

							// set participantWrapperList
							Vote vote = new Vote(inboundMessage.getDate(), inboundMessage.getOriginator(),
									inboundMessage.getText());

							participantWrapperList.add(new ParticipantWrapper(vote, participant));

							// delete msg from sim inbox
							getVoteCounter().deleteMessage(inboundMessage);

						} else {
							getVoteCounter().deleteMessage(inboundMessage);
						}

					}

					if (isParticipantFound) {
						break;
					}
				}
			} else {
				// unwanted msg
				getVoteCounter().deleteMessage(inboundMessage);
			}

		}

		// add updated vote details into database
		votingAppService.addVoteToParticipant(participantWrapperList);

		// get updated event data into client
		AppController.getAppController().getParticipantContoller().updateActiveEventWithParticipants(
				votingAppService.getEventParticipants(
						AppController.getAppController().getEventController().getEvent().getEventId()),
				AppController.getAppController().getEventController().getLatestActiveEvent());

		/*****************
		 * need to sort participants according to the vote count
		 *****************/

	}

	public void refreshDashBoard() {

		// manage votes if event ongoing
		managingVotes();
		// update view with latest event data
		getAppDashboardView().refreshItemScrollPane();

	}

	private boolean isInt(String s) {
		try {
			int i = Integer.parseInt(s);
			return true;
		}

		catch (NumberFormatException er) {
			return false;
		}
	}
}
