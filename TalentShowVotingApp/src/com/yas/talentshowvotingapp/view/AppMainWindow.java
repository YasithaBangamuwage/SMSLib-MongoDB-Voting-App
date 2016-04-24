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
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class AppMainWindow {

	private JFrame frame;
	private JButton btnLaunchEvent;
	private JButton btnEventHistory;
	private JPanel panel;

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
		frame.getContentPane().setBackground(new Color(0, 51, 51));
		frame.setBounds(100, 100, 305, 286);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 0, 0, 0));

		panel = new JPanel();
		panel.setBackground(new Color(0, 51, 51));
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblAppName = new JLabel("ON STAGE");
		lblAppName.setForeground(new Color(153, 153, 0));
		GridBagConstraints gbc_lblAppName = new GridBagConstraints();
		gbc_lblAppName.fill = GridBagConstraints.BOTH;
		gbc_lblAppName.gridx = 0;
		gbc_lblAppName.gridy = 0;
		panel.add(lblAppName, gbc_lblAppName);
		lblAppName.setBackground(new Color(102, 255, 0));
		lblAppName.setFont(new Font("Andalus", Font.BOLD, 30));
		lblAppName.setHorizontalAlignment(SwingConstants.CENTER);

		btnLaunchEvent = new JButton("Launch");
		btnLaunchEvent.setForeground(new Color(51, 153, 102));
		btnLaunchEvent.setBackground(new Color(255, 255, 255));
		btnLaunchEvent.setSelectedIcon(null);
		btnLaunchEvent.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 19));
		btnLaunchEvent.setHorizontalAlignment(SwingConstants.LEADING);

		frame.getContentPane().add(btnLaunchEvent);

		btnEventHistory = new JButton("History");
		btnEventHistory.setForeground(new Color(51, 153, 102));
		btnEventHistory.setBackground(new Color(255, 255, 255));
		btnEventHistory.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 20));
		btnEventHistory.setHorizontalAlignment(SwingConstants.LEADING);

		frame.getContentPane().add(btnEventHistory);

		/*********** events goes here ********************/

		btnLaunchEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AppController.getAppController().setAppStatus(AppStatus.EVENT_CREATING);
				AppController.getAppController().getEventController().getEventView().setVisible(Boolean.TRUE);
				AppController.getAppController().getEventController().setIsActiveFalseForEvents();
			}
		});

		btnEventHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppController.getAppController().setAppStatus(AppStatus.DEFAULT);
				AppController.getAppController().getEventHistoryController().getEventHistoryView()
						.setVisible(Boolean.TRUE);

				AppController.getAppController().getEventHistoryController().loadEventHistoryData();

			}
		});
	}

}
