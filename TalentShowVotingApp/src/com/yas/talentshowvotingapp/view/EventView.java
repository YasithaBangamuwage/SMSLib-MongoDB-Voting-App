package com.yas.talentshowvotingapp.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.yas.talentshowvotingapp.controller.AppController;
import com.yas.talentshowvotingapp.model.Event;
import com.yas.talentshowvotingapp.model.Item;
import com.yas.talentshowvotingapp.other.AppStatus;

public class EventView extends JFrame {

	private JPanel contentPane;
	private JTextField txtEventname;
	private JTextField txtOrganizername;
	private JButton btnNext;
	private JLabel lblStartDate;
	private JLabel lblInfo;
	private JButton btnCancel;
	private JButton btnAdd;

	/**
	 * Create the frame.
	 */
	public EventView() {
		 setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblStepCreateevent = new JLabel("Create Event");
		GridBagConstraints gbc_lblStepCreateevent = new GridBagConstraints();
		gbc_lblStepCreateevent.gridwidth = 2;
		gbc_lblStepCreateevent.fill = GridBagConstraints.VERTICAL;
		gbc_lblStepCreateevent.insets = new Insets(0, 0, 5, 0);
		gbc_lblStepCreateevent.gridx = 0;
		gbc_lblStepCreateevent.gridy = 0;
		contentPane.add(lblStepCreateevent, gbc_lblStepCreateevent);

		JLabel lblEventName = new JLabel("Event Name");
		GridBagConstraints gbc_lblEventName = new GridBagConstraints();
		gbc_lblEventName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEventName.anchor = GridBagConstraints.EAST;
		gbc_lblEventName.gridx = 0;
		gbc_lblEventName.gridy = 2;
		contentPane.add(lblEventName, gbc_lblEventName);

		txtEventname = new JTextField();
		GridBagConstraints gbc_txtEventname = new GridBagConstraints();
		gbc_txtEventname.insets = new Insets(0, 0, 5, 0);
		gbc_txtEventname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEventname.gridx = 1;
		gbc_txtEventname.gridy = 2;
		contentPane.add(txtEventname, gbc_txtEventname);
		txtEventname.setColumns(10);

		JLabel lblOrganizer = new JLabel("Organizer");
		GridBagConstraints gbc_lblOrganizer = new GridBagConstraints();
		gbc_lblOrganizer.anchor = GridBagConstraints.EAST;
		gbc_lblOrganizer.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrganizer.gridx = 0;
		gbc_lblOrganizer.gridy = 3;
		contentPane.add(lblOrganizer, gbc_lblOrganizer);

		txtOrganizername = new JTextField();
		GridBagConstraints gbc_txtOrganizername = new GridBagConstraints();
		gbc_txtOrganizername.insets = new Insets(0, 0, 5, 0);
		gbc_txtOrganizername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOrganizername.gridx = 1;
		gbc_txtOrganizername.gridy = 3;
		contentPane.add(txtOrganizername, gbc_txtOrganizername);
		txtOrganizername.setColumns(10);

		lblStartDate = new JLabel("Start Date");
		GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
		gbc_lblStartDate.anchor = GridBagConstraints.EAST;
		gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartDate.gridx = 0;
		gbc_lblStartDate.gridy = 4;
		contentPane.add(lblStartDate, gbc_lblStartDate);

		JLabel lblStartdate = new JLabel("      ");
		GridBagConstraints gbc_lblStartdate = new GridBagConstraints();
		gbc_lblStartdate.insets = new Insets(0, 0, 5, 0);
		gbc_lblStartdate.gridx = 1;
		gbc_lblStartdate.gridy = 4;
		contentPane.add(lblStartdate, gbc_lblStartdate);

		lblInfo = new JLabel("Info");
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.insets = new Insets(0, 0, 5, 0);
		gbc_lblInfo.gridx = 1;
		gbc_lblInfo.gridy = 6;
		contentPane.add(lblInfo, gbc_lblInfo);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 7;
		contentPane.add(panel, gbc_panel);

		btnCancel = new JButton("Cancel");

		panel.add(btnCancel);

		btnAdd = new JButton("Add");

		panel.add(btnAdd);

		btnNext = new JButton("Next >");
		panel.add(btnNext);

		btnNext.setEnabled(Boolean.FALSE);
		lblStartDate.setText(new Date().toLocaleString());

		/***************** action events goes here ***************/
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!txtEventname.getText().isEmpty() && !txtOrganizername.getText().isEmpty()) {
					// add event
					AppController.getAppController().getEventController()
							.addEvent(new Event(UUID.randomUUID().toString(), new Date(), null, txtEventname.getText(),
									txtOrganizername.getText(), Boolean.TRUE, new ArrayList<Item>()));
					// enable nextbtn
					btnNext.setEnabled(Boolean.TRUE);
					lblInfo.setText("Event add successfully.");
					btnAdd.setEnabled(Boolean.FALSE);

				} else {
					lblInfo.setText("Please fill the form.");
					btnAdd.setEnabled(Boolean.TRUE);
				}
			}
		});

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AppController.getAppController().getItemController().getItemView().setVisible(Boolean.TRUE);
				AppController.getAppController().getEventController().getEventView().setVisible(Boolean.FALSE);
				
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int dialogResult = JOptionPane.showConfirmDialog(null,
						"Are you sure you wants to cancel this event creating?", "Warning", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					AppController.getAppController().setAppStatus(AppStatus.DEFAULT);
					// set application into default mode.
					AppController.getAppController().getEventController().getEventView().setVisible(Boolean.FALSE);
					AppController.getAppController().setAppToDefaultMode();

				}

			}
		});
	}

}