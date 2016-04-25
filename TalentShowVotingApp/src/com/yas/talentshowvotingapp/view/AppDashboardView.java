package com.yas.talentshowvotingapp.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import org.smslib.SMSLibException;

import com.yas.talentshowvotingapp.controller.AppController;
import com.yas.talentshowvotingapp.model.Event;
import com.yas.talentshowvotingapp.model.Item;
import com.yas.talentshowvotingapp.model.Participant;
import com.yas.talentshowvotingapp.other.AppStatus;
import java.awt.Font;

public class AppDashboardView extends JFrame {

	private JPanel itemsDataPanel;
	private JScrollPane itemsScrollPane;
	private JPanel controllPanel = new JPanel();
	private JButton btnFinish;
	private JButton btnAddParticipants;
	private JButton btnSyncVotes;

	/**
	 * Create the frame.
	 */
	public AppDashboardView() {
		getContentPane().setBackground(new Color(255, 255, 255));
		initComponents();

	}

	private void initComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(600, 450));

		itemsDataPanel = new JPanel();
		itemsDataPanel.setLayout(new GridBagLayout());
		itemsDataPanel.setBackground(new Color(102, 153, 255));
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
		controllPanel.setBackground(new Color(255, 255, 255));
		getContentPane().add(controllPanel, gbcControllPanel);
		GridBagLayout gbl_controllPanel = new GridBagLayout();
		gbl_controllPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_controllPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_controllPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_controllPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		controllPanel.setLayout(gbl_controllPanel);

		JLabel lblDashboard = new JLabel("DashBoard");
		lblDashboard.setForeground(new Color(255, 0, 51));
		lblDashboard.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 19));
		GridBagConstraints gbc_lblDashboard = new GridBagConstraints();
		gbc_lblDashboard.insets = new Insets(0, 0, 5, 7);
		gbc_lblDashboard.gridx = 0;
		gbc_lblDashboard.gridy = 0;
		controllPanel.add(lblDashboard, gbc_lblDashboard);

		btnSyncVotes = new JButton("Sync Votes");
		btnSyncVotes.setForeground(new Color(0, 51, 51));
		btnSyncVotes.setBackground(new Color(255, 255, 255));
		btnSyncVotes.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));

		GridBagConstraints gbc_btnSyncVotes = new GridBagConstraints();
		gbc_btnSyncVotes.insets = new Insets(0, 0, 0, 5);
		gbc_btnSyncVotes.gridx = 0;
		gbc_btnSyncVotes.gridy = 1;
		controllPanel.add(btnSyncVotes, gbc_btnSyncVotes);

		btnAddParticipants = new JButton("Add Participants");
		btnAddParticipants.setForeground(new Color(0, 51, 51));
		btnAddParticipants.setBackground(new Color(255, 255, 255));
		btnAddParticipants.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));

		GridBagConstraints gbc_btnAddParticipants = new GridBagConstraints();
		gbc_btnAddParticipants.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddParticipants.gridx = 1;
		gbc_btnAddParticipants.gridy = 1;
		controllPanel.add(btnAddParticipants, gbc_btnAddParticipants);

		btnFinish = new JButton("Finish");
		btnFinish.setForeground(new Color(0, 51, 51));
		btnFinish.setBackground(new Color(255, 255, 255));
		btnFinish.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));

		GridBagConstraints gbc_btnFinish = new GridBagConstraints();
		gbc_btnFinish.gridx = 2;
		gbc_btnFinish.gridy = 1;
		controllPanel.add(btnFinish, gbc_btnFinish);

		/******************** events goes here *********************/

		btnSyncVotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				btnSyncVotes.setEnabled(Boolean.FALSE);
				if (!AppController.getAppController().getAppStatus().equals(AppStatus.EVENT_ONGOING)) {
					AppController.getAppController().setAppStatus(AppStatus.EVENT_ONGOING);
				}

				AppController.getAppController().getDashBoardController().refreshDashBoard();

				AppController.getAppController().getDashBoardController().getAppDashboardView().validate();
				AppController.getAppController().getDashBoardController().getAppDashboardView().repaint();
				btnSyncVotes.setEnabled(Boolean.TRUE);
			}
		});

		btnAddParticipants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppController.getAppController().getParticipantContoller().getParticipantView().getBtnNext()
						.setVisible(Boolean.FALSE);
				AppController.getAppController().getParticipantContoller().getParticipantView()
						.setVisible(Boolean.TRUE);
			}
		});

		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you wants finish the event?",
						"Warning", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					AppController.getAppController().setAppStatus(AppStatus.DEFAULT);
					AppController.getAppController().getDashBoardController().getAppDashboardView()
							.setVisible(Boolean.FALSE);
					//AppController.getAppController().getEventController().setEventEndDate(new Date());
					try {
						AppController.getAppController().getDashBoardController().getVoteCounter().getService().stopService();
					} catch (SMSLibException | IOException | InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					AppController.getAppController().setAppToDefaultMode();

				}

			}
		});
	}

	public void refreshItemScrollPane() {

		Event event = AppController.getAppController().getEventController().getEvent();
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
