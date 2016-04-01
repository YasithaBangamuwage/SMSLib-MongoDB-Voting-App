package com.yas.talentshowvotingapp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.yas.talentshowvotingapp.service.VoteCounter;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AppDashboardView extends JFrame {

	private JPanel contentPane;

	JButton btnStartVoting;
	JLabel lblVotingTimer;
	JButton btnPause;
	JButton btnStop;
	JButton btnAddNewItems;
	JButton btnAddParticipants;
	// VoteCounter v = new VoteCounter();
	int x = 0;
	private JPanel panel_1;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public AppDashboardView() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1065, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel panel = new JPanel();
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

		JLabel lblTimer = new JLabel("Timer :");
		GridBagConstraints gbc_lblTimer = new GridBagConstraints();
		gbc_lblTimer.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimer.gridx = 0;
		gbc_lblTimer.gridy = 1;
		panel_1.add(lblTimer, gbc_lblTimer);

		lblVotingTimer = new JLabel("voting timer");
		GridBagConstraints gbc_lblVotingTimer = new GridBagConstraints();
		gbc_lblVotingTimer.insets = new Insets(0, 0, 5, 5);
		gbc_lblVotingTimer.gridx = 1;
		gbc_lblVotingTimer.gridy = 1;
		panel_1.add(lblVotingTimer, gbc_lblVotingTimer);

		btnStartVoting = new JButton("Start Voting");
		GridBagConstraints gbc_btnStartVoting = new GridBagConstraints();
		gbc_btnStartVoting.insets = new Insets(0, 0, 0, 5);
		gbc_btnStartVoting.gridx = 1;
		gbc_btnStartVoting.gridy = 2;
		panel_1.add(btnStartVoting, gbc_btnStartVoting);

		btnPause = new JButton("Pause");
		GridBagConstraints gbc_btnPause = new GridBagConstraints();
		gbc_btnPause.insets = new Insets(0, 0, 0, 5);
		gbc_btnPause.gridx = 2;
		gbc_btnPause.gridy = 2;
		panel_1.add(btnPause, gbc_btnPause);

		btnStop = new JButton("Stop");
		GridBagConstraints gbc_btnStop = new GridBagConstraints();
		gbc_btnStop.insets = new Insets(0, 0, 0, 5);
		gbc_btnStop.gridx = 3;
		gbc_btnStop.gridy = 2;
		panel_1.add(btnStop, gbc_btnStop);

		btnAddNewItems = new JButton("Add New Items");
		GridBagConstraints gbc_btnAddNewItems = new GridBagConstraints();
		gbc_btnAddNewItems.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddNewItems.gridx = 4;
		gbc_btnAddNewItems.gridy = 2;
		panel_1.add(btnAddNewItems, gbc_btnAddNewItems);

		btnAddParticipants = new JButton("Add Participants");
		GridBagConstraints gbc_btnAddParticipants = new GridBagConstraints();
		gbc_btnAddParticipants.gridx = 5;
		gbc_btnAddParticipants.gridy = 2;
		panel_1.add(btnAddParticipants, gbc_btnAddParticipants);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);

		btnStartVoting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Thread worker = new Thread() {
					public void run() {
						// Something that takes a long time . . . in real life,
						// this
						// might be a DB query, remote method invocation, etc.
						try {

							// v.readVoteMessages().size();
							// System.err.println(v.readVoteMessages().size());

							System.err.println(x);
							x++;
							Thread.sleep(500);
							System.err.println(x);
						} catch (InterruptedException ex) {
						}

						// Report the result using invokeLater().
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								lblVotingTimer.setText(String.valueOf(x));
								// setEnabled(true);
							}
						});
					}
				};

				worker.start();

			}
		});

	}

}
