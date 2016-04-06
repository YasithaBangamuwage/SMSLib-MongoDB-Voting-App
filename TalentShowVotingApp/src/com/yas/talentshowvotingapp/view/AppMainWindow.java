package com.yas.talentshowvotingapp.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.yas.talentshowvotingapp.controller.AppController;
import com.yas.talentshowvotingapp.other.AppStatus;

import java.awt.event.ActionListener;
import java.util.UUID;
import java.awt.event.ActionEvent;

public class AppMainWindow {

	private JFrame frame;
	private JButton btnLaunchEvent;
	private JButton btnEventHistory;
	private JButton btnConfigurations;

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppController.getAppController().getAppMainWindowController().getAppMainWindow().getFrame()
							.setVisible(Boolean.TRUE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public AppMainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 266, 314);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 0, 0, 0));

		JLabel lblAppName = new JLabel("Talent Show Voting App");
		frame.getContentPane().add(lblAppName);

		btnLaunchEvent = new JButton("Launch New Event");

		frame.getContentPane().add(btnLaunchEvent);

		btnEventHistory = new JButton("Event History");

		frame.getContentPane().add(btnEventHistory);

		btnConfigurations = new JButton("Configurations");
		frame.getContentPane().add(btnConfigurations);

		/*********** events goes here ********************/

		btnLaunchEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AppController.getAppController().setAppStatus(AppStatus.EVENT_CREATING);
				AppController.getAppController().getEventController().getEventView().setVisible(Boolean.TRUE);
			}
		});

		btnEventHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppController.getAppController().setAppStatus(AppStatus.DEFAULT);
				AppController.getAppController().getEventHistoryController().getEventHistoryView()
						.setVisible(Boolean.TRUE);
			}
		});
	}

}
