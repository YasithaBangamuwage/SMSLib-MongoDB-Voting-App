package com.yas.talentshowvotingapp.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.yas.talentshowvotingapp.controller.AppController;
import com.yas.talentshowvotingapp.model.Event;
import com.yas.talentshowvotingapp.model.Item;
import com.yas.talentshowvotingapp.model.Participant;

public class EventHistoryView extends JFrame {

	private JPanel itemsDataPanel;
	private JScrollPane itemsScrollPane;
	private JPanel controllPanel = new JPanel();
	private JLabel lblEventhistory;
	private JLabel lblEvent;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { EventHistoryView frame = new
	 * EventHistoryView(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public EventHistoryView() {
		initComponents();
		addEventsIntoComboBox(AppController.getAppController().getEventController().getAvailbleEvents());
	}

	private void initComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		setMinimumSize(new Dimension(600, 450));

		itemsDataPanel = new JPanel();
		itemsDataPanel.setLayout(new GridBagLayout());
		itemsDataPanel.setBackground(Color.ORANGE);
		itemsDataPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

		itemsScrollPane = new JScrollPane(itemsDataPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		itemsScrollPane.setMinimumSize(new Dimension(160, 350));
		itemsScrollPane.setPreferredSize(new Dimension(160, 350));

		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbcItemsScrollPane = new GridBagConstraints();

		gbcItemsScrollPane.ipadx = 0;
		gbcItemsScrollPane.ipady = 0;
		gbcItemsScrollPane.insets = new Insets(0, 0, 0, 0);
		gbcItemsScrollPane.weighty = 0;
		gbcItemsScrollPane.gridheight = 1;
		gbcItemsScrollPane.gridx = 0;
		gbcItemsScrollPane.gridy = 1;
		gbcItemsScrollPane.gridwidth = 1;
		gbcItemsScrollPane.weightx = 0;
		gbcItemsScrollPane.fill = GridBagConstraints.BOTH;
		getContentPane().add(itemsScrollPane, gbcItemsScrollPane);

		GridBagConstraints gbcControllPanel = new GridBagConstraints();

		gbcControllPanel.gridx = 0;
		gbcControllPanel.gridy = 0;
		gbcControllPanel.fill = GridBagConstraints.BOTH;
		gbcControllPanel.weightx = 1;
		gbcControllPanel.weighty = 1;
		getContentPane().add(controllPanel, gbcControllPanel);
		GridBagLayout gbl_controllPanel = new GridBagLayout();
		gbl_controllPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_controllPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_controllPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_controllPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		controllPanel.setLayout(gbl_controllPanel);

		lblEventhistory = new JLabel("EventHistory");
		GridBagConstraints gbc_lblEventhistory = new GridBagConstraints();
		gbc_lblEventhistory.insets = new Insets(0, 0, 5, 5);
		gbc_lblEventhistory.gridx = 0;
		gbc_lblEventhistory.gridy = 0;
		controllPanel.add(lblEventhistory, gbc_lblEventhistory);

		lblEvent = new JLabel("Event");
		GridBagConstraints gbc_lblEvent = new GridBagConstraints();
		gbc_lblEvent.anchor = GridBagConstraints.EAST;
		gbc_lblEvent.insets = new Insets(0, 0, 0, 5);
		gbc_lblEvent.gridx = 0;
		gbc_lblEvent.gridy = 1;
		controllPanel.add(lblEvent, gbc_lblEvent);

		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		controllPanel.add(comboBox, gbc_comboBox);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboBox.getItemCount() > 0) {

					refreshItemScrollPane(((ComboBoxEventWrapper) comboBox.getSelectedItem()).getEvent().getEventId());
				}
			}
		});

	}

	public void refreshItemScrollPane(String eventId) {

		Event event = AppController.getAppController().getEventHistoryController().getSelectedHistoryEvent(eventId);

		if (event != null) {

			itemsDataPanel.removeAll();
			for (Item item : event.getItems()) {

				DefaultTableModel tbleModel = new DefaultTableModel(
						new String[] { "Participant Id", "Name", "Ref No", "Group Name", "Is group", "Vote Count" }, 0);
				tbleModel.setRowCount(0);

				if (item.getParticipants().size() > 0) {
					for (Participant participant : item.getParticipants()) {

						Object[] objs = { participant.getParticipantId(), participant.getParticipantName(),
								participant.getRefNo(), participant.getGroupName(), item.isGroup(),
								participant.getVoteCount() };
						tbleModel.addRow(objs);

					}

					JLabel lblItemName = new JLabel(item.getName());

					JTable table = new JTable();
					table.setModel(tbleModel);
					JScrollPane scrollPane = new JScrollPane(table);

					GridBagConstraints gbcitemName = new GridBagConstraints();
					gbcitemName.insets = new Insets(0, 0, 4, 4);
					gbcitemName.anchor = GridBagConstraints.FIRST_LINE_START;
					gbcitemName.weightx = 0;
					gbcitemName.weighty = 0;
					gbcitemName.gridx = 0;
					gbcitemName.gridy = GridBagConstraints.RELATIVE;
					gbcitemName.gridwidth = GridBagConstraints.REMAINDER;
					gbcitemName.gridheight = 1;
					gbcitemName.fill = GridBagConstraints.BOTH;
					itemsDataPanel.add(lblItemName, gbcitemName);

					GridBagConstraints gbcTableScrollPane = new GridBagConstraints();
					gbcTableScrollPane.insets = new Insets(0, 0, 4, 4);
					gbcTableScrollPane.anchor = GridBagConstraints.FIRST_LINE_START;
					gbcTableScrollPane.weightx = 0;
					gbcTableScrollPane.weighty = 0;
					gbcTableScrollPane.gridx = 0;
					gbcTableScrollPane.gridy = GridBagConstraints.RELATIVE;
					gbcTableScrollPane.gridwidth = GridBagConstraints.REMAINDER;
					gbcTableScrollPane.gridheight = 1;
					gbcTableScrollPane.fill = GridBagConstraints.BOTH;
					itemsDataPanel.add(scrollPane, gbcTableScrollPane);

				}

			}
		}
	}

	private void addEventsIntoComboBox(final List<Event> evevts) {

		comboBox.removeAllItems();

		for (Event event : evevts) {
			comboBox.addItem(new ComboBoxEventWrapper(event, event.getName()));
		}
		comboBox.setSelectedIndex(0);

	}

	private class ComboBoxEventWrapper {
		private Event event;

		private String text;

		public ComboBoxEventWrapper(Event event, String text) {
			super();
			this.event = event;
			this.text = text;
		}

		public Event getEvent() {
			return event;
		}

		@Override
		public String toString() {
			return text;
		}
	}

}
