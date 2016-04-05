package com.yas.talentshowvotingapp.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.yas.talentshowvotingapp.controller.AppController;
import com.yas.talentshowvotingapp.model.Event;
import com.yas.talentshowvotingapp.model.Item;
import com.yas.talentshowvotingapp.model.Participant;
import com.yas.talentshowvotingapp.other.AppStatus;

public class AppDashboardView extends JFrame {

	private JPanel contentPane;

	JButton btnStartVoting;
	JButton btnStop;
	JButton btnAddParticipants;
	// VoteCounter v = new VoteCounter();
	int x = 0;
	private JPanel panel_1;

	JPanel panel;
	private JPanel tableContentPanel;
	private JScrollPane scrollPane_1;
	

	/**
	 * Create the frame.
	 */
	public AppDashboardView() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 578, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		 panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblDashBoard = new JLabel("Dash Board");
		lblDashBoard.setBackground(Color.MAGENTA);
		GridBagConstraints gbc_lblDashBoard = new GridBagConstraints();
		gbc_lblDashBoard.insets = new Insets(0, 0, 5, 5);
		gbc_lblDashBoard.gridx = 0;
		gbc_lblDashBoard.gridy = 0;
		panel_1.add(lblDashBoard, gbc_lblDashBoard);

		btnStartVoting = new JButton("Start Voting");
		GridBagConstraints gbc_btnStartVoting = new GridBagConstraints();
		gbc_btnStartVoting.insets = new Insets(0, 0, 5, 5);
		gbc_btnStartVoting.gridx = 1;
		gbc_btnStartVoting.gridy = 1;
		panel_1.add(btnStartVoting, gbc_btnStartVoting);

		btnStartVoting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				
				
				
				

				if (!AppController.getAppController().getAppStatus().equals(AppStatus.EVENT_ONGOING)) {
					AppController.getAppController().setAppStatus(AppStatus.EVENT_ONGOING);
				}

				AppController.getAppController().getDashBoardController().refreshDashBoard();
				
				SwingUtilities.invokeLater(new Runnable() {
	                @Override
	                public void run() {
	                	AppController.getAppController().getDashBoardController().getAppDashboardView().validate();
	                	AppController.getAppController().getDashBoardController().getAppDashboardView().repaint();
	                	//AppController.getAppController().getDashBoardController().getAppDashboardView().pack();
	                	
	                }
	            });

			}
		});

		btnStop = new JButton("Stop");
		GridBagConstraints gbc_btnStop = new GridBagConstraints();
		gbc_btnStop.insets = new Insets(0, 0, 5, 5);
		gbc_btnStop.gridx = 2;
		gbc_btnStop.gridy = 1;
		panel_1.add(btnStop, gbc_btnStop);

		btnAddParticipants = new JButton("Add Participants");

		GridBagConstraints gbc_btnAddParticipants = new GridBagConstraints();
		gbc_btnAddParticipants.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddParticipants.gridx = 3;
		gbc_btnAddParticipants.gridy = 1;
		panel_1.add(btnAddParticipants, gbc_btnAddParticipants);
		
		scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setPreferredSize(new Dimension(300, 100));
		scrollPane_1.setMinimumSize(new Dimension(300, 100));
		scrollPane_1.setMaximumSize(new Dimension(300, 100));
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		tableContentPanel = new JPanel();
		
		
		tableContentPanel.setPreferredSize(new Dimension(600, 400));
		tableContentPanel.setMinimumSize(new Dimension(600, 400));
		tableContentPanel.setMaximumSize(new Dimension(600, 400));
		
		scrollPane_1.setColumnHeaderView(tableContentPanel);
		GridBagLayout gbl_tableContentPanel = new GridBagLayout();
		gbl_tableContentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_tableContentPanel.rowHeights = new int[]{0, 0};
		gbl_tableContentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_tableContentPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		tableContentPanel.setLayout(gbl_tableContentPanel);
		
		

		btnAddParticipants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AppController.getAppController().getParticipantContoller().getParticipantView().getBtnNext()
						.setVisible(Boolean.FALSE);
				AppController.getAppController().getParticipantContoller().getParticipantView()
						.setVisible(Boolean.TRUE);
			}
		});

		/****************** events goes here *********************/

	}

	public void refreshView() {

		Event event = AppController.getAppController().getEventController().getEvent();
		// remove all table data
		 tableContentPanel.removeAll();

		int gridy =0;
		// loop each item
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
				
				JLabel itemName = new JLabel();
				itemName.setText(item.getName());

				JTable table = new JTable();
				table.setModel(tbleModel);
				
				JScrollPane scrollPane =new JScrollPane();  
				scrollPane.add(table);
				scrollPane.setViewportView(table);
				
				
				JPanel panel = new JPanel();
				panel.setLayout(new GridBagLayout());
				
				GridBagConstraints gbcPanel1 = new GridBagConstraints();
				gbcPanel1.insets = new Insets(0, 0, 5, 5);
				gbcPanel1.gridx = 0;
				gbcPanel1.gridy = 0;
				//gbcPanel1.fill = GridBagConstraints.BOTH;
				panel.add(itemName, gbcPanel1);
				
				
				GridBagConstraints gbcPanel2 = new GridBagConstraints();
				gbcPanel2.insets = new Insets(0, 0, 5, 5);
				gbcPanel2.gridx = 0;
				gbcPanel2.gridy = 1;
				//gbcPanel2.fill = GridBagConstraints.BOTH;
				panel.add(scrollPane, gbcPanel2);
				
				//panel.add(itemName);
				//panel.add(scrollPane);
				
				
				GridBagConstraints gbcPanel = new GridBagConstraints();
				gbcPanel.insets = new Insets(0, 0, 5, 5);
				gbcPanel.gridx = 0;
				gbcPanel.gridy = gridy;
				//gbcPanel.fill = GridBagConstraints.BOTH;
				tableContentPanel.add(panel, gbcPanel);
				
				
				

			}
			gridy++;
		}
		
		

	}

}
